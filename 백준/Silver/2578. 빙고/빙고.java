
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
//    static int[][] board = new int[5][5];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방법 2. 카운터 배열 사용
        // 빙고판과 숫자의 위치를 저장할 배열
        int[][] board = new int[5][5];
        int[][] position = new int[26][2]; // 숫자의 좌표를 저장(1~25)

        // 빙고판 담기
        for (int r = 0; r < 5; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                int num = Integer.parseInt(st.nextToken());
                board[r][c] = num;
                position[num][0] = r;   // 행 좌표
                position[num][1] = c;   // 열 좌표
            }
        }

        // 각 라인의 빙고 상태를 카운트할 배열
        int[] rows = new int[5];
        int[] cols = new int[5];
        int diag1 = 0;    // 우하 대각선
        int diag2 = 0;    // 좌하 대각선

        // 빙고라인 개수
        int bingoCount = 0;

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                int r = position[num][0];   // 행 인덱스 가져오기
                int c = position[num][1];   // 열 인덱스 가져오기

                // 해당 위치의 숫자를 0으로 변경
                board[r][c] = 0;

                // 가로줄 카운트
                if(++rows[r] == 5) { // [0,0,0,0,0] 에서 row[0] : 가로줄 첫번째 행을 의미
                    bingoCount++;
                }

                // 세로줄 카운트
                if(++cols[c] == 5) { // [0,0,0,0,0] 에서 cols[0] : 세로줄 첫번째 열을 의미
                    bingoCount++;
                }
                
                // 우하 대각선 줄 카운트 
                if(r == c) {    // 우하 대각선은 [0,0],[1,1]..[N,N] 으로 늘어나므로 
                    if(++diag1 == 5) {
                        bingoCount++;
                    }
                }

                // 좌하 대각선 줄 카운트 
                if(r + c == 4) {    // 좌하 대각선은 [0,4],[1,3]..으로 늘어나서 r,c를 더하면 무조건 4
                    if(++diag2 == 5) {
                        bingoCount++;
                    }
                }
                
                if(bingoCount >= 3) {
                    System.out.println(i * 5 + j + 1); // i 는 행 의미, j 는 열 의미 
                    return;
                }

            }
        }



        // 방법 1. 비효율적
//        for (int n = 0; n < 5; n++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int m = 0; m < 5; m++) {
//                board[n][m] = Integer.parseInt(st.nextToken());
//            }
//        }
//        int res = 1;
//        for(int n = 0; n < 5; n++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for(int m = 0; m < 5; m++) {
//                // 사회자가 부르는 수
//                int num = Integer.parseInt(st.nextToken());
//                // 빙고판에서 해당 수를 찾아서 0으로 변경
//                changeZero(num);
//
//                if(searchBingo() >= 3) { // 한 숫자를 부르는 동시에 4개가 될 수 있음
//                    System.out.println(res);
//                    return;
//                }
//                else { // 빙고라인 3번째가 될 때까지 사회자가 부른 수 체크
//                    res++;
//                }
//            }
//        }
//        // 출력
//    } // main
//
//    // 빙고판에서 해당 수를 찾아서 0으로 변경하는 메서드
//    private static void changeZero(int num) {
//        for(int i = 0; i < 5; i++) {
//            for(int j = 0; j < 5; j++) {
//                if(board[i][j] == num) {
//                    board[i][j] = 0;
//                    return; // 찾고 변경하면 바로 반복문 종료
//                }
//            }
//        }
//    }
//
//    // 한줄 빙고가 되었는지 확인하는 메서드
//    private static int searchBingo() {
//
//        // 0으로 변경된 칸을 모두 검색
//
//        // 한줄 빙고 조건(가로 검색, 세로 검색, 우하 대각선 검색, 좌하 대각선 검색)
//        int[] dy = {0, 1, 1, 1};
//        int[] dx = {1, 0, 1, -1};
//
//
//        int bingo = 0;
//
//        for(int d = 0; d < 4; d++) {
//            int r = 0;
//            int c = 0;
//            for(int i = 0; i < 5; i++) {
//                if(d == 0) r = i; // 가로인경우 r 이 늘어나야함
//                else if(d == 1) c = i; // 세로인 경우 c 가 늘어나야함
//                else if(d == 3) c = 4;
//
//                int count = 0;
//                int index = 0;
//                while(index < 5) {
//                    int nr = r + dy[d] * index;
//                    int nc = c + dx[d] * index;
//
//                    if(nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && (board[nr][nc] == 0)) {
//                        count++;
//                    }
//                    index++;
//                }
//
//                if(count == 5) { // 한줄 빙고 시
//                    bingo++;
//                }
//
//                if(d == 2 || d == 3) break; // i를 여러번 할 필요 X
//            }
//        }
//        return bingo;
//        }
    }
}