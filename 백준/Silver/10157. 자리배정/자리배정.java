import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

// 일곱난쟁이
public class Main {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[][] seats = new int[R][C];

        int r = 0;
        int c = -1;
        int index = 1;
        int d = 0;
        while(index <= R*C) {

            int nr = r + dy[d]; // 1
            int nc = c + dx[d]; // 0
            if(nr >= 0 && nr < R && nc >= 0 && nc < C && seats[nr][nc] == 0) {
                seats[nr][nc] = index++;
                r = nr;
                c = nc;
            } else {
                d = (d + 1) % 4;
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(seats[i][j] == K) {
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
        System.out.println(0);
    }
}