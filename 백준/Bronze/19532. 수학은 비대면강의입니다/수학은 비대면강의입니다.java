import java.util.Scanner;

class Main {
    // a b c d e f
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        out:
        for(int x = -999; x <= 999; x++) {
            for(int y = -999; y <= 999; y++) {
                if(a * x + b * y == c
                        && d * x + e * y == f) {
                    sb.append(x).append(" ").append(y);
                    break out;
                }
            }
        }

        System.out.println(sb);

    }
}