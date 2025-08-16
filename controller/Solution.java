package controller;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    // 상하좌우
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    // 상우측 대각선, 하우측 대각선, 상좌측 대각선, 하좌측 대각선
    static int[] dy2 = {-1,1,-1,1};
    static int[] dx2 = {-1,-1,1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] board = new int[N][N];

            // 배열 담기
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 최대 상하좌우 파리 수
            int maxKillOriginal = Integer.MIN_VALUE;
            // 최대 대각선 파리 수
            int maxKillPlus = Integer.MIN_VALUE;

            // r, c = 3,3
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    int sum = board[r][c]; // 12
                    for(int d = 0; d < 4; d++) { // d= 0
                        for(int m = 1; m < M; m++) {
                            int nr = r + dy[d] * m; // 2 + -1 = 2
                            int nc = c + dx[d] * m; // 3 + 0 = 3
                            if(nr >= 0 && nr < N && nc >= 0 && nc < N)
                                sum += board[nr][nc]; // 12
                        }
                    }// 상하좌우 탐색
                    maxKillOriginal = Math.max(sum, maxKillOriginal);

                    sum = board[r][c]; // 12
                    for(int d = 0; d < 4; d++) { // d= 0
                        for(int m = 1; m < M; m++) {
                            int nr = r + dy2[d] * m; // 2 + -1 =1
                            int nc = c + dx2[d] * m; // 2 + 0 = 2

                            if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                sum += board[nr][nc];
                            }
                        }
                    }// 대각선 탐색
                    maxKillPlus = Math.max(sum, maxKillPlus);
                } // 가로 이동
            } // 세로 이동
            maxKillOriginal = Math.max(maxKillPlus, maxKillOriginal);

            // 출력
            System.out.println("#" + t + " " + maxKillOriginal);
        }
    } // main
}