import java.io.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fatoryial(n));
    }
    private static int fatoryial(int n) {
        if(n < 1) return 1;
        return n * fatoryial(n-1);
    }

}