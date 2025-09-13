import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws IOException {
        // 도화지 크기  100, 100
        // 색종이 크기  10, 10

        // 설계
        // 1. boolean[100][100] paper 크기를 만들기
        // 2. 색종이가 덮혀져있는 부분을 paper 에서 true 로 만들기
        // 3. true 로 덮힌 곳을 카운팅하기


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] paper = new boolean[100][100];

        int colorCount = Integer.parseInt(br.readLine());

        for(int cnt = 0; cnt < colorCount; cnt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            for(int y = Y; y < Y+10; y++) {
                for(int x = X; x < X+10; x++) {
                    paper[y][x] = true;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(paper[i][j]) res++;
            }
        }

        // 출력
        // 색종이가 붙은 검은 영역의 넓이 구하기
        System.out.println(res);


    }
}