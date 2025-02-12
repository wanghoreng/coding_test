import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        for(int i = 97; i <= 122; i++) {
            System.out.print(s.indexOf((char)i) + " ");
        }
    }
}