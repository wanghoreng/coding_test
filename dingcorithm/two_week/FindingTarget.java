package dingcorithm.two_week;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindingTarget {

    public static void main(String[] args) {
        int target = 14;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        System.out.println(isExistingTargetNumberSequential(target, arr));
        System.out.println(isExistingTargetNumberBinary(target, arr));

        int t = 2;
        int[] a = {0, 3, 5, 6, 1, 2, 4};
        System.out.println(isExistTargetNumberBinaryProblem(t, a));
    }

    // 순차탐색
    private static boolean isExistingTargetNumberSequential(int target, int[] arr) {
        int number = 0;
        for (int j : arr) {
            number += 1;
            if (target == j) {
                System.out.println("순차탐색 횟수 : " + number);
                return true;
            }
        }
        return false;
    }

    // 이진탐색 (반으로 나눠가면서 탐색해나가는 것) -> 연산량이 나눠지고 있다면 대략 O(logN) 으로 보자.
    private static boolean isExistingTargetNumberBinary(int target, int[] arr) {
        int min = 0;
        int max = arr.length - 1;
        int existingNum = (min + max) / 2; // 탐색값
        int number = 0;     // 횟수

        while(min <= max) {
            number += 1;
            if(arr[existingNum] == target) {
                System.out.println("이진탐색 횟수 :: " + number);
                return true;
            } else if(arr[existingNum] < target) {
                // 최소를 탐색값 보다 큰 값으로 대입
                min = existingNum + 1;
            } else { // arr[existingNum] > target
                // 최대를 탐색값 보다 작은 값으로 대입
                max = existingNum - 1;
            }

            existingNum = (min + max) / 2;
        }

        return false;
    }

    // 무작위 수 찾기 (이진탐색 문제) 
    // 이 때 이진탐색의 특징을 알 수 있음 
    // 이진탐색 특징 : 정렬된 배열에서만 가능함
    private static boolean isExistTargetNumberBinaryProblem(int target, int[] arr) {
        // 수 정렬 하기
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i] > arr[i+1]) {
//                int box = arr[i];
//                arr[i] = arr[i+1];
//                arr[i+1] = box;
//            }
//        }

        // 정렬된 배열 
        int[] array = Arrays.stream(arr).sorted().toArray();
        return isExistingTargetNumberBinary(target, array);
    }
}
