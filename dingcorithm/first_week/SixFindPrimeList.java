package dingcorithm.first_week;

import java.util.ArrayList;
import java.util.List;

public class SixFindPrimeList {
    public static void main(String[] args) {
        System.out.println((findPrimeListUnderNumber(20)));
    }

    // 소수는 자기 자신과 1 외는 아무것도 나눌 수 없다.
    private static List<Integer> findPrimeListUnderNumber(int num) {

        // 1. 첫번째 방식은 모든 숫자를 한번씩 더 돌면서 구하기에 비효율적 (시간초과 뜸)
//        List<Integer> answerList = new ArrayList<>();
//        for(int i = 2; i <= num; i++) {
//            boolean flag = false;
//
//            for(int j = 2; j < i; j++) {    // 자기자신까지 나누지 않고, 그 앞의 수까지만 나눔
//                if(i % j == 0) {
//                    flag = true;
//                    break;
//                }
//            }
//
//            if(!flag) {
//                answerList.add(i);
//            }
//        }
        // 2. 두번째 방식은 여태까지 숫자가 올라갈수록 answerList 에 쌓여가는 소수들로 다시 구하는 방법
        // -> 예로 19 의 소수를 구할 때 1번방식은 1,2,3,4 .. 18 까지 모든 숫자를 다시 나누면서 소수인지 판별하지만
        // -> 2번방식은 여태 구해온 소수들로만 소수인지아닌지 판별함 (즉, 2,3,5,7,11,13,17로만 판별)

        // 3. N의 제곱근보다 크지 않은 어떤 소수로도 나누어 떨어지지 않는다.
//        List<Integer> answerList = new ArrayList<>();
//        for(int i = 2; i <= num; i++) {
//            boolean flag = false;
//
//            for(int j = 2; j*j <= i; j++) {    // 자기자신까지 나누지 않고, 그 앞의 수까지만 나눔
//                if(i % j == 0) {
//                    flag = true;
//                    break;
//                }
//            }
//
//            if(!flag) {
//                answerList.add(i);
//            }
//        }
//
//        return answerList;

        // 4. 아리스토테네스의 체 풀이법
        List<Integer> list = new ArrayList<>();

        boolean[] prime = new boolean[num+1];
        // 0 과 1 은 소수가 아니여서 제외
        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i*i < prime.length; i++) {
            if(prime[i]) continue;
            for(int j = i*i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        for(int i = 2; i <= num; i++) {

            if(!prime[i]) {
                list.add(i);
            }
        }

        return list;
    }
}
