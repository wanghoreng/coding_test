
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 시작정점과 연결된 컴퓨터의 수를 출력하는 프로그램

    // 1. 정점의 개수(컴퓨터수) N (1번 ~ N번)
    // 2. 네트워크 상에서 직접 연결되어있는 컴퓨터 쌍의 수 (간선의 개수)
    // 3. 간선의 개수만큼 정점 1, 2

    static int N, M;
    static List<Integer>[] adjList; // 인접리스트
    static boolean[] visitedDFS; // dfs 방문배열
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 정점의 개수
        M = Integer.parseInt(br.readLine()); // 간선의 개수
        visitedDFS = new boolean[N+1];

        adjList = new ArrayList[N+1]; // 0번 제외
        for(int n = 1; n < N+1; n++) {
            adjList[n] = new ArrayList<>();
        }

        // 간선 담기
        for(int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 무향 그래프
            adjList[from].add(to);
            adjList[to].add(from);
        }

        dfs(1);
        System.out.println(count-1); // 1은 제외하고 카운트
    }

    private static void dfs(int v) {
        visitedDFS[v] = true;
        count++;

        for(int curr : adjList[v]) {

            // 방문하지 않았다면!
            if(!visitedDFS[curr]) {
                dfs(curr);
            }
        }
    }
}