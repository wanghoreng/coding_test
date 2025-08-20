
import java.io.IOException;
import java.io.*;
import java.util.StringTokenizer;


class Main {
//    Equilateral :  세 변의 길이가 모두 같은 경우
//    Isosceles : 두 변의 길이만 같은 경우
//    Scalene : 세 변의 길이가 모두 다른 경우
    // 가장 긴 변의 길이 < 두 변의 길이 합 Invalid
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0) break;

            if(a == b && b == c) { // 세 변의 길이가 모두 같은 경우
                System.out.println("Equilateral");
            } else if(a == b || b == c || c == a) { // 두 변의 길이만 같은 경우
                // 가장 긴 변의 길이를 찾아야함
                if(a > b && a > c) {
                    if(a >= b + c) System.out.println("Invalid");
                    else System.out.println("Isosceles");
                } else if(b > a &&  b > c) {
                    if(b >= a + c) System.out.println("Invalid");
                    else System.out.println("Isosceles");
                } else {
                    if(c >= a + b) System.out.println("Invalid");
                    else System.out.println("Isosceles");
                }
            } else { // 세변의 길이가 모두 다른 경우
                // 가장 긴 변의 길이를 찾아야함
                if(a > b && a > c) {
                    if(a >= b + c) System.out.println("Invalid");
                    else System.out.println("Scalene");
                } else if(b > a &&  b > c) {
                    if(b >= a + c) System.out.println("Invalid");
                    else System.out.println("Scalene");
                } else {
                    if(c >= a + b) System.out.println("Invalid");
                    else System.out.println("Scalene");
                }
            }
        }
    }
}