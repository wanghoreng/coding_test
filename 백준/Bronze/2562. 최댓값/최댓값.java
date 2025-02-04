import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;



public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] absArr = new int[9];

        for(int i = 0; i < 9; i++) {
            absArr[i] = Integer.parseInt(br.readLine());
        }

        int maxTarget = absArr[0];
        int index = 0;

        // Math.max() 로 최댓값 구하기는 쉽지만 인덱스를 구하기는 어려웠다.
//        for(int arr: absArr) {
//            maxTarget = Math.max(maxTarget, Math.abs(arr));
//        }

        for(int i = 0; i < 9; i++) {
            if(maxTarget <= absArr[i]) {
                maxTarget = absArr[i];
                index = i+1;
            }
        }


        System.out.println(maxTarget + "\n" + index);
        br.close();
    }
}