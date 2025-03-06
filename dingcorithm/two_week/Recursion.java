package dingcorithm.two_week;

public class Recursion {

    public static void main(String[] args) {
        countPrint(60);
    }

    // 재귀 함수 는 재귀함수를 빠져나올 수 있는 지점을 정해줘야 한다.
    private static void countPrint(int num) {
        // 재귀함수를 빠져나오는 지점
        if(num < 0) {
            return;
        }
        System.out.println(num);
        countPrint(num - 1);
    }
}
