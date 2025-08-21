import java.util.Scanner;

public class Main {
	/*
	MenOfPassion(A[], n) {
	    sum <- 0;
	    for i <- 1 to n - 1 		// n-1번 수행 
	        for j <- i + 1 to n 	// n-2/2번 수행
	            sum <- sum + A[i] × A[j]; # 코드1
	    return sum;
	}
	=>  
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		
//		int count = 0;
//		for(int i = 1; i <= n-1; i++) {
//			for(int j = i+1; j <= n; j++) {
//				count++;
//			}
//		}
		// 1~N까지의 합은 n(n+1)/2
		// N에 n-1 대입 = > (n-1)((n-1)+1)/2
		// 계산하면      = >   (n-1)n/2
		
//		System.out.println(count);
		
		
		
		System.out.println(n*(n-1)/2); // (n^2 - n) / 2 
		System.out.println(2);
	}
}
