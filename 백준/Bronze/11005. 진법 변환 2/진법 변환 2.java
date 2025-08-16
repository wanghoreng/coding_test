import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 10 진수를 b 진법으로 바꿔서 출력하는 방법
        // 10 -> 10 / 2 = 5(0) / 2 = 2(1) / 2 = 1(0) -> 1010 = 1*2^3 + 0*2^2 + 1*2^1 = 10

        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            int remain = n % b;

            if(remain >= 10) {
                remain += 55;
                sb.append((char)remain);
            } else {
                sb.append(remain);
            }

            n /= b;
        }

        System.out.println(sb.reverse());
    }
}