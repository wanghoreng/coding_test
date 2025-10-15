
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 소수
public class Main {
    public static void main(String[] args) throws IOException {
        // M 이상 N 이하 까지의 숫자 중 소수의 총합 과 최솟값 찾는 프로그램
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        // 소수는 1과 본인만 나누어지는 숫자
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int num = M; num <= N; num++) {
            boolean flag = true;
            for(int i = 1; i <= num; i++) {
                if(num % i == 0 && i != 1 && i != num) {
                    flag = false;
                    break;
                }
            }

            if(flag && num != 1) {
                sum += num;
                if(num < min) min = num;
            }
        }


        System.out.println(sum==0 ? -1: sum + "\n" + min);
    }
}