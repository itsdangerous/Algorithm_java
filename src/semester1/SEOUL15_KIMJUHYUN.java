package semester1;

import java.net.*;
import java.util.PriorityQueue;

import java.io.*;

public class SEOUL15_KIMJUHYUN {

    // 닉네임을 사용자에 맞게 변경해 주세요.
    static final String NICKNAME = "SEOUL15_KIMJUHYUN";

    // 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
    static final String HOST = "127.0.0.1";

    // 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
    static final int PORT = 1447;
    static final int CODE_SEND = 9901;
    static final int CODE_REQUEST = 9902;
    static final int SIGNAL_ORDER = 9908;
    static final int SIGNAL_CLOSE = 9909;

    // 게임 환경에 대한 상수입니다.
    static final int TABLE_WIDTH = 254;
    static final int TABLE_HEIGHT = 127;
    static final int NUMBER_OF_BALLS = 6;
    //    static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
    static final int[][] HOLES = { { 1, 1 }, { 126, 1 }, { 253, 1 }, { 1, 126 }, { 126, 126 }, { 253, 126 } };

    // custom 상수
    static final int DEFAULT_ANGLE = 40;
    static final int DEFAULT_POWER = 80;
    static final int NOT_EXIST = -1;
    static final int WHITE = 0;
    static final double R = 2.865;
    static final Vector UP = new Vector(0, 1);
    static final int[][] teamBall = {{1, 3, 5}, {2, 4, 5}};
    static final int BLACK = 5;

    static class Vector {
        double x, y;

        public Vector(double x, double y) {
            super();
            this.x = x;
            this.y = y;
        }

        // --------------------- [START] static method ---------------------

        // 벡터의 실수배
        static Vector mul(Vector v, double m) {
            return new Vector(v.x*m, v.y*m);
        }

        // 단위 벡터 만들기
        static Vector unit(Vector v) {
            double size = norm(v);
            System.out.printf("[unit] size : %f\n", size);
            return new Vector(v.x/size, v.y/size);
        }

        // 벡터 사이즈 재조정
        static Vector resize(Vector v, double size) {
            return mul(unit(v), size);
        }

        // 벡터 크기 구하기
        static double norm(Vector v) {
            return Math.sqrt(v.x*v.x + v.y*v.y);
        }

        // 두 점간 거리 구하기
        static double dist(Vector v1, Vector v2) {
            return norm(v1.sub(v2));
        }

        // 두 벡터 간 내적
        static double dot(Vector v1, Vector v2) {
            return v1.x*v2.x + v1.y*v2.y;
        }

        static double unitDot(Vector v1, Vector v2) {
            return dot(Vector.unit(v1), Vector.unit(v2));
        }

        // 두 벡터간 각도 구하기
        static double angle(Vector v1, Vector v2) {
            double cos = dot(v1,v2) / (norm(v1)*norm(v2));
            System.out.printf("cos : %f\n", cos);
            double radAngle = Math.acos(cos);
            double degreeAngle = Math.toDegrees(radAngle);
            return degreeAngle;
        }

        static double shotAngle(Vector v) {
            double shotAng = angle(UP, v);
            if (v.x < 0) {
                if (shotAng < 0) {
                    shotAng += 360;
                }
                shotAng = 360 - shotAng;
            }
            return shotAng;
        }

        // --------------------- [END] static method ---------------------

        // 현재 벡터에서 목적지까지의 벡터 구하기
        public Vector sub(Vector o) {
            return new Vector(o.x - this.x, o.y-this.y);
        }
    }

    static class Path {
        Vector from, to;
        Vector d;

        public Path(Vector from, Vector to) {
            this.from = from;
            this.to = to;
            this.d = from.sub(to);
        }

        public Vector pathVector() {
            return d;
        }

        // 벡터와 한 점간의 거리 구하기
        public double distToPoint(Vector point) {
            Vector crossIntersection = findCross(point.x, point.y);
            return Vector.norm(point.sub(crossIntersection));
        }

        // 벡터와 한 점간의 수직 교점 찾기
        public Vector findCross(double x, double y) {
            double t = ((x-from.x)*d.x + (y-from.y)*d.y) / (d.x*d.x + d.y*d.y);
            double crossX = d.x*t + from.x - x;
            double crossY = d.y*t + from.y - y;
            return new Vector(crossX, crossY);
        }

        // 해당 경로로 가기 위한 수구의 도착 지점 찾기
        public Vector findArrival() {
            return Vector.resize(d, 2*R).sub(from);
        }
    }

    static class Shot implements Comparable<Shot> {
        double angle;
        double dotResult;
        Vector hole;
        double dist;
        double distToHole;

        public Shot(double angle, double dotResult, Vector hole, double dist, double distToHole) {
            super();
            this.angle = angle;
            this.dotResult = dotResult;
            this.hole = hole;
            this.dist = dist;
            this.distToHole = distToHole;
        }

        @Override
        public int compareTo(Shot o) {

            // 1. 둘다 내적 값이 0.7 이상일 때, 거리(distToHole)순 정렬
            if (this.dotResult > 0.7 && o.dotResult > 0.7) {
                return Double.compare(this.distToHole, o.distToHole);
            } else if (this.dotResult > 0.7 || o.dotResult > 0.7) { // 2. 한명만 0.7 이상이면 내적 큰게 우선
                return Double.compare(o.dotResult, this.dotResult);
            } else if (Math.abs(this.dotResult - o.dotResult) < 0.15) { // 3. 둘다 0.7 이하이면 0.1 이하로 차이나면 거리 우선
                return Double.compare(this.distToHole, o.distToHole);
            } else { // 4. 둘다 0.7 이하이고 내적값이 0.15 차이 이상 나면 내적 큰게 우선
                return Double.compare(o.dotResult, this.dotResult);
            }
        }
    }

    public static void main(String[] args) {

        Socket socket = null;
        String recv_data = null;
        byte[] bytes = new byte[1024];
        float[][] balls = new float[NUMBER_OF_BALLS][2];
        int order = 0;

        try {
            socket = new Socket();
            System.out.println("Trying Connect: " + HOST + ":" + PORT);
            socket.connect(new InetSocketAddress(HOST, PORT));
            System.out.println("Connected: " + HOST + ":" + PORT);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            String send_data = CODE_SEND + "/" + NICKNAME + "/";
            bytes = send_data.getBytes("UTF-8");
            os.write(bytes);
            os.flush();
            System.out.println("Ready to play!\n--------------------");

            while (socket != null) {

                // Receive Data
                bytes = new byte[1024];
                int count_byte = is.read(bytes);
                recv_data = new String(bytes, 0, count_byte, "UTF-8");
                System.out.println("Data Received: " + recv_data);

                // Read Game Data
                String[] split_data = recv_data.split("/");
                int idx = 0;
                try {
                    for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                        for (int j = 0; j < 2; j++) {
                            balls[i][j] = Float.parseFloat(split_data[idx++]);
                        }
                    }
                } catch (Exception e) {
                    bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
                    os.write(bytes);
                    os.flush();
                    System.out.println("Received Data has been currupted, Resend Requested.");
                    continue;
                }

                // Check Signal for Player Order or Close Connection
                if (balls[0][0] == SIGNAL_ORDER) {
                    order = (int)balls[0][1];
                    System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
                    continue;
                } else if (balls[0][0] == SIGNAL_CLOSE) {
                    break;
                }

                // Show Balls' Position
                for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                    System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
                }

                float angle = 0.0f;
                float power = 0.0f;

                //////////////////////////////
                // 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
                //
                // 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
                //   - order: 1인 경우 선공, 2인 경우 후공을 의미
                //   - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
                //     예) balls[0][0]: 흰 공의 X좌표
                //         balls[0][1]: 흰 공의 Y좌표
                //         balls[1][0]: 1번 공의 X좌표
                //         balls[4][0]: 4번 공의 X좌표
                //         balls[5][0]: 마지막 번호(8번) 공의 X좌표

                // 여기서부터 코드를 작성하세요.
                // 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

//                printBalls(balls);

                Vector from = new Vector(balls[WHITE][0], balls[WHITE][1]);

                int ballCount = 0;
                PriorityQueue<Shot> pq = new PriorityQueue<>();

                // 1. 공마다
                ballLoop : for (int i : teamBall[order-1]) {

                    // 2개를 넣을 때 까지는 검은 공을 건드리면 안된다.
                    if (i == BLACK && countBall(balls, order-1) > 0) {
                        continue;
                    }

                    System.out.printf("볼 번호 : %d 번 시작!!!!!!!!!!!!!!\n", i);
                    // 만약 공이 없다면 continue
                    if (balls[i][0] == NOT_EXIST) {
                        System.out.println("XXX 이 번호의 공은 없습니다!! XXX\n");
                        continue;
                    }
                    Vector nowBall = new Vector(balls[i][0], balls[i][1]);

                    // 2. Hole 마다
                    for (int[] hole : HOLES) {
                        System.out.printf("@@hole (%d, %d) 에 대해 탐색 시작 @@\n", hole[0], hole[1]);
                        Path path = new Path(
                                nowBall,
                                new Vector(hole[0], hole[1])
                        );
                        Vector whiteGoalPos = path.findArrival();
                        Vector shot = from.sub(whiteGoalPos);

                        double dotResult = Vector.unitDot(path.pathVector(), shot);

                        // path 와 shot의 내적이 0보다 작거나 같으면 못 치는 공이므로 continue
                        if (dotResult <= 0) {
                            System.out.printf("내적값이 %f으로 음수이기 때문에 해당 hole에는 들어갈 수 없습니다.\n", dotResult);
                            continue;
                        }

                        // 쳐야되는 각 정해주기
                        angle = (float) Vector.shotAngle(from.sub(whiteGoalPos));
                        pq.add(new Shot(angle, dotResult, new Vector(hole[0], hole[1]), Vector.dist(from, whiteGoalPos), Vector.norm(path.d)));
                        System.out.printf("칠 공 좌표 : (%f, %f)\n", nowBall.x, nowBall.y);
                        System.out.printf("구멍 좌표 : (%d, %d)\n", hole[0], hole[1]);
                        System.out.printf("하얀 공 좌표 : (%f, %f)\n", from.x, from.y);
                        System.out.printf("하얀 공 목적지 좌표 : (%f, %f)\n", whiteGoalPos.x, whiteGoalPos.y);
                        System.out.printf("목적구에서 구멍까지 거리 : %f\n",  Vector.norm(path.d));
                        System.out.printf("샷 벡터 및 angle : (%f, %f), angle : %f\n", shot.x, shot.y, angle);
                        System.out.printf("내적 값 : %f\n\n", Vector.dot(path.pathVector(), shot));
                    }
                }

                boolean selectedFlag = false;
                Shot bestShot;

                // 모든 구멍에 대한 탐색이 끝난 후 가장 좋은 Shot의 angle을 정해준다.
                System.out.println("########################## shot ##########################");
                if (pq.isEmpty()) {
                    angle = DEFAULT_ANGLE;
                    System.out.println("기본 각도 선택!!!");
                    bestShot = new Shot(DEFAULT_ANGLE, -1, new Vector(-1, -1), -1, -1);
                } else {
                    bestShot = pq.poll();
                    angle = (float) bestShot.angle;
                    System.out.printf("목적구에서 구멍까지 거리 : %f\n",  bestShot.distToHole);
                    System.out.printf("hole : (%f, %f), 선택된 angle : %f dist : %f, 내적 : %f\n", bestShot.hole.x, bestShot.hole.y,angle, bestShot.dist, bestShot.dotResult);
                    selectedFlag = true;
                }

                // 2. 파워 정하기
                power = DEFAULT_POWER;
                if (selectedFlag) {
                    power = (int) Math.max(bestShot.dist, bestShot.distToHole);
                }



                // 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
                // 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
                //   - angle: 흰 공을 때려서 보낼 방향(각도)
                //   - power: 흰 공을 때릴 힘의 세기
                //
                // 이 때 주의할 점은 power는 100을 초과할 수 없으며,
                // power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
                //
                // 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
                //////////////////////////////

                String merged_data = angle + "/" + power + "/";
                bytes = merged_data.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("Data Sent: " + merged_data);
            }

            os.close();
            is.close();
            socket.close();
            System.out.println("Connection Closed.\n--------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printBalls(float[][] balls) {
        System.out.printf("개수 : %d개\n", balls.length);
        for (float[] ball : balls) {
            System.out.printf("(%f, %f) ",ball[0], ball[1]);
        }
        System.out.println();
    }

    public static int countBall(float [][] balls, int order) {
        int count = 0;
        for (int i : teamBall[order]) {
            if (i == BLACK) {
                continue;
            }

            if (balls[i][0] != NOT_EXIST) {
                count++;
            }
        }
        return count;
    }


}