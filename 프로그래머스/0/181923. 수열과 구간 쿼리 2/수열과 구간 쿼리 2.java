import java.util.stream.*; 

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        // 내풀이 
        /** 
        int[] answer = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++) {
            int min = 1000000; 
            for(int j = queries[i][0]; j <= queries[i][1]; j++) {
                if(arr[j] > queries[i][2]) min = Math.min(min, arr[j]);
            }
            
            if(min == 1000000) min = -1; 
            
            answer[i] = min; 
        }
        return answer;
        */
        
        // 다른 풀이 
        int[] answer = {};
        return IntStream.range(0, queries.length)
                .map(q -> IntStream.rangeClosed(queries[q][0], queries[q][1])
                        .map(i -> arr[i])
                        .filter(i -> i > queries[q][2])
                        .min().orElse(-1)
                ).toArray();
        
    }
}