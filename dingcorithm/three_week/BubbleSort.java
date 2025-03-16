package dingcorithm.three_week;

import java.util.*;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 9, 1};

        System.out.println(Arrays.toString(bubbleSortMethod(arr)));
    }


    private static int[] bubbleSortMethod(int[] arr) {

        // 버블정렬은 반복문이 돌 때마다 가장 큰 숫자 순서대로
        // 맨 뒤로 하나씩 정렬이 되기 때문에 반복문을 돌 때마다 이미 정렬이 끝난 구간은 안돌아도 된다.

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int box = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = box;
                }
            }
        }

        return arr;
    }
}
