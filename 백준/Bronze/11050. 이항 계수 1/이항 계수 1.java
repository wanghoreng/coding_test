import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        nCr(N, K);
        System.out.println(count);
    }

    private static void nCr(int n, int k) {
        // 종료조건
        if(k == 0) {
            // 출력
            count++;
            return;
        }

        if(n <= 0) return;

        nCr(n-1, k-1);

        nCr(n-1, k);
    }
}