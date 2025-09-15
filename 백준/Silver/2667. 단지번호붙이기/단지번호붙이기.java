
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 1 : 집 있음, 0 : 집 없음
    // 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우 (상하좌우) 단지로 표시
    // 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력
    static int[][] apartments;
    static int[][] dist;
    static int N;
    static List<Integer> complexCountList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 첫째줄 지도의 크기 N
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        apartments = new int[N][N];
        dist = new int[N][N];

        // 아파트 집 배열 담기
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                apartments[i][j] = line.charAt(j) - '0';
            }
        }



        int complex = 1; // 단지 수 입력하기 위한 배열
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 아직 방문을 안한 상태
                if(apartments[i][j] == 1) {
                    bfs(i, j, ++complex);
                }
            }
        }

        Collections.sort(complexCountList);
        sb.append(complex-1).append("\n");
        for(int count : complexCountList) {
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());

    }

    private static void bfs(int r, int c, int complex) {
        // 델타 배열
        final int[] dr = {-1, 1, 0, 0};
        final int[] dc = {0, 0, -1, 1};
        int complexCount = 1; // 단지 내 집의 개수 세기 위한 배열

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        // 방문 했슴!
        apartments[r][c] = complex;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int d = 0; d < 4; d++) {
                int nr = x + dr[d];
                int nc = y + dc[d];

                // 범위 내가 아니거나, 벽이거나, 방문했다면
                if(nr < 0 || nc < 0 || nr >= N || nc >= N
                        || apartments[nr][nc] == 0 || apartments[nr][nc] == complex)
                    continue;

                q.add(new int[]{nr, nc});
                apartments[nr][nc] = complex;
                complexCount++;
            }
        }

        complexCountList.add(complexCount);
    }
}