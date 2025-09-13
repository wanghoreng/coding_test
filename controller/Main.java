package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 배추밭에서 배추가 모여있는 덩어리의 개수를 세는 프로그램

    // 1. 배추밭 N, M 과 배추가 심어져있는 위치의 개수 K
    // 2. K줄만큼 배추의 좌표 x, y 가 주어짐
    static int[][] map;
    static boolean[][] visited;
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                // 배추밭 위치에 배추있는 곳을 1로 표기
                map[r][c] = 1;
            }

            int bug = 0;
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++) {
                    // 인접하지 않은 곳 중 방문하지 않은 곳을 방문!
                    if(map[r][c] == 1 && !visited[r][c]) {
                        dfs(r,c);
                        bug++;
                    }
                }
            }

            System.out.println(bug);
        }
    }

    private static void dfs(int r, int c) {

        // 상하좌우 델타 배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c}); // 0, 0 저장
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll(); // 현재 좌표
            int x = curr[0];
            int y = curr[1];

            for(int i = 0; i < 4; i++) {
                int nr = x + dx[i];
                int nc = y + dy[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M
                    || map[nr][nc] == 0 || visited[nr][nc])
                    continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}