package SWEA.D4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SWEA_D4_사칙연산 {
    static final int TEST_CASE = 10;
    static int[] left;
    static int[] right;
    static String[] data; // 정수 or 연산자
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileReader("input.txt"));
//        Scanner sc = new Scanner(System.in);

        // 식 방식은 중위연산방식(LVR)
        // 모두 실수 연산
        for(int t = 1; t <= TEST_CASE; t++) {

            // 정점의 개수
            int N = sc.nextInt();
            left = new int[N+1];
            right = new int[N+1];
            data = new String[N+1];
            int[] parent = new int[N+1];


            // N 줄에 걸쳐 각 정점의 정보
            for(int n = 1; n < N+1; n++) {

                String[] tokens = sc.nextLine().split(" ");
                int p = Integer.parseInt(tokens[0]); // 정점번호
                String word = tokens[1];
                // 연산자 인 경우, "정점번호 연산자 왼자번호 우자번호"
                if(tokens.length >= 4) {
                    int c1 = Integer.parseInt(tokens[2]); // 왼자번호 저장
                    left[p] = c1;
                    parent[p] = c1;

                    int c2= Integer.parseInt(tokens[3]); // 우자번호 저장

                    right[p] = c2;  // 우자번호 저장
                    parent[c2] = p; // 부모정점번호 저장
                }
                // 데이터 or 연산자 저장
                data[p] = tokens[1];

                // 정수 인 경우, "정점번호 양의정수"
                // 루트 정점의 번호는 항상 1 !
                int root = 1;
            }


            // 출력
            System.out.println("#" + t + " ");
        }
    }
}
