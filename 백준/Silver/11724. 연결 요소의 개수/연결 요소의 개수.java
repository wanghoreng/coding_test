import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 방향없는 그래프의 연결 요소의 개수를 구하는 프로그램
    // 2) 서로소 집합 형식으로 푼 방법
    static int[] p;         // 부모를 저장하는 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수

        p = new int[N+1]; // 0 제외

        // 1. Make-Set
        for(int n = 1; n < N+1; n++) {
            // 해당 정점을 본인이 대표자인 걸로 만들어주기
            p[n] = n;
        }

        // 2. Union (서로 연결된 정점끼리 Union 해주기)
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        // 3. 대표자가 다른 애들만 카운트
        Set<Integer> s = new HashSet<>();
        for(int i = 1; i < p.length; i++) {
            s.add(findSet(p[i]));
        }

        System.out.println(s.size());

    }

    private static void union(int a, int b) {

        int rootX = findSet(a);
        int rootY = findSet(b);

        // 서로의 대표자가 같지 않다면 한쪽을 다른 대표를 바라보게 만들기
        if(rootX != rootY) {
            p[rootY] = rootX;
        }

    }

    private static int findSet(int x) {

        // 본인이 대표가 아니라면 대표자를 찾을 때까지 반복 !
        if(p[x] != x) {
            p[x] = findSet(p[x]);
        }

        return p[x];
    }


    // 1) DFS 형식으로 푼 방법
    // 1. 정점의 개수 N, 간선의 개수 M
    // 2. M 개의 줄에는 간선의 양 끝 점 u, v
//    static int N, M;
//    static List<Integer>[] adjList; // 인접리스트
//    static boolean[] visitedDFS; // dfs 방문배열
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken()); // 정점의 개수
//        M = Integer.parseInt(st.nextToken()); // 간선의 개수
//        visitedDFS = new boolean[N+1];
//
//        adjList = new ArrayList[N+1]; // 0번 제외
//        for(int n = 1; n < N+1; n++) {
//            adjList[n] = new ArrayList<>();
//        }
//
//        // 간선 담기
//        for(int m = 0; m < M; m++) {
//            st = new StringTokenizer(br.readLine());
//            int from = Integer.parseInt(st.nextToken());
//            int to = Integer.parseInt(st.nextToken());
//
//            // 무향 그래프
//            adjList[from].add(to);
//            adjList[to].add(from);
//        }
//
//        // dfs 를 돌았는데도,
//        // 여전히 방문하지 않은 정점이 있다면 그것은 서로 연결되어 있지 않은 간선이 있다는 것
//        int res = 0; // 요소 변수 카운트
//        for(int v = 1; v < N+1; v++) {
//            if (!visitedDFS[v]) {
//                dfs(v);
//                res++;
//            }
//        }
//        System.out.println(res);
//    }
//
//    private static void dfs(int v) {
//        visitedDFS[v] = true;
//
//        for(int curr : adjList[v]) {
//
//            // 방문하지 않았다면!
//            if(!visitedDFS[curr]) {
//                dfs(curr);
//            }
//        }
//    }
}