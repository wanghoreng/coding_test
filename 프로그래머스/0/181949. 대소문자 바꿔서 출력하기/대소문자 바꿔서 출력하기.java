import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        for(int i = 0; i < a.length(); i++) {
            // Character.isUpperCase(a.charAt(i)) 로 대소문자여부 체크하는 게 있음
            // if((int)a.charAt(i) <= 96) {
            if(Character.isUpperCase(a.charAt(i))) {
                System.out.print(Character.toLowerCase(a.charAt(i)));
            } else {
                System.out.print(Character.toUpperCase(a.charAt(i)));
            }
        }
    }
}