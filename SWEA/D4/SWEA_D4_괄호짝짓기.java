package SWEA.D4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class SWEA_D4_괄호짝짓기 {
    static final int TEST_CASE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./SWEA/input.txt")));

        for (int t = 1; t <= TEST_CASE; t++) {
            int length = Integer.parseInt(br.readLine());
            String line = br.readLine();
            boolean flag = true;

            Queue<Character> stack1 = new ArrayDeque<>(); // ()
            Queue<Character> stack2 = new ArrayDeque<>(); // []
            Queue<Character> stack3 = new ArrayDeque<>(); // {}
            Queue<Character> stack4 = new ArrayDeque<>(); // <>
            for (int i = 0; i < length; i++) {
                char ch = line.charAt(i);
                // 열린 것이라면 스택에 넣기
                if (ch == '(' || ch == '{' || ch == '[' || ch == '<') {
                    switch (ch) {
                        case '(' : {
                            stack1.add(ch);
                            break;
                        }
                        case '[' : {
                            stack2.add(ch);
                            break;
                        }
                        case '{' : {
                            stack3.add(ch);
                            break;
                        }
                        case '<' : {
                            stack4.add(ch);
                            break;
                        }
                    }
                } else {
                    switch (ch) {
                        case ')' : {
                            if (!stack1.isEmpty())
                                stack1.poll();
                            else
                                flag = false;

                            break;
                        }
                        case ']' : {
                            if (!stack2.isEmpty())
                                stack2.poll();
                            else
                                flag = false;

                            break;
                        }
                        case '}' : {
                            if (!stack3.isEmpty())
                                stack3.poll();
                            else
                                flag = false;
                            break;
                        }
                        case '>' : {
                            if (!stack4.isEmpty())
                                stack4.poll();
                            else
                                flag = false;
                            break;
                        }
                    }
                }
            }
            if (!(stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty() && stack4.isEmpty())) {
                flag = false;
            }

            System.out.println("#" + t + " " + (flag ? 1 : 0));
        }
    }
}
