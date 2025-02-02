
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

        // 내 문제 풀이 
//        int resM;
//        int resH;
//
//        if((m + c) >= 60) {
//
//            resM = (m + c) % 60;
//            resH = ((m + c) / 60) + h;
//
//
//            if (resH >= 24) {
//                resH = resH - 24;
//            }
//        } else {
//            resM = m + c;
//            resH = h;
//        }
//
//        System.out.println(resH + " " + resM);
//
         
        // 다른 사람 문제 풀이
        int resH = h + (m + c) / 60;

        /**
         *  60을 넘어가는 조건을 안 걸어도 m+c >= 60 이 아니라면 
         *  나머지는 그대로 m+c 가 되기 때문에 조건을 걸 필요가 없었다.
         * */
        int resM = (m + c) % 60;

        
        if (resH >= 24) {
            resH -= 24;
        }
        
        System.out.println(resH + " " + resM);
    }        
}