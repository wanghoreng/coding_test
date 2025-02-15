class Solution {
    public String solution(String code) {
        
        int mode = 0; 
        String result = ""; 
        
        for(int i = 0; i < code.length(); i++) {
            
            if(mode == 0) {
                if(code.charAt(i) == '1') mode = 1;
                else {
                    if(i % 2 == 0) {
                        result += code.charAt(i); 
                    }
                }
            } else {
                if(code.charAt(i) == '1') mode = 0;
                else {
                    if(i % 2 != 0) {
                        result += code.charAt(i); 
                    }
                }
            }
            
            
        }
        
        return result.equals("") ? "EMPTY" : result;
    }
}