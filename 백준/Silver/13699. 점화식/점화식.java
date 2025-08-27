
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];
        dp[0] = 1;
        // 0 * n - 1, 1 * n - 2 .. 하나는 0에서부터 증가, 곱해지는 수는 n에서 부터 작아지는 수
        for(int n = 1; n <= N; n++) {
            long sum = 0;
            for (int i = 0, j = n - 1; i < n; i++) {
                sum += dp[i] * dp[j];
                j--;
            }

            dp[n] = sum;
        }

        System.out.println(dp[N]);
    }

}
