
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int h, m, c;
        h = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        // 1. 현재시각 시, 분
        // 2. 요리필요시간 분

        int resM;
        int resH;

        if((m + c) >= 60) {

            resM = (m + c) % 60;
            resH = ((m + c) / 60) + h;


            if (resH >= 24) {
                resH = resH - 24;
            }
        } else {
            resM = m + c;
            resH = h;
        }

        System.out.println(resH + " " + resM);

    }
}