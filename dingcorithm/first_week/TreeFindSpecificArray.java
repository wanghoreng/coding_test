package dingcorithm.first_week;

import java.util.*;

public class TreeFindSpecificArray {
    public static void main(String[] args) {
        /**
         *  빅오 표기법 : 최악의 경우
         *  빅오메가 표기법 : 최선의 경우
         * */

        // 최선의 경우 빅오메가 (1) 밖에 안걸림 -> 인덱스 맨앞의 3을 찾아 딱 한번만 돌면 찾기 때문
        System.out.println(isNumberExist(3, new int[]{3, 5, 6, 1, 2, 4}));
        // 최악의 경우 빅오 (N) 만큼 걸림 -> 인덱스 맨 마지막의 4를 찾아야하기에 배열의 끝까지 반복문을 돌려야함
        System.out.println(isNumberExist(4, new int[]{3, 5, 6, 1, 2, 4}));

        // -> 결론 : 알고리즘의 성능은 항상 동일한게 아니기 때문에 최악의 경우,
        // 즉, 빅오표기법을 기준으로 알고리즘을 개발해야한다.

        System.out.println(isNumberExist(7, new int[]{6,6,6}));
        System.out.println(isNumberExist(2, new int[]{6,9,2,7,1888}));
    }

    private static boolean isNumberExist(int number, int[] array) {
        // 시간 복잡도 = N
        for(int num : array) {
            if(num == number) {
                return true;
            }
        }
        return false;
    }

}
