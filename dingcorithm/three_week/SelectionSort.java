package dingcorithm.three_week;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 9, 1};
        System.out.println(Arrays.toString(selectionSortMethod(arr)));
    }

    private static int[] selectionSortMethod(int[] arr) {

        // 선택적 정렬
        // 가장 작은 값을 맨 앞으로 배치하는 정렬이다.
        // 그럼 반복문을 돌 때마다 순차적으로 앞에 작은 수가 배치되기 때문에
        // 반복문이 이미 돌아 배치된 인덱스는 빼면서 반복문을 돌아야한다.

        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            // 가장 작은 수를 찾는다.
            for (int j = i; j < arr.length; j++) {
                if(arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            int box = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = box;
        }
        return arr;
    }
}
