// 1. 배열의 모든 경우의 수를 구한다.
// 2. 해당 경우의 수를 담는 배열을 만들어 담아준다. 
// 3. 그 배열에 target 과 같은 수가 있다면 count 를 해준다. 

import java.util.*; 

class Solution {
    
    // 모든 경우의 수를 담을 배열 
    static List<Integer> allSumArr = new ArrayList<>(); 
    // target 을 count 하는 숫자변수 
    static int targetCnt; 
    
    public int solution(int[] numbers, int target) {
        
        getTargetCount(numbers, target, 0, 0);                 
        return targetCnt; 
    }
    
    private static void getTargetCount(int[] numbers, int target, int currentIdx, int currentSum) {
        
        // 재귀함수 탈출 조건 (index 가 전달받은 배열의 길이와 같아질 때 탈출!)
        if(currentIdx == numbers.length) {
            // 배열의 값을 더한 sum 을 새로 선언한 배열에 담는다. 
            allSumArr.add(currentSum);
            // 배열의 값을 더한 sum 이 target 과 같다면 
            if(currentSum == target) {
                // targetCount 를 해줌 
                targetCnt++; 
            }
            return; 
        }
        
        // 방법에는 +와 -가 있다. 
        // 재귀함수 방식으로 배열에 담는다. 
        getTargetCount(numbers, target, currentIdx + 1, currentSum + numbers[currentIdx]);
        getTargetCount(numbers, target, currentIdx + 1, currentSum - numbers[currentIdx]);
    }
}