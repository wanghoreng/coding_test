
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int h, m;
        h = sc.nextInt();
        m = sc.nextInt();

        // m - 45 가 0보다 작으면 h - 1
        // m - 45 가 0과 같거나 크면 h 는 그대로

        if (m - 45 < 0) {
            // h-1
            // m - 45 + 60
            if(h == 0)
                h = h + 24;

            System.out.println((h-1) + " " + (m-45+60));

        } else {
            System.out.println(h + " " + (m-45));
        }

    }
}