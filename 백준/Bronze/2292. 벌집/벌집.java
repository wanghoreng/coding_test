import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        //  끝번호에서 증가해간다고 생각하자
        // 1 -> 7 -> 19 -> 37 -> 61 ..
        // 1 -> 1+6 -> 7 + 12 -> 19 + 18 -> 37 + 24
        // sum = 1
        // 1+(6^0) -> 1+(6^1) +
        //  n = 13
        //

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 1;
        int i = 1;
        while(sum < n) {
            sum += (6*i);
            i++;
        }

        System.out.println(i);

    }
}