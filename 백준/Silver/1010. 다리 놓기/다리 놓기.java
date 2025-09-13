
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long count = nCr(M, N);
            System.out.println(count);
        }
    }


    private static long nCr(int n, int r) {

        // 1. r > n - r -> n-r 로 진행
        if(r > n - r) r = n-r;

        if(r == 0) return 1;

        // 2. n 을 r만큼 줄여가면서 누적곱 (n : 6, r : 2 -> 6 X 5 까지)
        long total = 1;
        for(int i = 0; i < r; i++) {
            total *= (n - i);
        }

        long rNum = 1;
        for(int j = r; j >= 1; j--) {
            rNum *= j;
        }

        // 3. 해당 total 에 r 로 나눔
        return total / rNum;
    }

}