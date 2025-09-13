import java.util.Scanner;

public class Main {	
	/*
	 MenOfPassion(A[], n) {
	    sum <- 0;
	    for i <- 1 to n 				// n 
	        for j <- 1 to n				// n 
	            for k <- 1 to n			// n 
	                sum <- sum + A[i] × A[j] × A[k]; # 코드1
	    return sum;
	}
	=> n * n * n
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt(); 
		System.out.println(n * n * n);
		System.out.println(3);
	}

}
