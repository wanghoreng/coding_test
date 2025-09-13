package SWEA.D3.회문2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    // 문자 하나여도 회문임
    // 가로, 세로 직선만 판단함
    static final int TEST_CASE = 10;
    static char[][] strArr;
    static final int SIZE = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./SWEA/D3/input.txt")));

        for(int t = 1; t <= TEST_CASE; t++) {
            int T =Integer.parseInt(br.readLine());

            // 배열담기
            strArr = new char[SIZE][SIZE];
            for(int i = 0; i < SIZE; i++) {
                String str = br.readLine();
                strArr[i] = str.toCharArray();
            }

            // 가장 긴 회문 길이 찾기
            int maxLength = findMaxLength();

            // 출력
            System.out.println("#" + T + " " + maxLength);
        }

    }

    // 가장 긴 회문 길이를 찾는 메서드
    private static int findMaxLength() {

        // 0 ~ 99행 탐색을 거꾸로 !
        for(int len = SIZE; len >= 1; len--) {
            for(int r = 0; r < SIZE; r++) {
                // 탐색하는 라인(row, col) 의 인덱스 조절을 위해
                // ex. size(8), 8-8=0, 8-7=1; 8-6=2.. 8-1=7
                for(int c = 0; c <= SIZE-len; c++) {

                    // 가로 회문 체크
                    if(isCol(r, c, len)) return len;

                    // 세로 회문 체크 (세로에서는 c가 탐색하는 열 인덱스가 됨)
                    if(isRow(c, r, len)) return len;

                }
            }
        }


        return 1;
    }

    // 가로 회문
    private static boolean isCol(int r, int c, int len) {

        for(int i = 0; i < len/2; i++) {
            if(strArr[r][c+i] != strArr[r][c+len-1-i]) return false;
        }

        return true;
    }

    // 세로 회문
    private static boolean isRow(int r, int c, int len) {
        for(int i = 0; i < len/2; i++) {
            if(strArr[r+i][c] != strArr[r+len-1-i][c]) return false;
        }
        return true;
    }
}
