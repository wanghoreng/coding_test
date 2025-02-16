class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for(int i = 0; i < queries.length; i++) {
            int data = arr[queries[i][0]];
            arr[queries[i][0]] = arr[queries[i][1]]; 
            arr[queries[i][1]] = data; 
        }
        
        return arr;
    }
}