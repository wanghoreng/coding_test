class Solution {
    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder(); 
        
        for(int i = 0; i < numLog.length - 1; i++) {
            int n = numLog[i + 1] - numLog[i];
            switch (n) {
                    case 1 -> answer.append("w");
                    case -1 -> answer.append("s");
                    case 10 -> answer.append("d");
                    case -10 -> answer.append("a");
            }
        }
        
        return answer.toString();
    }
}