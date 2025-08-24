import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 회사에 있는 사람
public class Main {
    // 출퇴근 로그를 통해 현재 회사에 있는 모든 사람을 구하는 프로그램 작성
    // 로그에 기록된 출입 기록의 수 N
    // 다음 N 개의 줄에는 출입기록이 순서대로 주어짐
    // 각 사람의 이름이 주어지고, enter 출근 / leave 퇴근
    // 동명이인 X, 대소문자가 다른 경우 다른 이름임
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> enterLog = new HashMap<>();
        for(int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String employee = st.nextToken();
            String status = st.nextToken();

            if(status.equals("enter")) {
                enterLog.put(employee, n);
            } else {
                if(enterLog.containsKey(employee)) {
                    enterLog.remove(employee);
                }
            }
        }

        String[] arr = new String[enterLog.size()];
        int index = 0;
        for(Map.Entry<String, Integer> log : enterLog.entrySet()) {
            arr[index] = log.getKey();
            index++;
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for(int i = arr.length-1; i >= 0; i--) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }

}