import java.util.*;

public class CompareTest {
    static class P {
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "P [x=" + x + ", y=" + y + "]";
        }

        public int compareTo(P p) {
            double l1 = Math.sqrt(this.x * this.x + this.y * this.y);
            double l2 = Math.sqrt(p.x * p.x + p.y * p.y);
            return Double.compare(l1, l2);
        }
    }

    public static void main(String[] args) {
//        List<P> points = new ArrayList<P>();
        Queue<P> points = new PriorityQueue<>();

        points.add(new P(1, 5));
        points.add(new P(3, 4));
        points.add(new P(-3, -4));
        points.add(new P(2, -5));
        points.add(new P(-2, -5));

        while (!points.isEmpty()) {
            System.out.println(points.poll());

        }

//        points.sort(new Comparator<P>() {
//            @Override
//            public int compare(P o1, P o2) {
//                double l1 = Math.sqrt(o1.x * o1.x + o1.y * o1.y);
//                double l2 = Math.sqrt(o2.x * o2.x + o2.y * o2.y);
//
//                return Double.compare(l1, l2);
//            }
//        });
//
//        for(P p : points)
//            System.out.println(p);
//    }

    }
}
