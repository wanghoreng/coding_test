import java.util.Scanner;

public class Main {
	/*
	MenOfPassion(A[], n) {
	    sum <- 0;
	    for i <- 1 to n - 2
	        for j <- i + 1 to n - 1
	            for k <- j + 1 to n
	                sum <- sum + A[i] × A[j] × A[k]; # 코드1
	    return sum;
	}
	=> 1 ~ 100 까지의 합 : n * (n + 1) / 2
	=> (n-2)*((n-2)+1)/2
	=> (n-2)*(n-1) => n
	 *  */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextInt();
		
//		int count = 0;
//		for(int i = 1; i <= n-2; i++) {
//			for(int j = i+1; j <= n-1; j++) {
//				for(int k = j+1; k <= n; k++) { 
//					count++; 
//				}
//			}
//		}
		
//		System.out.println(count);
		
		
		// 7*6*5 = 210 / 6 = 35 
		// 왜 6으로 나누는가 ?
		// 1부터 N 까지의 수에서 3개의 수를 선택하는 경우의 수를 생각하면 
		// 3 X 2 X 1 = 6 
		System.out.println((n-1)*(n-2)*(n)/6);
		System.out.println(3);
	}

}
