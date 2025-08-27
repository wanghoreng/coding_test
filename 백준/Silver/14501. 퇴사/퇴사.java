
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dayPrice = new int[N+1][2]; // 1 ~ N

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dayPrice[i][0] = Integer.parseInt(st.nextToken()); // day
            dayPrice[i][1] = Integer.parseInt(st.nextToken()); // price
        }

        // dp 계산
        int[] dp = new int[N+2]; // 1~N+1 퇴사 당일까지 포함

        // 퇴사 당일
        dp[N+1] = 0;
        int res = 0;
        for(int i = N; i >= 0; i--) {
            int day = dayPrice[i][0];
            int price = dayPrice[i][1];

            if(i + day > N+1) { // 우선 퇴사 전날/ 퇴사 당일까지 상담 가능? 체크 필요
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max((price + dp[i+day]), dp[i+1]);
            }

            res = Math.max(dp[i], res);
        }

        System.out.println(res);
    }

}
