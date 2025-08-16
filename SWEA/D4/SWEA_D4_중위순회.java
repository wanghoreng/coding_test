package SWEA.D4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SWEA_D4_중위순회 {

    static int[] left;
    static int[] right;
    static String[] data;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int T = 10; // 테스트케이스 수 T
        for (int tc = 1; tc <= T; tc++) {
            // 입력
            // 정점의 총 갯수 N
            int N = Integer.parseInt(sc.nextLine()); // "8" -> 정수 8

            // 왼쪽 자식, 오른쪽 자식, 자신 노드의 데이터, 부모 노드 배열 생성
            left = new int[N + 1];
            right = new int[N + 1];
            data = new String[N + 1];
            int[] parent = new int[N + 1];

            // N번 째 줄에 대해서 입력 케이스에 따른 입력처리를 해줘야한다!
            for (int i = 0; i < N; i++) {
                // 쉽게 처리하기 -> 한줄을 통째로 입력 받아라...!
                String line = sc.nextLine();
                // 개행(space)를 기준으로 해서 문자열 자르기 -> .split() 메서드!
                String[] tokens = line.split(" "); // {"현재정점번호", "노드데이터", "왼쪽자식번호", "오른쪽자식번호"}
                int p = Integer.parseInt(tokens[0]);
                String word = tokens[1];
                if (tokens.length >= 4) { // 오른쪽 자식
                    int c2 = Integer.parseInt(tokens[3]);

//                    data[p] = word; // 현재노드의 값을 저장
                    right[p] = c2;  // 부모 -> 오른쪽자식
                    parent[c2] = p; // 자식2 -> 부모
                }
                if (tokens.length >= 3) { // 왼쪽 자식
                    // - "현재정점번호 노드데이터 왼쪽자식번호" 3개 짜리
                    int c1 = Integer.parseInt(tokens[2]);

//                    data[p] = word; // 현재노드의 값을 저장
                    left[p] = c1;   // 부모 -> 왼쪽자식
                    parent[c1] = p; // 자식1 -> 부모
                }

                // - "현재정점번호 노드데이터" 2개 짜리
                data[p] = word; // 현재노드의 값을 저장

            }

            // 로직
            // 1. 루트노드를 찾아라....!
            // why?? 우리가 중위순회를 진행할 때에 첫번째 시작! -> '루트노드'부터 시작!
            // 루트노드 찾기는 어떻게 진행되나...? -> 아무 노드나 하나 선정! -> 부모 -> 부모 -> 부모... -> 부모가 X << 얘가 루트노드!
            // 1~N 번 까지의 노드 하나를 잡아서 부모노드로 쭈욱 탐색...!
//            int root = N; // 임시 루트노드
//            while(parent[root] != 0) { // 부모노드가 없으면 종료!
//                root = parent[root];
//            }

            // 2. 루트노드를 시작으로 중위순회를 진행한다.
            // 출력
            System.out.print("#" + tc + " ");
            inOrder(1); // 어차피 루트 정점번호는 항상 1로 고정되어있기때문에
            System.out.println();
        }
    }
    // 중위순회하는 재귀호출함수...
    public static void inOrder(int T){
        if(T != 0) {
            // L 왼쪽 자식
            inOrder(left[T]);
            // V 자기자신
            System.out.print(data[T]);
            // R 오른쪽 자식
            inOrder(right[T]);
        }
    }
}
