import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 서로 다른 나머지를 고르기 위한 중복제거 자료구조 Set 사용
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            set.add(n % 42);
        }

        // Set 에 담긴 데이터 개수 세기
        System.out.println(set.size());
    }
}
