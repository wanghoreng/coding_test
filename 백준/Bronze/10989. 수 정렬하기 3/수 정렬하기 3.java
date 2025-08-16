import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        // 카운팅 정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        // 1 ~ 10000 까지 수 저장용
        int[] count = new int[100001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            // 해당 인덱스의 값을 1 증가
            count[num]++;
        }

        // 0은 입력범위에서 없으므로 1 부터 시작
        for (int i = 1; i <= 10000; i++) {
            // i 값의 개수가 0 이 될 때까지 출력 (빈도수를 의미)
            while(count[i] > 0) {
                sb.append(i).append("\n");
                count[i]--;
            }
        }

        System.out.println(sb);

    }
}