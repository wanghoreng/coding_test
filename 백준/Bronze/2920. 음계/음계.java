import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열 선언
        int[] arr = new int[8];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 담기
        for(int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean asc = true;
        boolean dsc = true;
        for(int i = 0; i < 7; i++) {
            // 앞 숫자보다 뒷 숫자가 크면 descending X
            if(arr[i] < arr[i+1]) dsc = false;
            // 앞 숫자가 뒷 숫자보다 크면 ascending X
            if(arr[i] > arr[i+1]) asc = false;
        }

        if(asc) {
            System.out.println("ascending");
        } else if(dsc) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

    }

}



