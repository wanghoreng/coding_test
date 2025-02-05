package controller;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[31];

        for(int i =1; i<29; i++) {
            int pass = Integer.parseInt(br.readLine());
            arr[pass] = 1;
        }

        for(int j=1; j<arr.length; j++) {
            if(arr[j]!=1) {
                System.out.println(j);
            }
        }

    }
}