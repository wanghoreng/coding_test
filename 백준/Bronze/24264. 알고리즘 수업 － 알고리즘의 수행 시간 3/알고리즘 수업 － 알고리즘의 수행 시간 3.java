import java.util.Scanner;

public class Main {
	
	/*
	MenOfPassion(A[], n) {
	    sum <- 0;
	    for i <- 1 to n => N번 수행 
	        for j <- 1 to n   => N번수행 
	            sum <- sum + A[i] × A[j]; # 코드1
	    return sum;
	}
	=> 빅오표기법 (N^2)
	=> 2차 다항식 
	 * */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		System.out.println(N * N);
		System.out.println(2);
	}

}
