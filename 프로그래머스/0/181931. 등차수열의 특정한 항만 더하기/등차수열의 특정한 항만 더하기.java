class Solution {
    public int solution(int a, int d, boolean[] included) {
        // a + d*i = 3 + 4*0 = 3, 3+ 4*1 = 7 , 
        int answer = 0;
        for(int i = 0; i < included.length; i++) {
            answer += included[i] ? a + (d*i) : 0;
        }
        
        return answer;
    }
}