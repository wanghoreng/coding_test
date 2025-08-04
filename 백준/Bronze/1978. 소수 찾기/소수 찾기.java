import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n  = Integer.parseInt(br.readLine());
		int count = 0; 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			List<Integer> list = new ArrayList<>(); 
			int num = Integer.parseInt(st.nextToken());
			
			for(int j = 1; j <= num; j++) {
				if(num % j == 0) list.add(i);   
			}
			
			if(list.size() == 2) {
				count++; 
			}
		}
		System.out.println(count);
	}
}
