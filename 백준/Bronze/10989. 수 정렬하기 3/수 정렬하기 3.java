import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 수 정렬하기 3
public class Main {
    // N 은 10,000이 최대
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 카운트 정렬
        int[] count = new int[10001];
        for(int i = 0; i < N; i++) {
            int index = Integer.parseInt(br.readLine());
            count[index]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10001; i++) {
            while(count[i] != 0) {
                sb.append(i).append("\n");
                count[i]--; 
            }
        }

        System.out.println(sb);
    }
}