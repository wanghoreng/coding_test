import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int sum = 0;

        // n이 2번째 오는 문자열의 길이라고 가정
        for(int i = 0; i < n; i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        System.out.println(sum);

    }
}