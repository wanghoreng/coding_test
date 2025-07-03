import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 최대값을 저장할 변수
        int max = 0;
        // 최대값의 줄을 저장할 변수
        int line = 0;

        for(int i = 1; i <= 9; i++) {
            // 입력받은 숫자
            int n = Integer.parseInt(br.readLine());
            // 새로 입력받은 숫자가 max 보다 크다면, max 에 저장하기
            if(n > max) {
                max = n;
                line = i;
            }
        }

        System.out.println(max);
        System.out.println(line);

    }

}

