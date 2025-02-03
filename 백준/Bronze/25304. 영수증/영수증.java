import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int n = sc.nextInt();
        int sum = 0;

        while(n > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sum += a*b;
            n--;
        }

        if(x == sum)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}