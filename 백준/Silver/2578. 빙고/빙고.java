
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] board = new int[5][5];
    public static void main(String[] args) throws IOException {
        // 조건 !
        // 빙고 3개가 되면 빙고라고 외치게 됨
        // 출력
        // 사회자가 몇번째 수를 부른 후 "빙고" 를 외치게 되는지 해당 수를 출력하기

        // 입력
        // 1 ~ 5. 빙고판에 쓰여진 수가 주어짐 (1 ~ 25)
        // 6 ~ 10. 사회자가 부르는 수가 주어짐 (1 ~ 25)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 빙고판 담기
        for(int n = 0; n < 5; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int m = 0; m < 5; m++) {
                board[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 1;
        for(int n = 0; n < 5; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int m = 0; m < 5; m++) {
                // 사회자가 부르는 수
                int num = Integer.parseInt(st.nextToken());
                // 빙고판에서 해당 수를 찾아서 0으로 변경
                changeZero(num);

                if(searchBingo() >= 3) { // 한 숫자를 부르는 동시에 4개가 될 수 있음
                    System.out.println(res);
                    return;
                }
                else { // 빙고라인 3번째가 될 때까지 사회자가 부른 수 체크
                    res++;
                }
            }
        }
        // 출력
    } // main

    // 빙고판에서 해당 수를 찾아서 0으로 변경하는 메서드
    private static void changeZero(int num) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(board[i][j] == num) {
                    board[i][j] = 0;
                    return; // 찾고 변경하면 바로 반복문 종료
                }
            }
        }
    }

    // 한줄 빙고가 되었는지 확인하는 메서드
    private static int searchBingo() {

        // 0으로 변경된 칸을 모두 검색

        // 한줄 빙고 조건(가로 검색, 세로 검색, 우하 대각선 검색, 좌하 대각선 검색)
        int[] dy = {0, 1, 1, 1};
        int[] dx = {1, 0, 1, -1};


        int bingo = 0;

        for(int d = 0; d < 4; d++) {
            int r = 0;
            int c = 0;
            for(int i = 0; i < 5; i++) {
                if(d == 0) r = i; // 가로인경우 r 이 늘어나야함
                else if(d == 1) c = i; // 세로인 경우 c 가 늘어나야함
                else if(d == 3) c = 4;

                int count = 0;
                int index = 0;
                while(index < 5) {
                    int nr = r + dy[d] * index;
                    int nc = c + dx[d] * index;

                    if(nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && (board[nr][nc] == 0)) {
                        count++;
                    }
                    index++;
                }

                if(count == 5) { // 한줄 빙고 시
                    bingo++;
                }

                if(d == 2 || d == 3) break; // i를 여러번 할 필요 X
            }
        }
        return bingo;
    }
}