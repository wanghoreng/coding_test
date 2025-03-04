import java.util.*;

class Solution {
    public int[] solution(int start_num, int end_num) {
        
        // 나의 풀이  -> 시간복잡도는 N 이지만 스트림으로 인해 조금 느린듯? 
        /*
        List<Integer> list = new ArrayList<>(); 
        for(int i = start_num; i <= end_num; i++) {
            list.add(i); 
        }
        return list.stream().mapToInt(i->i).toArray();
        */
        // 다른 풀이 
        int[] answer = new int[end_num - start_num + 1];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = start_num + i; 
        }
        
        return answer; 
    }
}