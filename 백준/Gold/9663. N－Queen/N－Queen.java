import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int count;
    static int[] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        chess = new int[N]; // 인덱스는 열을 의미하며, 값은 행을 의미할 예정

        nQueen(0);
        System.out.println(count);
    }

    // 재귀함수형식
    private static void nQueen(int depth) {
        // 기저 조건
        if(depth == N) { // 모든 좌표를 다 돌았다는 의미
            count++;
            return;
        }

        for(int i = 0; i < N; i++) {
            chess[depth] = i;   // 해당 열에 i 라는 행 좌표에 놔두겠다 (depth, i)
            if(conflictCheck(depth)) { // 해당 좌표에 다른 퀸이 있는지 체크하는 메서드
                // 충돌을 안한다면!
                nQueen(depth+1);
            }
        }
    }

    private static boolean conflictCheck(int col) {
        for(int i = 0; i < col; i++) {
            if(chess[col] == chess[i]) {
                return false;   // 같은 행에 있다면 충돌!
            }
            // 대각선에서 충돌할 위치라면 false
            else if(Math.abs(col - i) == Math.abs(chess[col] - chess[i])) {
                return false;
            }
        }
        return true;

    }
}