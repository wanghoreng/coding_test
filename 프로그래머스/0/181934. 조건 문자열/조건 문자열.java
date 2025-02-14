class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        
        boolean flag = false; 
        switch(eq) {
            case "=" -> {
                flag = ineq.equals(">") ? n >= m : n <= m;
            }
            case "!" -> {
                flag = ineq.equals(">") ? n > m : n < m;
            }
        }
        
        return flag == true ? 1 : 0;
    }
}