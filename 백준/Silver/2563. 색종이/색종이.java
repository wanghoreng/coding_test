

import java.io.*;
import java.util.*;

class Main {
    //도화지 : 가로 * 세로 = 100 * 100
    //색종이 : 가로 * 세로 = 10 * 10

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // 기본값 false 로 세팅됨
        boolean[][] paper = new boolean[100][100];

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 색종이 영역만큼 true 로 표시
            for (int i = x; i < x+10; i++) {
                for (int j = y; j < y + 10; j++) {
                    // 색종이를 덮을 때 마다 true 로 설정이 되는데
                    // 이미 true 인 경우 다시 true 로 설정이 되기 때문에 값에 변화가 없음
                    // 즉, 여러 장의 색종이가 같은 위치를 덮어도 결과는 항상 true 이기 때문임
                    paper[i][j] = true;
                }
            }
        }

        int area = 0;
        // true 인 칸 세기
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j]) {
                    area++;
                }
            }
        }

        System.out.println(area);

    }
}