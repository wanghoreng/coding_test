
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력받은 값 자체가 공백인 경우를 고려해야함 
        // -> 1. br.readLine().split(" ") 을 사용하여 문자열 배열을 만들었더니 
        // 공백이어도 length 가 1이 나옴 
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        System.out.println(st.countTokens());
    }
}