class Solution {
    public int solution(int a, int b) {
        int plus = Integer.parseInt(""+a+b);
        int x = 2*a*b;
        
        return plus < x ? x : plus;
    }
}