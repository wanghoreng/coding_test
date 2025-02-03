package controller;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // // BufferedReader를 사용하기 위해서는 throws IOException을 해주어야 함.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // br.readLine 으로 띄어쓰기 된 입력값 을 받게 될 경우 String 으로 인식함
        // int a = Integer.parseInt(br.readLine());         (X)

        while(n > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] array = new int[2];

            for(int i = 0; i < 2; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            // write() 메소드를 통해 출력할 내용 담기
            // bw 에 쓸 때 String 타입으로 변환해주지 않으면 이상한 문자열이 출력됨
            bw.write(String.valueOf(array[0] + array[1]));
            bw.write("\n");

            n--;
        }

        // inputStream 닫기
        br.close();

        // flush() 메소드를 통해 버퍼를 비워내는 동시에 콘솔에 출력
        bw.flush();

        // outputStream 닫기
        bw.close();

    }
}