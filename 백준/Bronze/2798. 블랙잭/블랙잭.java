import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 블랙잭 
public class Main {
	// 카드의 합이 21을 넘지않아야한다.
	// 각 카드는 양의 정수 
	// 1. N 장의 카드 중 숫자 M 을 외침 
	// 2. 플레이어는 제한된 시간 내 N 장의 카드 중 3장의 카드 뽑기 => player[3] 
	// 3. M <= player[0] + player[1] + player[2] 
	// - M을 넘지않으면서 최대한 M 과 가깝게 ! 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 카드 담기
		int[] cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			cards[n] = Integer.parseInt(st.nextToken());
		}
		
		// n 개의 카드 중 3장을 뽑아라
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < cards.length-2; i++) {
			for(int j = i+1; j < cards.length-1; j++) {
				for(int k = j+1; k < cards.length; k++) {
					int player = cards[i] + cards[j] + cards[k];
					if(player <= M) {
						max = Math.max(max, player);
					}
				}
			}
		}
		
		System.out.println(max);
	}

}
