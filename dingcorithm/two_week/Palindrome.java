package dingcorithm.two_week;

// 회문검사 : 똑바로 읽으나 거꾸로 읽으나 똑같은 단어나 문장을 의미한다.
public class Palindrome {
    public static void main(String[] args) {
        String input = "abcba";
        System.out.println(isPalindrome(input));
        System.out.println(isPalindromeForRecursion(input));
    }

    private static boolean isPalindrome(String str) {
        // 문자열의 인덱스 맨 앞과 맨 뒤에서부터 점점 같은지 확인해나가는 방식
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
        }
        return true;
    }

    // 문자열의 맨 앞과 맨 뒤가 같으면 잘라나가는 식으로 재귀함수를 사용하여 비교하는 방식
    private static boolean isPalindromeForRecursion(String str) {
        if(str.charAt(0) != str.charAt(str.length()-1)) return false;
        if(str.length() == 1) return true;
        return isPalindromeForRecursion(str.substring(1,str.length()-1));
    }
}
