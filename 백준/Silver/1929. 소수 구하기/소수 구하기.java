

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        List<Integer> answerList = new ArrayList<>();
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);

        if(m == 1) {
            m += 1; 
        } else if (m == 0) {
            m += 2; 
        }

        for(int i = m; i <= n; i++) {
            boolean flag = true;
            for(int j = 2; j*j <= i; j++) {    // 자기자신까지 나누지 않고, 그 앞의 수까지만 나눔
                if(i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                answerList.add(i);
            }
        }

        for(int i :answerList) {
            System.out.println(i);
        }
    }
}