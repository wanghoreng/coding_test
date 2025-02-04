import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정수의 개수
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        // n 만큼 숫자 나열
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 나열된 숫자 배열로 세팅
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int v = Integer.parseInt(br.readLine());
        // 1. 배열 돌면서 v 와 같은 것 찾아서 count 올리기
//        int count = 0;
//        for(int a :array) {
//            if(a == v) {
//                count += 1;
//            }
//        }

        // 2. Stream Filter 로 v 와 같은 것을 골라내어 count 하기
        long count = Arrays.stream(array).filter(a -> a == v).count();

        bw.write(String.valueOf(count));
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }
}