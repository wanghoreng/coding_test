import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{

        // M ~ N 까지의 자연수 중 소수인 것을 찾기
        // 해당 소수 의 합 sum
        // 최소값 min

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        // 소수란, 약수가 본인과 자기자신인 것뿐
        List<Integer> primeNumList = new ArrayList<>();
        int sum = 0;
        for(int i = M; i <= N; i++) {

            List<Integer> divisorList = new ArrayList<>();
            for(int j = 1; j <= i; j++) {
                // 소수의 약수를 담는 리스트 사이즈는 2개가 최대이므로, 넘어가면 소수가 아님
                if(divisorList.size() > 2) break;

                // 약수를 담는 리스트
                if(i % j == 0) divisorList.add(j);
            }
            // 리스트 사이즈 체크와 동시에 2개의 데이터 중 맨 끝 데이터가 본인인지 확인
            if(divisorList.size() == 2 && divisorList.get(1) == i) {
                // 소수임을 증명한 데이터로 소수 리스트에 삽입
                primeNumList.add(i);
                sum += i;
            }
        }

        // 소수 자체가 없다면 -1 반환
        if(primeNumList.isEmpty()) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            System.out.println(sb.append(sum).append("\n").append(primeNumList.get(0)));
        }

    }
}