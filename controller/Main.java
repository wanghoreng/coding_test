package controller;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b;

        a = sc.nextInt();
        b = sc.nextInt();
        int c = b;

        // Stream 이용
//        int[] array = Stream.of(String.valueOf(b).split("")).mapToInt(Integer::parseInt).toArray();
//        System.out.println(a*array[2]);
//        System.out.println(a*array[1]);
//        System.out.println(a*array[0]);
//        System.out.println(a*b);

        // 나눗셈 연산
        while(b > 0) {
            System.out.println(a*(b%10));
            b /= 10;
        }
        System.out.println(a*c);
    }
}
