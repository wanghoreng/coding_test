
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    // 재현이는 잘못된 수를 부를 때마다 0을 외쳐서 가장 최근에 재민이가 쓴수를 지우게 시킨다.
    // 0 -> stack.pop
    // 받아적은 수의 합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 줄 K
        int K = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for(int k = 0; k < K; k++) {
            int num = Integer.parseInt(br.readLine());
            if(!q.isEmpty() && num == 0) q.pollLast();
            else q.offerLast(num);
        }

        int sum = 0;
        while(!q.isEmpty()) {
            sum += q.pollLast();
        }
        System.out.println(sum);
    }
}