package dingcorithm.two_week;

public class Factorial {

    static int plusCnt = 1;

    public static void main(String[] args) {
        System.out.println(factorialCount(5));
        System.out.println(factorial(5));
    }

    // 내가 푼 풀이
    public static int factorialCount(int n) {
        if(n < 1) return plusCnt;
        plusCnt *= n;
        return factorialCount(n-1);
    }

    // 다른 풀이
    public static int factorial(int n) {
        if(n == 1) return 1;
        return n * (factorial(n-1));
    }
}
