import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{

        // B진법 수
        // 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리는 알파벳

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());


        // 36 ZZZZZ
        // 2진법을 10진법으로 바꾸는 과정
        // 1000 = (1*2^3)+(0*2^2)+2^1+2^0 = .. 8

        // 36진법을 10진법으로 바꾸는 과정
        // ZZZZZ = 35*36^4 + 35*36^3 + 35*36^2 + 35*36^1 + 35*36^0

        long sum = 0;
        for(int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);
            int value;

            if('0' <= ch && ch <= '9') {
                value = ch - '0';
            } else {
                value = ch - 'A' + 10;
            }

            // 누적합 계산 방식
            sum = sum * b + value;
//            int num = b < 10 ? ch - '0' : ch - 55;
//            sum += num * Math.pow(b, n.length() - i -1);
        }
        System.out.println(sum);
    }
}