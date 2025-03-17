package dingcorithm.three_week;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        // arr1, arr2 의 배열은 모두 각자 배열내에서 정렬되어 있는 상태
        int[] arr1 = {1,2,3,5};
        int[] arr2 = {4,6,7,8};

        System.out.println(Arrays.toString(merge(arr1,arr2)));

        System.out.println("정답 = [-7, -1, 5, 6, 9, 10, 11, 40] / 현재 풀이 값 = " + Arrays.toString(merge(new int[]{-7, -1, 9, 40}, new int[]{5, 6, 10, 11})));
        System.out.println("정답 = [-1, 2, 3, 5, 10, 40, 78, 100] / 현재 풀이 값 = "+ Arrays.toString(merge(new int[]{-1,2,3,5,40}, new int[]{10,78,100})));
        System.out.println("정답 = [-1, -1, 0, 1, 6, 9, 10] / 현재 풀이 값 = "+ Arrays.toString(merge(new int[]{-1,-1,0}, new int[]{1, 6, 9, 10})));
    }

    private static int[] merge(int[] arr1, int[] arr2) {

        int[] newArr = new int[arr1.length + arr2.length];

        int arr1Idx = 0;
        int arr2Idx = 0;
        int idx = 0;

        while(idx != newArr.length) {
            if(arr1[arr1Idx] < arr2[arr2Idx]) {
                newArr[idx] = arr1[arr1Idx];
                arr1Idx++;
                idx++;
            } else if(arr1[arr1Idx] > arr2[arr2Idx]) {
                newArr[idx] = arr2[arr2Idx];
                arr2Idx++;
                idx++;
            }

            if(arr1Idx == arr1.length || arr2Idx == arr2.length) {
                break;
            }
        }

        if(arr1Idx > arr2Idx) {
            for (int i = arr2Idx; i < arr2.length; i++) {
                newArr[idx] = arr2[i];
                idx++;
            }
        } else {
            for (int i = arr1Idx; i < arr1.length; i++) {
                newArr[idx] = arr1[i];
                idx++;
            }
        }


        return newArr;
    }
}
