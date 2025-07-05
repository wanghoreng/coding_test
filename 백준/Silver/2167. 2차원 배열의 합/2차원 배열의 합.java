import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 누적합 사용해서 푼 코드
        int[][] arr = new int[N+1][M+1];
        int[][] sum = new int[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = arr[i][j]
                        + sum[i-1][j]
                        + sum[i][j-1]
                        - sum[i-1][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());
        for(int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            int total = sum[X][Y]
                    - sum[I-1][Y]
                    - sum[X][J-1]
                    + sum[I-1][J-1];

            System.out.println(total);
        }

        
        // 누적합 안쓰고 구현한 코드 
//        int[][] arr = new int[N][M];
//
//        for(int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0; j < M; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        int K = Integer.parseInt(br.readLine());
//
//        for(int i = 0; i < K; i++) {
//            st = new StringTokenizer(br.readLine());
//            int I = Integer.parseInt(st.nextToken());
//            int J = Integer.parseInt(st.nextToken());
//            int X = Integer.parseInt(st.nextToken());
//            int Y = Integer.parseInt(st.nextToken());
//            int sum = 0;
//            for(int a = I-1; a < X; a++) {
//                for(int b = J-1; b < Y; b++) {
//                    sum += arr[a][b];
//                }
//            }
//            System.out.println(sum);
//        }

    }
}
