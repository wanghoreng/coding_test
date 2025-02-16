class Solution {
    public int solution(int n, String control) {
        char[] controlArr = control.toCharArray();
        for(char c :controlArr) {
            switch (c) {
               case 'w' -> n += 1; 
               case 's' -> n -= 1; 
               case 'd' -> n += 10; 
               case 'a' -> n -= 10; 
            }
        }
        return n;
    }
}