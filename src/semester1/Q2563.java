package semester1;

import java.util.Scanner;

class Q2563 {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            String str = sc.nextLine();

            int i = 0;
            int cnt = 1;
            int blank = 4;
            if (str.equals("1")) {
                while (i <= 10) {
                    for (int j = 0; j < cnt; j++) {
                        System.out.print(i++ + " ");
                    }
                    System.out.println();
                    cnt++;

                }
            } else if (str.equals("a")) {

                while (i < 15) {

                    for (int j = 0; j < blank; j++) {
                        System.out.print("  ");
                    }

                    blank--;
                    for (int j = 0; j < 4-blank; j++) {
                        System.out.print((char)(97+i++) + " ");
                    }
                    System.out.println();
                }
            }
    }
}