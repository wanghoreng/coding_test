package SWEA.D4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SWEA_D4_최소이동거리 {

    static int V, E;  // 정점의 개수, 간선의 개수
    static List<Edge>[] adj;
    static int[] dist; // 거리 저장
    static final int INF = 987654321;
    static boolean[] visited;

    static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 1; t <= T; t++) {
            V = sc.nextInt(); // 정점의 개수 (0~V번까지)
            E = sc.nextInt(); // 간선의 개수

            // 인접리스트
            adj = new ArrayList[V+1];

            // 해당 정점의 인접한 정점들 저장하는 공간 만들어주기
            // 아래와 같이 넣으면, 해당 정점의 인접한 정점들의 공간은 null 로 들어가게 됨
            for(int i = 0; i <= V; i++) {
                adj[i] = new ArrayList<>();
            }

            // 정점 개수만큼 거리저장할 수 있는 배열 만들기
            dist = new int[V+1];
            // 거리저장하는 배열에 무한대로 거리를 만들어두기
            Arrays.fill(dist, INF);
            // 방문 저장하는 배열 만들기
            visited = new boolean[V+1];

            // edge 에 정점과 가중치 저장하기
            for(int i = 0; i < E; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int cost  = sc.nextInt();
                // 해당 정점에 인접한 정점과 그 정점들을 잇는 가중치 저장
                adj[from].add(new Edge(to, cost));
            }

            // 다익스트라 메서드 호출
            dijkstra(0);


            // 출력
            System.out.println("#" + t + " " + dist[V]);
        }

    }

    private static void dijkstra(int start) {
        dist[start] = 0;
        for(int i = 0; i < V; i++) {
            int min = INF;
            int idx = -1;
            // 현재 저장된 거리 dist 중 가장 작은 최소거리 찾기
            for(int j = 0; j <= V; j++) {
                // 방문하지않았으면서, 최소 거리가 가장 작은 값 찾기
                if(!visited[j] && dist[j] < min) {
                    min = dist[j];
                    idx = j;
                }
            } // 가장 작은 것 뽑기


            if (idx == -1) break; // 가장 작은게 없거나, 음수인 경우 멈추기

            visited[idx] = true;  // 해당 idx 는 가장 작은 것이므로 최소 거리 확정!

            // 현재 adj 에서 인접한 것들을 찾아서 갱신 시켜주기
            for(Edge e : adj[idx]) {
                // 방문하지 않았으면서, 현재 인접한 정점과의 가중치가 다른 길보다 작다면
                if(!visited[e.to] && dist[e.to] > dist[idx]+e.cost) {
                    dist[e.to] = dist[idx] + e.cost;
                }
            }
        }

    }

}