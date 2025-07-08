
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{

        // 학생 수 5
        // 처음에 줄을 선 순서 대로 매김 : 1 2 3 4 5
        // 순서대로 번호표 뽑은 결과 : 0 1 1 3 2
        // 1 -> 0 그대로
        // 2 -> 1 한칸 앞으로 2 1 3 4 5
        // 3 -> 1 한칸 앞으로 2 3 1 4 5
        // 4 -> 3 3칸 앞으로 4 2 3 1 5
        // 5 -> 2 2칸 앞으로 4 2 5 3 1

        // -> 배열에 처음 순서 숫자를 담은 뒤
        // -> 인덱스를 통해 번호표 대로 위치 변경
        // -> 이 때 arrayList 의 add 메서드를 사용하면 특정 인덱스 위치에 데이터를 넣을 수 있고
        //    특정 인덱스 뒤에 있던 값들은 자동으로 뒤로 밀린다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> orderList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int changeIdx = i - num;
            orderList.add(changeIdx, i+1);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(i == n-1 ? orderList.get(i) + "\n" : orderList.get(i) + " ");
        }

    }
}