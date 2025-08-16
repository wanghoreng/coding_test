
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 공백4, 별1
        // 공백3, 별2
        // 공백2, 별3
        // 공백1, 별4
        // 공백0, 별5
        // Java 11 에 repeat 메서드가 있음
        for(int i = 1; i<= size; i++) {
            sb.append(" ".repeat(size-i)).append("*".repeat(i)).append("\n");
        }

        // Java 8
//        for(int i = 1; i <= size; i++) {
//            for(int space = 1; space <= size - i; space++) {
//                sb.append(" ");
//            }
//            for(int star = 1; star <= i; star++) {
//                sb.append("*");
//            }
//            sb.append("\n");
//        }

        System.out.println(sb);
    }
}
