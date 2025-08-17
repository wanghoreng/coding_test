
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        // 두 딱지의 별 개수가 다를 경우, 별 많은게 승리
        // 별(4) > 동그라미(3) > 네모(2) > 세모(1)
        // 모두 같다면 무승부 => D

        // 입력
        // 1. 총 라운드 수 N (1 ~ 1000)
        // 2. A 가 내는 딱지 그림 총 개수 a / a개의 정수(어린이 A가 낸 딱지의 그림)
        // 3. a개의 정수

        /*
        5 => 라운드 수
        1 4       =>A가 낸  딱지그림개수 / 4(별) 1개
        4 3 3 2 1   => B가 낸 딱지그림개수 / 3(동) 3(동) 2(네) 1(세)
        5 2 4 3 2 1
        4 4 3 3 1
        4 3 2 1 1
        4 2 3 2 1
        4 4 3 2 1
        3 4 3 2
        5 4 4 2 3 1
        5 4 2 4 1 3
        * */

        // 출력 이긴 사람 라운드별로 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int round = Integer.parseInt(br.readLine());
        for(int r = 1; r <= round; r++) {       // 라운드
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A_paintCount = Integer.parseInt(st.nextToken());
            int[] A_paintArr = new int[4]; // [세모,네모,동그라미,별] (인덱스가 큰 순서대로 이김)

            for(int a = 0; a < A_paintCount; a++) {
                int paint = Integer.parseInt(st.nextToken());
                A_paintArr[paint-1]++;
            }

            st = new StringTokenizer(br.readLine());
            int B_paintCount = Integer.parseInt(st.nextToken());
            int[] B_paintArr = new int[4];
            for(int b = 0; b < B_paintCount; b++) {
                int paint = Integer.parseInt(st.nextToken());
                B_paintArr[paint-1]++;
            }

            // 이긴 사람 출력
            String res = "D";

            for(int i = 3; i >= 0; i--) { // 거꾸로 읽기
                if(A_paintArr[i] > B_paintArr[i]) {
                    res = "A";
                } else if(A_paintArr[i] < B_paintArr[i]) {
                    res = "B";
                }
            }
            System.out.println(res);
        }

    }
}