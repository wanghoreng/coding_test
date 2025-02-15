class Solution {
    public String solution(String code) {
        
        int mode = 0; 
        
        // 내 코드 
        // String result = ""; 
//         for(int i = 0; i < code.length(); i++) {
            
//             if(mode == 0) {
//                 if(code.charAt(i) == '1') mode = 1;
//                 else {
//                     if(i % 2 == 0) {
//                         result += code.charAt(i); 
//                     }
//                 }
//             } else {
//                 if(code.charAt(i) == '1') mode = 0;
//                 else {
//                     if(i % 2 != 0) {
//                         result += code.charAt(i); 
//                     }
//                 }
//             }
            
            
//         }
        
        // 다른 풀이 
        StringBuilder result = new StringBuilder(); 
        
        for(int i = 0; i < code.length(); i++) {
            
            char c = code.charAt(i);
            if(c == '1') {
                mode = mode == 0 ? 1 : 0; 
                continue; 
            }
            
            if(i % 2 == mode) {
                result.append(code.charAt(i)); 
            }
        }
        
        return result.length() == 0 ? "EMPTY" : result.toString();
    }
}