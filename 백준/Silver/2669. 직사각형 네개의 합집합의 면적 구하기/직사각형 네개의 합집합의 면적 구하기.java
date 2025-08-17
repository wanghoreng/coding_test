import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력은 4줄 고정
        // x y x2 y2
        int[][] colorPaper = new int[4][4];
        int widthMax = 0;
        int heightMax = 0;

        for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int width = 0;
            int height = 0;
            for(int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                colorPaper[i][j] = num;
                // 가로 max
                if(j == 2) {
                    width = num;
                } else if(j == 3){ // 세로 max
                   height = num;
                }
            }

            widthMax = Math.max(width, widthMax);
            heightMax = Math.max(height, heightMax);
        }

        boolean[][] paper = new boolean[heightMax][widthMax];

        // 색종이 칠해주기
        int count = 0;
        while(count < 4) {
            for(int i = colorPaper[count][1]; i < colorPaper[count][3]; i++) {
                for(int j = colorPaper[count][0]; j < colorPaper[count][2]; j++) {
                    paper[i][j] = true;
                }
            }

            count++;
        }

        int res = 0;
        for(int i = 0; i < heightMax; i++) {
            for(int j = 0; j < widthMax; j++) {
                if(paper[i][j]) res++;
            }
        }

        System.out.println(res);
    }
}