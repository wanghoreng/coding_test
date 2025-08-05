import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n = Integer.parseInt(br.readLine());
		
		// i 가 2 부터 시작하는 이유는 1은 소수가 아니기 때문이다. 
		// i*i 까지 하는 이유는 어떤 수 n 이 있을 때, 그 수의 소인수가 존재하면 
		// 그 중 하나는 반드시 √N 이하이기 때문이다. 
		for(int i = 2; i * i <= n; i++) {
			while(n % i == 0) {
				System.out.println(i);
				n /= i; 
			}
		}
		
		// 루프를 돌고도 n 이 1보다 클 경우 n 자체가 소수이다. 
		if(n > 1) {
			System.out.println(n);
		}
		
	}
}
