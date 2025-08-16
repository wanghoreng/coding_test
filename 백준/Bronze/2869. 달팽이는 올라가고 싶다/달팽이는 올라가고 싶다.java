import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 낮
        int B = Integer.parseInt(st.nextToken()); // 밤
        int V = Integer.parseInt(st.nextToken()); // 막대길이


        // 첫번째 시뮬레이션 방식 -> 시간복잡도 O(V) : V가 클 때 비효율적
//        int move = 0;
//        int day = 1;

        // 움직인 거리가 막대길이보다 작을 때까지 반복
//        while(move < V) {
//            move += A;
//            if(move >= V) {
//                System.out.println(day); break;
//            }
//            move -= B;
//            day++;
//        }

        // 두번째 수학 방식 -> 시간복잡도 O(1) : 즉시 결과 계산 가능 (아주 빠름)

        // 나눠 떨어진다는 것은 바로 낮에 도착했다는 의미
        int day = (V - B) / (A -B);
        if((V - B) % (A -B) != 0) day++;
        System.out.println(day);
    }
}