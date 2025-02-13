class Solution {
    public int solution(int a, int b) {
        int answer1 = Integer.parseInt(String.valueOf(a)+""+String.valueOf(b));
        int answer2 = Integer.parseInt(String.valueOf(b)+""+String.valueOf(a));
        
        if(answer1 < answer2) {
            return answer2;
        } else {
            return answer1;
        }
        
    }
}