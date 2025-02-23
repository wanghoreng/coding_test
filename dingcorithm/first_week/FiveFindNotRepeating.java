package dingcorithm.first_week;

import java.util.*;

public class FiveFindNotRepeating {
    public static void main(String[] args) {
        System.out.println(findNotRepeatingFirstCharacter("abadabac"));
        System.out.println(findNotRepeatingFirstCharacter("aabbcddd"));
        System.out.println(findNotRepeatingFirstCharacter("aaaaaaaa"));
    }

    private static String findNotRepeatingFirstCharacter(String str) {

        // 내풀이 (이중반복문이여서) ->  시간복잡도 = O(N^2)
        /*

        // 1. 반복문을 돌면서 같은 문자가 있다면 +1, 없다면 0;
        // 2. 0 인 문자열을 반환, 0인 문자열이 없다면 _ 반환
        String answer = "";

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int count = 0;

            for(int j = 0; j < str.length(); j++) {
                if(c == str.charAt(j)) {
                    count += 1;
                }
            }

            if(count == 1) {
                answer =  String.valueOf(c);
                break;
            } else {
                answer =  "_";
            }
        }

        return answer;
         */

        // 다른 풀이 -> 시간복잡도 = O(N)
        Map<Character, Integer> map = new HashMap<>();
        char c;

        for(int i = 0; i <str.length(); i++) {
            c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if(map.get(c) == 1) {
                return String.valueOf(c);
            }
        }

        return "_";
    }
}
