import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws IOException {
        // 0 ~ 9까지의 숫자로 이루어진 N 개의 숫자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 1;
        int increseCnt = 1;
        int decreseCnt = 1;
        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i] <= arr[i+1]) {
                increseCnt++;
            } else {
                increseCnt = 1;
            }

            if(arr[i] >= arr[i+1]) {
                decreseCnt++;
            } else {
                decreseCnt = 1;
            }

            maxLength = Math.max(maxLength, Math.max(decreseCnt, increseCnt)); 
        }

        System.out.println(maxLength);
    }
}