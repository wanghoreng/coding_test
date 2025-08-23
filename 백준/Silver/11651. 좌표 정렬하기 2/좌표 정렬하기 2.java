import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 좌표 정렬2
public class Main {
    // 좌표 정렬 1과는 다르게, 좌표는 Y 좌표가 증가하는 순으로 봄
    // y 좌표가 같을 시 x 좌표가 증가하는 순서로 정렬한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2]; // [0] : x, [1] : y

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] =  Integer.parseInt(st.nextToken());
            points[i][1] =  Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] p1, int[] p2) {

                // y 좌표 비교
                if(p1[1] == p2[1]) { // 같다면 x 좌표 비교
                    return p1[0] - p2[0];
                }
                return p1[1] - p2[1];
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}