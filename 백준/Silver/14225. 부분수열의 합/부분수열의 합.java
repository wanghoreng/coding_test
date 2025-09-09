
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정수의 개수 (== S)


        // 정수 담기
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 멱집합 구하기
        powerSet(0, 0); // idx, sum
        List<Integer> sumList = new ArrayList<>(set);
        Collections.sort(sumList); // 오름차순

        int target = 1;
        for(int s : sumList) {
            if(s < target) continue;
            if(s == target) target++;
            if(s > target) break;
        }

        // 출력
        System.out.println(target);
    }

    private static void powerSet(int idx, int sum) {


        // 기저 조건
        if(idx == N) { // 인덱스가 원소를 다 돌게 될 경우
            set.add(sum);
            return;
        }

        // 재귀파트
        // 포함하지 않는 경우
        powerSet(idx+1, sum);

        // 포함하는 경우
        sum += numbers[idx];
        powerSet(idx+1, sum);

    }
}