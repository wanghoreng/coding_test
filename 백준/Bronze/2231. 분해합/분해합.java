
import java.util.Scanner;

// 분해합
public class Main {
	// 자연수 N 의 분해합은 N 과 N 을 이루는 각 자리수의 합 
	// M 의 분해합이 N 인 경우, M 을 N 의 생성자 라고 한다.
	// 생성자가 없을수도 있음 
	// N 의 가장 작은 생성자를 구해내는 프로그램 => 없는 경우 0 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 216 의 분해합 구하는 방법 => 216 + 2 + 1 + 6  => 225 
		// xyz + x + y + z = 216 인 경우 xyz 가 216의 생성자 
		// 
		// 1 ~ N 까지 확인
		int result = 0;
		for(int i = 1; i <= N; i++) { // 216
			int sum = 0;
			int number = i; 
			while(number != 0) { //
				sum += number % 10; 
				number /= 10; 
			}
			
			if(sum + i == N) {
				result = i;
				break;
			} 
		}
		System.out.println(result);
	}

}
