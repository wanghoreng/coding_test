
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int[] basket = new int[Integer.parseInt(nm[0])];


        for(int i = 1; i <= basket.length; i++) {
            basket[i-1] = i;
        }


        for(int j = 0; j < Integer.parseInt(nm[1]); j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            // 역순으로 변경
            while(a < b) {
                int box = basket[a-1];
                basket[a-1] = basket[b-1];
                basket[b-1] = box;
                a++;
                b--;
            }

        }

        br.close();
        for(int i = 0; i < basket.length; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}