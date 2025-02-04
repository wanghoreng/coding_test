
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;



public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int[] array = new int[2];

        for(int i = 1; i <= x; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 2; j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }
            bw.write("Case #" + i + ": " + (array[0]+array[1]));
            bw.write("\n");
        }

        br.close(); 
        bw.flush();
        bw.close();
    }
}