import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


// 숫자 카드
public class Main {
    // 상근이는 숫자카드 N 개를 갖고있음
    // 정수 M 개가 주어졌을 때, 상근이가 이 수를 갖고 있는지 아닌지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        Map<Integer, Integer> cards = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cards.put(Integer.parseInt(st.nextToken()), i);
        }

        int M =Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < M; j++) {
            int compareCard = Integer.parseInt(st.nextToken());
            sb.append(cards.containsKey(compareCard) ? 1 : 0).append(" ");
        }

        System.out.println(sb);
    }

}