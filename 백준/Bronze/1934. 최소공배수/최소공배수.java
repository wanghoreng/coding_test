import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최소 공배수 => 최대 공약수를 알면 빠르게 구할 수 있는 문제?
public class Main {
    // A 의 배수 이면서 B 의 배수인 자연수를 A와 B의 공배수라고 한다.
    // 이런 공배수 중에서 가장 작은 수를 최소 공배수 라고 한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int num = 1;
            int sum = 1;
            while(a >= num && b >= num) {
                num += 1;
                if(a % num == 0 && b % num == 0) { // num = 3, a = 2, b = 5
                    sum *= num;
                    a /= num;
                    b /= num;
                    num = 1;        // 나눌 숫자를 다시 반복하기 위해
                }
            }
            System.out.println(sum * a * b);
        }
    }
}