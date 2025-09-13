
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // N, M 위치로 이동할 수 있는 최소의 칸 수 구하는 프로그램
    // 1. N, M
    // 0 은 벽, 1은 갈 수 있는 길
    static int[][] miro;
    static int[][] dist;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N][M];
        dist = new int[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j ++) {
                miro[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int r, int c) {

        // 상하좌우 델타 배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c}); // 0, 0 저장
        dist[r][c] = 1;

        while(!q.isEmpty()) {
            int[] curr = q.poll(); // 현재 좌표
            int x = curr[0];
            int y = curr[1];

            // 종료 조건
            if(x == N-1 && y == M-1) {
                return dist[N-1][M-1];
            }

            for(int i = 0; i < 4; i++) {
                int nr = x + dx[i];
                int nc = y + dy[i];

                // 범위 내가 아니라면 넘기기
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                // 벽이라면 넘기기
                if(miro[nr][nc] == 0) continue;

                // 이미 구한 값이라면 또 넘기기
                if(dist[nr][nc] != 0) continue;

                // 그게 아니라면 칸 수 세기
                dist[nr][nc] = dist[x][y] + 1;   // 현재 좌표에서 +1 해서 기록 
                q.add(new int[]{nr, nc});
            }
        }

        return -1;
    }
}