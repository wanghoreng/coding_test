package dingcorithm.two_week;

import java.util.*;

public class AvailableToOrder {

    public static void main(String[] args) {
        String[] menuArr = {"만두", "떡볶이", "오뎅", "사이다", "콜라"};
        String[] orderArr  = {"오뎅", "사이다", "만두"};

        System.out.println(isAvailableToOrder(menuArr, orderArr));
        System.out.println(isAvailableToOrderBySet(menuArr, orderArr));
    }

    // 내풀이 (이진탐색 사용안하고, 순수 로직 - 시간복잡도 : O(N^2))
    private static boolean isAvailableToOrder(String[] menuArr, String[] orderArr) {
        // 주문한 음식이 메뉴에 존재하는지 확인한다.

        Object[] menuArray = Arrays.stream(menuArr).sorted().toArray();
        Object[] orderArray = Arrays.stream(orderArr).sorted().toArray();


        int possibleSize = 0;
        for(Object menu : menuArray) {
            for(Object order : orderArray) {
                if(String.valueOf(order).equals(String.valueOf(menu))) {
                    possibleSize++;
                }
            }
        }

        if(orderArray.length == possibleSize) {
            return true;
        } else {
            return false;
        }
    }

    // set 집합 사용시 contains 함수 사용가능 -> 시간복잡도 : O(N + M)
    private static boolean isAvailableToOrderBySet(String[] menuArr, String[] orderArr) {

        // set 의 특징 (중복을 제거해줌)
        Set<String> set = new HashSet<String>(List.of(menuArr)); // N
        for(String order : orderArr) {     // M
            if(!set.contains(order)) {      //  1
                return false;
            }
        }

        return true;
    }
}
