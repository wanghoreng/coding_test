import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        // 최댓값 M
        // 점수/M*100

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 내가 푼 풀이
//        double[] arr = new double[n];
//
//
//        for(int i =0; i < n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        double maxVal = arr[0];
//
//        for(double a :arr) {
//            maxVal = Math.max(maxVal,a);
//        }
//
//        for(int i = 0; i<n; i++) {
//            arr[i] = arr[i]/maxVal*100;
//        }
//
//        System.out.println((Arrays.stream(arr).sum()) / n);

        // 다른 사람 풀이
        int sum = 0;
        int max = 0;
        int num;
        for(int i = 0; i < n; i++) {
            num = Integer.parseInt(st.nextToken());
            if(max < num)
                max = num;

            sum += num;
        }

        // 반복문을 돌면서 (점수/M*100)/n 으로 평균값 구하는 것보다
        // 점수를 먼저 모두 합산 후, M*100/n 하는게 더 연산이 적다. (동일값)
        System.out.println((double)sum / max * 100 / n);
    }
}