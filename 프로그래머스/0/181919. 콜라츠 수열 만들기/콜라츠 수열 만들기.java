import java.util.*; 

class Solution {
    public int[] solution(int n) {
        
        // 콜라츠 수열 
        // x 가 짝수일 때 2로 나누기 
        // x 가 홀수일 때 3 * x + 1 
        // int[] answer = {};
        List<Integer> answer = new ArrayList<>(); 
        answer.add(n); 
        while(n > 1) { // 1과 같거나 작으면 반복문은 끝남 
            if(n % 2 == 0) {
                n /= 2; 
                answer.add(n); 
            } else {
                n = n * 3 + 1; 
                answer.add(n); 
            }
        }
        
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}