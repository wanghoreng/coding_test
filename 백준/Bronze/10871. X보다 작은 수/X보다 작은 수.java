
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N과 X 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        StringBuilder str = new StringBuilder();
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st2.nextToken());
            if(x > a) str.append(a).append(" ");
        }

        System.out.println(str);
    }
}
