import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 단어 정렬
public class Main {
    // 1. 길이가 짧은 것부터
    // 2. 길이가 같으면 사전 순으로
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 중복 제거!
        Set<String> setWords = new HashSet<>();
        for(int i = 0; i < N; i++) {
            setWords.add(br.readLine());
        }
        String[] words = new String[setWords.size()];

        words = setWords.toArray(words);

        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {

                int len = (words[i]).length();
                int len2 = (words[j]).length();

                if(len > len2) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                } else if(len == len2) { // 만약 길이가 같다면
                    int order = words[i].compareTo(words[j]);
                    if(order > 0) { // 음수일 경우 words[i]가 앞선 것이기 때문에 양수로 체크
                        String temp = words[i];
                        words[i] = words[j];
                        words[j] = temp;
                    }
                }
            }
        }

        for(String word : words) {
            System.out.println(word);
        }
    }

}