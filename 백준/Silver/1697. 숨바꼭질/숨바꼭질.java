
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dist;
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dist = new int[MAX+1];

        bfs(N);

        System.out.println(dist[K]-1); // 시작점 방문 초수 빼기

    }

    private static void bfs(int start) {
        dist[start] = 1; // 방문
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int curr = q.poll();

            // 3가지 방향 움직임 
            int[] nextPos = {curr-1, curr+1, curr*2};
            for(int next : nextPos) {
                // 범위 내 이면서, 방문하지 않았더라면
                if(next >= 0 && next <= MAX && dist[next] == 0) {
                    dist[next] = dist[curr] + 1;
                    q.offer(next);
                }
            }
        }
    }
}