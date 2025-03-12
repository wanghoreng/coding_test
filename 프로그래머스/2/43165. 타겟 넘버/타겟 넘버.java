import java.util.*;

class Solution {
    static List<Integer> allSumArray = new ArrayList<>();
    static int allWayCount;

    public int solution(int[] numbers, int target) {
        // 1. 배열의 숫자에 대한 모든 경우의 수를 새로운 배열에 저장한다.
        // 2. 배열의 숫자는 1개당 +,- 를 가질 수 있기에 index 를 올려가며 하나는 + 된 값을 저장하고, 하나는 - 된 값을 저장해야한다.
        // 3. 새로운 배열에 target 과 같은 숫자가 몇개 있는지 세아린다.
        getAllSumCountMethod(numbers, target, 0, 0);

        return allWayCount;
    }

    private static void getAllSumCountMethod(int[] numbers, int target, int currentIdx, int currentSum) {

        // 재귀 탈출 조건
        if(numbers.length == currentIdx) {
            allSumArray.add(currentSum);
            if(currentSum == target) allWayCount++;
            return;
        }

        // + 한 값을 저장
        getAllSumCountMethod(numbers, target,currentIdx + 1, currentSum + numbers[currentIdx]);
        // - 한 값을 저장
        getAllSumCountMethod(numbers, target,currentIdx + 1, currentSum - numbers[currentIdx]);
    }
}
