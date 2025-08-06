import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
//		1. (6,2) 에서 (0,0) 까지 거리 => (경계선까지만 간다고 했을 때, x는 -6, y는 -2)
//		2. (6,2) 에서 (10,3) 까지 거리  => (+4, +1) 
//		=> 최솟값 1
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(); 
		int y = sc.nextInt(); 
		int w = sc.nextInt(); 
		int h = sc.nextInt(); 
		
		int min = Integer.MAX_VALUE; 
		min = Math.min(x-0, min); 
		min = Math.min(y-0, min); 
		min = Math.min(w-x, min); 
		min = Math.min(h-y, min);
		
		System.out.println(min);
	}
}
