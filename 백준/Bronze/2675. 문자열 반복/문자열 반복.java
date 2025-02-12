import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < s[1].length(); j++) {
                System.out.print(String.valueOf(s[1].charAt(j)).repeat(Integer.parseInt(s[0])));
            }
            System.out.println();
        }
    }
}