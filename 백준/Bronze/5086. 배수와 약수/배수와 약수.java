import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		// 첫번째 숫자 : a 
		// 두번째 숫자 : b 
		// a < b -> b / a -> 16 % 8 == 0 -> 약수 
		// a > b -> a / b -> 32 % 4 == 0 -> 배수 
		// 0과 같지 않으면 둘다 아니다. 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String res = ""; 
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a > b) {
				res = a % b == 0 ? "multiple" : "neither"; 
				System.out.println(res);
			} else if (a < b){
				res = b % a == 0 ? "factor" : "neither";
				System.out.println(res);
			} else {
				break; 
			}
		}
		
	}
}
