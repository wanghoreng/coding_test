import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 문자열 집합
public class Main {
    // N 개의 문자열로 이루어진 집합 S
    // 입력으로 주어지는 M 개의 문자열 중 집합 S 에 포함되어 있는 것이 총 몇개 인가 ?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> strMap = new HashMap<>();
        for(int n = 0; n < N; n++) {
            strMap.put(br.readLine(), n);
        }

        int count = 0;
        for(int m = 0; m < M; m++) {
            count += strMap.containsKey(br.readLine()) ? 1 : 0;
        }
        System.out.println(count);
    }

}