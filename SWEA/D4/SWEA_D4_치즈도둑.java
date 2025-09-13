package SWEA.D4;

import java.util.Scanner;

public class SWEA_D4_치즈도둑 {

    static int[][] cheese;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 테스트케이스 입력받기
        int T = sc.nextInt();

        for(int t = 1; t <= T; t++) {
            // 치즈 한변의 길이
            N = sc.nextInt();
            cheese = new int[N][N];

            // 치즈의 맛있는 정도 담기
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    cheese[i][j] = sc.nextInt();
                }
            }

            // 치즈 덩어리 최댓값 초기화
            int maxChunks = 0;

            // 0일차부터 100일차까지 확인
            for(int day = 0; day <= 100; day++) {
                int chunks = countChunks(day);
                maxChunks = Math.max(maxChunks, chunks);
            }


            // 출력
            System.out.println("#" + t + " " + maxChunks);
        }
    }

    // 특정 날짜에 남은 치즈 덩어리가 몇개인지 세기
    private static int countChunks(int day) {
        visited = new boolean[N][N]; // 방문처리
        int chunkCount = 0;  // 덩어리 개수

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 아직 먹히지 않았고 방문하지 않은 칸 일 경우
                if(cheese[i][j] > day && !visited[i][j]) {
                    dfs(i, j ,day);
                    chunkCount++;
                }
            }
        }

        return chunkCount;
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    private static void dfs(int x, int y, int day) {

        visited[x][y] = true;

        // 상하좌우 이동
        for (int k = 0; k < 4; k++) {
            // 다음좌표 nx, ny 생성
            int nx = x + dx[k];
            int ny = y + dy[k];

            // 아직 방문하지 않은 지점 방문!
            if (0 <= nx && 0 <= ny && nx < N  && ny < N
                    && !visited[nx][ny] && cheese[nx][ny] > day) {
                dfs(nx, ny, day);
            }
        }
    }


}