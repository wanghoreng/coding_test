package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class SWEA_D4_미로1 {
    // 출발점 ~ 도착지점까지 갈 수 있는 길이 있는지 판단하는 프로그램
    // 1 : 벽 / 2 : 출발점 / 3 : 도착점
    // 10 개의 테케
    static final int TC = 10;
    static int[][] miro = new int[16][16];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 1; t <= TC; t++) {
            br.readLine();

            int r = 0;
            int c = 0;

            // 미로 담기
            for(int i = 0; i < 16; i++) {
                String line = br.readLine();
                for(int j = 0; j < 16; j++) {
                    int number = line.charAt(j) - '0';
                    miro[i][j] =  number;
                    if(number == 2) { // 출발점 좌표 담아두기
                       r = i;
                       c = j;
                    }
                }
            }

            // 출력
            System.out.println("#" + t + " " + (dfs(r,c) ? 1 : 0));

        }
    }

    private static boolean dfs(int r, int c) {

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r,c});


        while(!q.isEmpty()) {

            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int d = 0; d < 4; d++) {
                int nr = x + dr[d];
                int nc = y + dc[d];

                if(nr < 0 || nc < 0 || nr >= 16 || nc >= 16
                || miro[nr][nc] == 1 || miro[nr][nc] == 2) continue;

                if(miro[nr][nc] == 3) return true;

                miro[nr][nc] = 2;
                q.offer(new int[] {nr, nc});
            }

        }
        return false;
    }
}
