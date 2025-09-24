
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    // VPS 문자열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // (())()) -> NO
        // stack
        // -> (
        // -> (( -> ) 들어오면 pop
        // -> ( -> ) pop
        // -> ( -> ) pop
        // -> pop 할 애가 없네 ? ) 얘만 남네?

        // T 번의 테스트 케이스 진행
        for(int t = 0; t < T; t++) {
            Deque<Character> stack = new ArrayDeque<>();
            String str = br.readLine();
            boolean flag = true;
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                // 여는 괄호일 경우 stack 에 삽입
                if(ch == '(') stack.offerLast(ch);
                else { // 닫는 괄호일 경우
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    // 스택에 열린 괄호가 있다면 팝하기
                    stack.pollLast();
                }
            }

            if(!stack.isEmpty() || !flag) System.out.println("NO");
            else System.out.println("YES");
        }

    }
}