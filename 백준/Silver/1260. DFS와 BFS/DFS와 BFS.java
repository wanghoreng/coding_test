
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // DFS ,BFS 로 탐색한 결과 출력하는 프로그램
    // 단, 방문할 수 있는 정점이 여러개인 경우 정점번호가 작은것을 먼저 방문
    // 더 이상 방문할 수 있는 점이 없는 경우 종료 !

    // 1. 정점의 개수 N, 간선의 개수 M, 탐색을 시작할 정점의 번호 V
    // 2. 정점 1 정점 2 (간선이며 양방향)

    static int N, M;
    static List<Integer>[] adjList; // 인접리스트
    static boolean[] visitedDFS; // dfs 방문배열
    static StringBuilder sb1 = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 정점
        visitedDFS = new boolean[N+1];

        adjList = new ArrayList[N+1]; // 0번 제외
        for(int n = 1; n < N+1; n++) {
            adjList[n] = new ArrayList<>();
        }

        // 간선 담기
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 무향 그래프
            adjList[from].add(to);
            adjList[to].add(from);
        }

        // 정렬
        for(int i = 1; i < N+1; i++) {
            Collections.sort(adjList[i]);
        }


        dfs(V);
        System.out.println(sb1);
        bfs(V);


    }

    private static void dfs(int v) {
        visitedDFS[v] = true;
        sb1.append(v).append(" ");

        for(int curr : adjList[v]) {

            // 방문하지 않았다면!
            if(!visitedDFS[curr]) {
                dfs(curr);
            }
        }
    }

    private static void bfs(int v) {
        boolean[] visited = new boolean[N+1]; // 정점개수만큼 방문 배열 만들기
        Deque<Integer> q = new ArrayDeque<>();// 큐 선언

        visited[v] = true;
        q.offer(v);
        StringBuilder sb = new StringBuilder();

        // 큐가 빌때까지
        while(!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");

            for(int curr : adjList[now]) {
                // 방문 안했다면
                if(!visited[curr]) {
                    q.offer(curr);
                    visited[curr] = true;
                }
            }
        }

        System.out.println(sb);

    }
}