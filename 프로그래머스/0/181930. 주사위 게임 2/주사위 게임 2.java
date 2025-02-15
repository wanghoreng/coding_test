class Solution {
    public int solution(int a, int b, int c) {
        
        // 내 풀이 
        /**
        - Math.pow() 는 double 형을 반환하여 int 로 type 변환을 해줘야 한다. 
        
        if(a != b && b != c && c != a) {return a + b + c;} 
        else if((a == b && b != c) || (a == c && a != b) || (b == c && a != b)) {
            return (a + b + c) * (int)(Math.pow(a, 2) + Math.pow(b,2) + Math.pow(c,2));
        } else {
            return (a + b + c) 
                * (int)(Math.pow(a, 2) + Math.pow(b,2) + Math.pow(c,2)) 
                * (int)(Math.pow(a, 3) + Math.pow(b,3) + Math.pow(c,3));
        }
        */
        
        // 다른 풀이 (재귀함수 사용)
        int answer = a + b + c; 
        int count = 1; 
        
        if(a == b || b == c || c == a) count++; 
        
        if(a == b && b == c) count++; 
        
        for(int i = 1; i < count; i++) {
            answer *= (a*pow(a,i) + b*pow(b,i) + c*pow(c,i)) ;
        }
        
        return answer; 
    }
    
    private int pow(int x, int y) {
        if(y == 0) return 1; 
        return x * pow(x, y-1);
    }
}