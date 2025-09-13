
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 좌표 압축
public class Main {
    // 그냥 좌표 오름차순으로 했을 때 몇번째로 작은 좌표인가를 의미하는 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] points = new int[N];
        List<Integer> sortedList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int point = Integer.parseInt(st.nextToken());
            points[i] = point;
            sortedList.add(point);
        }

        // 정렬
        Collections.sort(sortedList);

        // HashMap 에 좌표와 순위 (인덱스) 매핑
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for(int point : sortedList) {
            if(!map.containsKey(point)) {
                map.put(point, rank++); // 해당 좌표의 순위 저장
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int point : points) {
            sb.append(map.get(point)).append(" ");
        }

        System.out.println(sb);
    }
}