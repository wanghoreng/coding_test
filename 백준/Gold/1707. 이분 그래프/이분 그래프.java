import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 이분 그래프 (색깔로 구분한다 : 한 색상을 정하고, 해당 정점과 인접한 정점은 다른 색상을 칠한다)
    static List<Integer>[] adjList; // 정점 인접 리스트
    static int V, E;
    static int[] colors;        // 각 정점의 색을 구분하는 배열 (1 : R, -1 : B)
    static boolean checkBipartite ; // 같은 색인지 체크하는 불리언

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            checkBipartite = true;
            colors = new int[V+1];

            adjList = new ArrayList[V+1]; // 1 ~ V
            for(int v = 1 ; v < V+1; v++) {
                adjList[v] = new ArrayList<>();
            }

            for(int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                // 양방향 그래프
                adjList[u].add(v);
                adjList[v].add(u);
            }

            for(int v = 1; v < V+1; v++) {

                if(!checkBipartite) break;

                if(colors[v] == 0) { // 방문안한 상태
                    bfs(v, 1);  // 방문정점과 색상  
                }
            }

            // 출력
            System.out.println(checkBipartite ? "YES" : "NO");
        }
    }

    private static void bfs(int v, int color) {

        colors[v] = color;  // 방문

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(v);

        while(!q.isEmpty() && checkBipartite) {
            int curr = q.poll();

            // 해당 정점의 인접한 정점들
            for(int cur : adjList[curr]) {

                // 방문을 안했다면 다른색으로 칠해주기
                if(colors[cur] == 0) {
                    q.offer(cur);
                    colors[cur] = colors[curr] * -1; // 인접한 정점을 다른 색으로 변경
                } else if(colors[curr] + colors[cur] != 0) { // 1 -1 = 0 이 아니라면 ?
                    // 서로 인접한 정점의 색상이 같다는 의미로 이분 그래프가 아니다.
                    checkBipartite = false;
                    return;
                }

            }
        }
    }

}