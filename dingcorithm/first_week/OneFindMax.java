package dingcorithm.first_week;

import java.io.IOException;
import java.util.Arrays;

public class OneFindMax {

    public static void main(String[] args) throws IOException {

        System.out.println(findMaxNum(new int[]{3, 5, 6, 1, 2, 4}));
        System.out.println(findMaxNum(new int[]{6, 6, 6}));
        System.out.println(findMaxNum(new int[]{6, 9, 2, 7, 1888}));
    }


    private static int findMaxNum(int[] array) {
        // 내풀이
        // return Arrays.stream(array).max().getAsInt();
        // 1. 각 숫자마다 모든 다른 숫자와 비교해서 최대값인지 확인
        /*
            int number = 0;
            for(int num : array) {
                boolean isMaxNum = true;
                for(int compareNum : array) {
                    if(num < compareNum) isMaxNum = false;
                }
                if(isMaxNum) number = num;
            }
            return number;
        */

        // 2. 변수에 값을 저장하여 해당 변수와 원소를 비교하여 최대값인지 확인
        int maxNum = array[0];
        for(int i = 0; i < array.length; i++) {
           if(maxNum < array[i]) maxNum = array[i];
        }
        return maxNum;
    }
}
