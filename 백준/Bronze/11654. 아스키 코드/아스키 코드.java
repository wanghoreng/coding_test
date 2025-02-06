
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char a = br.readLine().charAt(0);
        // char -> int 로 바꾸면서 ascII 코드로 변환됨
        System.out.println((int)a);
    }
}