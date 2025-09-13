
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 길이가 M 인 수열을 모두 구하는 프로그램
    // 1 ~ N 까지 자연수 중에서 중복없이 M 개를 고른 수열
    // N 4, M 2
    static int N;
    static int M;
    static int[] arr; // 수열 저장!
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        used = new boolean[N];
        backtrack(0);

    }


    static void backtrack(int depth) {

        if(depth == M) {
            for(int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!used[i]) { // 이미 쓴 숫자는 제외 (가지치기)
                arr[depth] = i+1;
                used[i] = true;
                backtrack(depth + 1);
                used[i] = false;
            }
        }
    }
}