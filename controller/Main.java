package controller;


import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(5,55));
    }

    public static List<Integer> solution(int l, int r) {
        // l 이상 r 이하 정수 중 0, 5 로만 이루어진 모든 정수를 오름차순으로 저장한 배열
        // 없으면 -1

        List<Integer> list = new ArrayList<>();

        for(int i = l; i <= r; i++) {
            boolean isValid = true;
            if(i % 5 == 0) {
                String s = String.valueOf(i);
                for(int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if(c != '0' && c != '5') {
                        isValid = false;
                        break;
                    }
                }

                if(isValid) {
                    list.add(i);
                }
            }
        }


        if(list.isEmpty()) {
            list.add(-1);
        }

        return list;
    }
}