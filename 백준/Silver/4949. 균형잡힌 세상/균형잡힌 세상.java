import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    // 마지막 글자를 제외하고 영문
    // 영문 알파벳, 공백, 소괄호, 대괄호, 온점으로 끝나고 길이는 100글자보다 작거나 같다.
    // 입력의 종료조건 맨 마지막에 온점 하나 .
    // 괄호가 하나도 없는 경우도 균형잡힌 문자열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {

            String str = br.readLine();
            if(str.equals(".")) break;

            Deque<Character> stack = new ArrayDeque<>();
            boolean flag = true;

            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                // 여는 괄호일 경우 stack 에 삽입
                if(ch == '(' || ch == '[') {
                    stack.offerLast(ch);
                }
                else if(ch == ')' || ch == ']'){ // 닫는 괄호일 경우
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    // 스택에 열린 괄호가 있다면 팝하기
                    char top = stack.peekLast();
                    if((top == '(' && ch == ')') || (top == '[' && ch == ']')) stack.pollLast();
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            if(!stack.isEmpty() || !flag) System.out.println("no");
            else System.out.println("yes");
        }

    }
}