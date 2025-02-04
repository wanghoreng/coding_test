import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;



public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        // 1. Stream max, min 값 가져오기 => 488ms (Stream 은 너무 느림)
//        int max = Arrays.stream(x).max().getAsInt();
//        int min = Arrays.stream(x).min().getAsInt();

        // 2. 배열에서 min, max 값 가져오기 => 464ms
//        int max = x[0];
//        int min = x[0];
//        for(int i = 0; i < n; i++) {
//            if(max < x[i]) {
//                max = x[i];
//            }
//            if(min > x[i]) {
//                min = x[i];
//            }
//        }

        // 3. Math.max(), Math.min() 을 쓰는 방법
        int min = x[0];
        int max = x[0];

        for(int a:x) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }

        System.out.println(min + " " + max);
    }
}