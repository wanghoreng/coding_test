
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    // x,y, 너비, 높이
    public static void main(String[] args) throws IOException {
        int[][] paper = new int[1001][1001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y = y1; y < y1+y2; y++) {
                for(int x = x1; x < x1+x2; x++) {
                    paper[y][x] = i+1;
                }
            }

        }

        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int y = 0; y < 1001; y++) {
                for(int x = 0; x < 1001; x++) {
                    if(paper[y][x] == (i+1)) {
                        sum++;
                    }
                }
            }

            System.out.println(sum);
        }
    }
}