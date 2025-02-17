package dingcorithm.first_week;

import java.io.IOException;
import java.util.*;

public class TwoFinxMaxOccurredAlphabet {
    public static void main(String[] args) throws IOException {
        // 그냥 배열을 출력하면 이상한 해시코드로 나오기에
        // 배열을 출력할 때는 Arrays.toString(배열)을 사용해보자.
        System.out.println(Arrays.toString(findMaxOccurredAlphabet("hello my name is dingcodingco")));
        System.out.println(Arrays.toString(findMaxOccurredAlphabet("we love algorithm")));
        System.out.println(Arrays.toString(findMaxOccurredAlphabet("best of best youtube")));
    }

    private static int[] findMaxOccurredAlphabet(String str) {

        int[] alphabetMax = new int[26];

        for(char s : str.toCharArray()) {
            if(s != 32) {
                int index = s - 97;
                alphabetMax[index] += 1;
            }
        }

        return alphabetMax;
    }

}
