import java.util.Arrays;
import java.util.Scanner;

// 일곱난쟁이
public class Main {

    public static void main(String[] args) {
        // 일곱 난쟁이의 키의 합이 100
        // 일곱 난쟁이가 안됐는데 100이 넘으면 해당 난쟁이 탈락시키기
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] arr = new int[9];
        for(int i = 0; i < 9; i ++) {
            int num = sc.nextInt();
            arr[i] = num;

            // 총합 구하기
            sum += num;
        }

        int first = -1;  // 첫번째 난쟁이
        int second = -1; // 두번째 난쟁이
        int target = sum - 100;

        for(int i = 0; i < 8; i++) {
            for(int j = i+1; j < 9; j++) {
                if(arr[i] + arr[j] == target) {
                    first = i;
                    second = j;
                    break;
                }
            }
        }

        arr[first] = 101;
        arr[second] = 101;

        Arrays.sort(arr);
        for(int i = 0; i < 7; i++) {
            System.out.println(arr[i]);
        }
    }

}