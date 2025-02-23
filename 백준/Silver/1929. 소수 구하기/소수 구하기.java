import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        // 내풀이
        /*
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        List<Integer> answerList = new ArrayList<>();
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);

        if(m == 1) {
            m += 1;
        } else if (m == 0) {
            m += 2;
        }

        for(int i = m; i <= n; i++) {
            boolean flag = true;
            for(int j = 2; j*j <= i; j++) {    // 나누려는 값이 j의 제곱보다 작을 때만 for 문이 돌게함(그보다 클 때는 의미 없음)
                if(i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                answerList.add(i);
            }
        }

        for(int i :answerList) {
            System.out.println(i);
        }
         */


        // 아리스토테네스의 체 풀이법
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[n+1];
        prime[0] = true;
        prime[1] = true;

        // 1. 주어진 n 보다 i 의 제곱이 작을 때만 실행 
        for(int i = 2; i*i < prime.length; i++) {
            if(prime[i]) continue;
            // 2. i 의 배수들 모두 true 로 만들기  
            for(int j = i*i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        for(int i = m; i<=n; i++) {
            // 3. false 인 값만 출력 
            if(!prime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);

    }
}