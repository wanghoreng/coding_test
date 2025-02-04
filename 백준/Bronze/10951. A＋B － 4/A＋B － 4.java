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

        String input;

        while((input = br.readLine()) != null && !input.isEmpty()) {
            String[] tokens = input.split(" ");

            // st.nextToken() 에서 하나를 소비해서 자꾸 NoSuchElementException 이 떨어짐
//            if(st.nextToken().equals("")) {
//                flag = false;
//            }

            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            bw.write(String.valueOf(a+b));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}