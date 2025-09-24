
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 가중치 없는 방향 그래프 (무향)
    // 인접 행렬 adjList

    // i -> j 로 가는 길이가 양수 ?
    // i 번째 줄의 j 번째 숫자
    static List<Integer>[] adjList; // 인접리스트
    static int V;
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine()); // 정점의 개수

        adjList = new ArrayList[V+1]; // 정점 1 ~ N
        answer = new int[V+1][V+1];
        for(int v = 1; v <= V; v++) {
            adjList[v] = new ArrayList<>();
        }

        // 인접행렬 받아서 그래프 그리기
        for(int i = 1; i <= V; i++) { // 현재 정점
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= V; j++) { // 인접한 정점과 연결됐는지 확인
                int index = Integer.parseInt(st.nextToken());
                if(index == 1) {
                    adjList[i].add(j);
                }
            }

        }

        for(int i = 1; i <= V; i++) {
            bfs(i);
        }

        for(int i = 1; i <= V; i++) {
            for(int j = 1; j <= V; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V+1];
        q.add(i);

        while(!q.isEmpty()) {
            int cur = q.poll(); // 현재 정점

            for(int next : adjList[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    answer[i][next] = 1;
                    q.add(next);
                }
            }
        }
    }
}