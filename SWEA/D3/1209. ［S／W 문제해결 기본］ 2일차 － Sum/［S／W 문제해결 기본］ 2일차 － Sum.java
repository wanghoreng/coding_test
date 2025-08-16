import java.io.*;
import java.util.*;


class Solution {
    public static void main(String[] args) throws IOException{
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for(int i = 1; i <= 10; i++) {
            int T = Integer.parseInt(br.readLine());
            int[][] arr = new int[101][101];
            int[][] sum = new int[101][101];

            // 배열 담기
            for(int a = 1; a <= 100; a++) {
                st = new StringTokenizer(br.readLine());

                for(int b = 1; b <= 100; b++) {
                    arr[a][b] = Integer.parseInt(st.nextToken());
                    sum[a][b] = arr[a][b] + sum[a-1][b] + sum[a][b-1] - sum[a-1][b-1];
                }
            }

            int rowMax = sum[1][100];
            int lineMax = sum[100][1];
            int rightMax = 0;
            int leftMax = 0;
            // 열과 행 최대값
            for(int j = 1; j <=100; j++) {

                lineMax = Math.max(lineMax, sum[100][j] - sum[0][j] - sum[100][j-1] + sum[0][j-1]);
                rowMax = Math.max(rowMax, sum[j][100] - sum[j-1][100] - sum[j][0] - sum[j-1][0]);
                rightMax += arr[j][j];
                leftMax += arr[j][101-j];
            }

            System.out.println("#"+ T  +" "+
                    Math.max(Math.max(lineMax, rowMax), Math.max(rightMax, leftMax)));

        }
    }
}
