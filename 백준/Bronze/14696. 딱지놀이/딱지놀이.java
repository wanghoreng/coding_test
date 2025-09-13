
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
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
                    break;
                } else if(A_paintArr[i] < B_paintArr[i]) {
                    res = "B";
                    break;
                }
            }
            System.out.println(res);
        }

    }
}