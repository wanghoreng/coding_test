import java.util.*; 

class Solution {
    public int[] solution(int n) {
        
        // 내풀이 
        /*
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
        */
        
        // 다른 풀이 
        String str = n + ","; 
        while(n > 1) {
            n = (n%2 == 0) ? n/2 : n*3+1;
            str += n + ",";
        }
        
        String[] strArr = str.split(",");
        int[] answer = new int[strArr.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(strArr[i]); 
        }
        
        return answer; 
    }
}