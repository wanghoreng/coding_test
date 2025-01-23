import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a,b,c;

        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();
        
        // Math.abs 는 인자값에 대한 절대값을 반환하는 함수이다. 
        System.out.println(Math.abs(a)+Math.abs(b)+Math.abs(c));

    }
}
