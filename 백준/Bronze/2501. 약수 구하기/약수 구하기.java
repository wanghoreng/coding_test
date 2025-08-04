import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		List<Integer> numList = new ArrayList<>(); 
		
		for(int i = 1; i <= N; i++) {
			if(N % i == 0) {
				numList.add(i);
			}
		}
		
		if(numList.size() <= (K-1)) {
			System.out.println(0);
		} else {
			System.out.println(numList.get(K-1));
		}
	}
}
