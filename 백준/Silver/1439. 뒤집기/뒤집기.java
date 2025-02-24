
import java.io.IOException;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        // S 는 0과 1이 섞여진 문자일수도 있고, 하나로 이루어진 문자일 수 있다.

        // 만약 모든 숫자가 동일한 문자열이라면 뒤집을 필요 없이 0이다.

        // S 의 문자열을 앞 인덱스부터 뒤로 하나씩 돌면서
        // 첫 인덱스의 값을 변수에 지정해둔다.
        // 첫 인덱스의 값과 다음 인덱스의 값이 같다면, +1 을 하지 않는다.
        // 첫 인덱스의 값과 다음 인덱스의 값이 다르다면, +1을 하고 변수의 값을 다음 인덱스 값으로 바꾼다.
        // 그렇게 1과 0의 연속된 값을 제거한 sum 중에 가장 적은 수가 최소 횟수가 된다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char startNum = s.charAt(0);
        int zero = 0;
        int one = 0;

        if(startNum == '0') {
            zero += 1;
        } else {
            one += 1;
        }

        for(int i = 0; i < s.length(); i++) {
            if(startNum != s.charAt(i)) {
                startNum = s.charAt(i);
                if(startNum == '0') {
                    zero += 1;
                } else {
                    one += 1;
                }
            }
        }

        System.out.println(Math.min(zero, one));
    }
}