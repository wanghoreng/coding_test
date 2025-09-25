
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 행운의 문자열
    // 인접해있는 모든 문자가 같지 않은 문자열을 행운의 문자열이라고 한다.
    // aabbbaa -> abababa 행운의 문자열
    // aaab -> baaa -> abaa -> aaba 어떻게 배치해도 인접해있는 문자들이 다수
    static int[] count = new int[27]; // abcdefghij ..
    static int length;
    static int res;
    // 문자열 S 에 나오는 문자를 재배치하면 서로 다른 행운의 문자열이 몇개 나오는지 궁금해졌다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        length = str.length();
        char[] strArr = str.toCharArray();
        for(char ch : strArr) {
            int x = ch - 'a';
            count[x]++;
        }
        dfs(0, ' ');

        System.out.println(res);
    }

    private static void dfs(int idx, char pre) {
        // idx 와 길이가 같아지면 멈추기
        if(idx == length) {
            res++;
            return;
        }

        for(int i = 0; i < 27; i++) {
            if(count[i] == 0) continue; // 알파벳 갯수가 0이면 넘기기

            if(pre != (char)(i + 'a')) {
                count[i]--;  // 해당 인덱스의 알파벳 개수 줄이기
                dfs(idx+1, (char)(i+'a'));
                count[i]++; // 이전값과 다른 값일 경우에만 idx 를 증가시킨다.
            }
        }

    }

}