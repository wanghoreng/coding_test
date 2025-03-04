import java.util.*; 

class Solution {
    public int[] solution(int[] arr) {
        
        // 내풀이
        /*
        List<Integer> stk = new ArrayList<>(); 
        for(int i = 0; i < arr.length; i++) {
            if(stk.size() == 0) {
                stk.add(arr[i]); 
            } else if(stk.get(stk.size() - 1) < arr[i]) {
                stk.add(arr[i]);
            } else {
                stk.remove(stk.size() - 1);
                i -= 1; 
            }
        }
        return stk.stream().mapToInt(i->i).toArray();
        */
        
        // 다른 풀이 
        Stack<Integer> stack = new Stack<>(); 
        int i = 0;
        while(i < arr.length) {
            if(stack.isEmpty() || stack.peek() < arr[i]) {
                stack.push(arr[i]); 
                i++; 
            } else {
                stack.pop(); 
            }
        }
        
        return stack.stream().mapToInt(j->j).toArray(); 
        
    }
}