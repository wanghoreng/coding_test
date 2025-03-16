package dingcorithm.three_week;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = {4,6,2,9,1};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    private static int[] insertionSort(int[] arr) {

        // 삽입정렬
        // 앞에껀 이미 정렬되어있다고 가정하고, 뒤에 새로운 숫자와 비교한다는 개념이다.
        // 그래서 4,6을 비교했을 땐 4가 더 작아서 가만히 있으면 된다치자.
        // 4, 6, 2 일 때는 6 과 2를 비교해서 4,2,6 이 되고 4와 2를 비교해서 2,4,6 이 되는 개념이다.
        // 그럼 이 정렬은 뒤에서부터 앞으로 .. 즉 3,2,1.. 이런식으로 앞으로 숫자를 비교하기 때문에
        // 마이너스를 잘 활용해야한다.

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i-j] < arr[i-j-1]) { // 뒷 숫자가 앞숫자보다 작을 때
                    int box = arr[i-j];
                    arr[i-j] = arr[i-j-1];
                    arr[i-j-1] = box;
                } else {
                    // 앞은 이미 다 정렬이 된 상태이기 때문에
                    // 굳이 끝까지 돌릴 필요가 없다.
                    // 이 break 문 때문에 빅오메가표기법에서는 N 만큼의 시간복잡도가 걸릴 수 있다.
                    break;
                }
            }
        }

        return arr;
    }
}
