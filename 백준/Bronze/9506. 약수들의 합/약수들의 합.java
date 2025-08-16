import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// n 이 자신을 제외한 모든 약수들의 합과 같으면 그 수를 완전수 라고 함 
		// n이 완전수인지 체크 
		Scanner sc = new Scanner(System.in);
		
		
		
		while (true) {
			int n = sc.nextInt();
			
			if(n == -1) break;  
			int sum = 0; 
			StringBuilder sb = new StringBuilder(); 
			sb.append(n); 
			for(int i = 1; i < n; i++) {
				if(n % i == 0) {
					if(sum == 0) sb.append(" = "); 
					else sb.append(" + "); 
					sum += i;
					sb.append(i); 
				}  
			}
			
			if(sum != n) {
				System.out.println(n + " is NOT perfect.");
			} else {
				System.out.println(sb);
			}
			
		}
		
	}
}
