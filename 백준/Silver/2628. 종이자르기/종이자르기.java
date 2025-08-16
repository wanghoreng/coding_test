
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        // 1. 가로, 세로 (최대 100)
        // 2. 칼로 잘라야하는 점선의 개수 N
        // 3 ~ N. "가로(0)or세로(1) 를 구분하는번호 잘라야하는 점선번호"

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken()); // 가로
        int Y = Integer.parseInt(st.nextToken()); // 세로
        int N = Integer.parseInt(br.readLine());

        List<Integer> cowLine = new ArrayList<>(); // 행 자르기 라인
        List<Integer> rowLine = new ArrayList<>(); // 열 자르기 라인

        cowLine.add(0);
        cowLine.add(Y);
        rowLine.add(0);
        rowLine.add(X);

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int rcNum = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(rcNum == 0) { // 행 자르기
                cowLine.add(num);
            } else {  // 열 자르기
                rowLine.add(num);
            }
        }

        // 점선번호 오름차순 정렬
        cowLine.sort(null);
        rowLine.sort(null);

        // 가로 세로 잘린 길이 max 값 구하기
        int maxHeightNum = getMaxNum(cowLine);
        int maxWidthNum = getMaxNum(rowLine);

        // 가장 큰 종이 조각의 넓이 출력
        System.out.println(maxHeightNum * maxWidthNum);
    }

    private static int getMaxNum(List<Integer> line) {
        int maxNum = line.get(0);
        for(int rc = 1; rc < line.size(); rc++) {
            int cut = line.get(rc) - line.get(rc-1);

            maxNum = Math.max(cut, maxNum);
        }
        return maxNum;
    }
}