
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        // 풀이 1. linkedList 방식으로 풀이함
        /*
        * list 를 앞에서부터 삭제하고 삭제한 데이터를 다시 list 의 뒤로 붙여가며
        * k번째 데이터를 찾아, 삭제한다.
        *  */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        StringBuilder sb = new StringBuilder("<");
//
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = 1; i <= n; i++) {
//            list.add(i);
//        }
//
//        while(!list.isEmpty()) {
//            for (int i = 0; i < k; i++) {
//                if(i == k-1) {
//                    if(list.size() == 1) {
//                        sb.append(list.remove());
//                    } else {
//                        sb.append(list.remove() + ", ");
//                    }
//                } else {
//                    // LinkedList remove 메서드 :  리스트에서의 맨앞에꺼를 삭제한다.
//                    // 이 과정은 맨앞에 꺼를 삭제함과 동시에 list 의 맨 뒤에 다시 삽입하는 과정이다.
//                    list.add(list.remove());
//                }
//            }
//        }
//
//        sb.append(">");
//
//        System.out.println(sb);

        // 풀이 2. 큐 방식으로 풀이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder("<");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() != 1) {
            for (int i = 0; i < k-1; i++) {
                // K번째 전까지 맨앞데이터를 삭제하고 뒤로 넣는 작업을 반복
                q.offer(q.poll());
            }
            // K번째가 되면서 맨앞데이터를 뽑아내고 다시 K번째 찾기 반복
            sb.append(q.poll()).append(", ");
        }

        // 마지막 1개 남은 데이터까지 뽑아내면 끝
        sb.append(q.poll()).append(">");
        System.out.println(sb);

    }

}


