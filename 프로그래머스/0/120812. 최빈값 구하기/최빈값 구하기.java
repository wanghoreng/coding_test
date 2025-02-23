import java.util.*; 

class Solution {
    public int solution(int[] array) {
        int answer = 0; // 대입연산 1 
        int maxNum = 0; // 대입연산 1 
        
        // 1. array 에서 중복값 제거한 배열 새로 만들기 
        int[] distinctArray = Arrays.stream(array).distinct().toArray(); // 대입연산 1 
        
        // 2. 중복제거한 array 에서 입력값으로 받은 array를 반복하면서 최빈값을 찾는다.  
        for(int i = 0; i < distinctArray.length; i++) { // N 
            int compareNum = 0;  // 대입연산 1 
            
            for(int j = 0; j < array.length; j++) { // N
                if(distinctArray[i] == array[j]) { // 비교연산 1 
                    compareNum += 1;               // 연산 1 
                }
            }
            
    
            if(maxNum < compareNum) {               // 비교연산 1
                maxNum = compareNum;                // 대입연산 1
                answer = distinctArray[i];          // 대입연산 1
            } else if (maxNum == compareNum) {      // 비교연산 1
                answer = -1;                        // 대입연산 1 
            }
        }
        
        // 시간복잡도 = 대략 N^2 (대입연산 및 비교연산 제외)
        
        return answer;
    }
} 