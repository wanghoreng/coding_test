import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int[] numbers;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정수의 개수
        S = Integer.parseInt(st.nextToken()); // 부분수열의 합

        count = 0;  // 경우의 수

        // 정수 담기
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 멱집합 구하기
        powerSet(0, 0); // idx, sum
        if(S == 0) count--;

        // 출력
        System.out.println(count);
    }

    private static void powerSet(int idx, int sum) {


        // 기저 조건
        if(idx == N) { // 인덱스가 원소를 다 돌게 될 경우
            if(sum == S) { // 다 더한값이 S와 같아질 때
                count++;    // 경우의 수++
            }
            return;
        }

        // 재귀파트
        powerSet(idx+1, sum);

        sum += numbers[idx];
        powerSet(idx+1, sum);

    }
}