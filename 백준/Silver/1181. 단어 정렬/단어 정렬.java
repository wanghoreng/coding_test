import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

// 단어 정렬
public class Main {
    // 1. 길이가 짧은 것부터
    // 2. 길이가 같으면 사전 순으로
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 아래 방식이 너무 시간이 오래걸려서 다시 리팩토링 진행
        // 중복 제거!
//        int N = Integer.parseInt(br.readLine());
//        Set<String> setWords = new HashSet<>();
//        for(int i = 0; i < N; i++) {
//            setWords.add(br.readLine());
//        }
//        String[] words = new String[setWords.size()];
//
//        words = setWords.toArray(words);
//
//        for(int i = 0; i < words.length; i++) {
//            for(int j = i+1; j < words.length; j++) {
//
//                int len = (words[i]).length();
//                int len2 = (words[j]).length();
//
//                if(len > len2) {
//                    String temp = words[i];
//                    words[i] = words[j];
//                    words[j] = temp;
//                } else if(len == len2) { // 만약 길이가 같다면
//                    int order = words[i].compareTo(words[j]);
//                    if(order > 0) { // 음수일 경우 words[i]가 앞선 것이기 때문에 양수로 체크
//                        String temp = words[i];
//                        words[i] = words[j];
//                        words[j] = temp;
//                    }
//                }
//            }
//        }
//
//        for(String word : words) {
//            System.out.println(word);
//        }


        // 방법 2. comparator 인터페이스의 compare 사용자 정의 정렬 기준 적용
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, new Comparator<String>() {

            @Override
            public int compare(String str1, String str2) {
                if(str1.length() == str2.length()) {
                    return str1.compareTo(str2);
                } else {
                    return str1.length() - str2.length();
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(words[0]).append("\n");

        for(int i = 1; i < words.length; i++) {
            if(!words[i].equals(words[i-1])) {
                sb.append(words[i]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }


}