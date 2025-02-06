import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t > 0) {
            String s = br.readLine();
            System.out.println(s.charAt(0) + "" + s.charAt(s.length()-1));
            t--;
        }

    }
}