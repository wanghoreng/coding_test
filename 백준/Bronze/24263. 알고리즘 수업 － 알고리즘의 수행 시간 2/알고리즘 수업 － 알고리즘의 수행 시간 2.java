import java.util.Scanner;

public class Main {
	// MenOfPassion
	/*
	MenOfPassion(A[], n) {
	    sum <- 0;				// sum 을 0으로 초기화 해두고 
	    for i <- 1 to n 		// 1 ~ N 까지 반복 
	        sum <- sum + A[i]; # 코드1 // sum 에 누적
	    return sum; 	// 누적한 sum 을 반환 ! 
	}
	=> 빅오표기법(N) 을 표기하면 됨
	=> N 만큼 for 문을 실행하므로 !  
	 * */
	public static void main(String[] args) {
		// N 의 수행횟수 => N번 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		System.out.println(n);
		System.out.println(1); // 다항식 : N 으로 1차식 이어서 
	}

}
