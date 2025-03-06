
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            System.out.println(point(0,s.length()-1, s, 0));
        }

    }

    private static int point(int start, int end, String str, int check) {

        if(check >= 2) return 2;

        while(start < end) {
            if(str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                // 1. start 인덱스를 늘려가며 유사회문인지 검증
                // 2. end 인덱스를 줄여가며 유사회문인지 검증
                // 3. 1,2 번째 방식중 가장 작은 값을 반환시킴
                return Math.min(point(start+1, end, str, check+1)
                                , point(start, end-1, str, check+1));
            }
        }
        return check;
    }

}