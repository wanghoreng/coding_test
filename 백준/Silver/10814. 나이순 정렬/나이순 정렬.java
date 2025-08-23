import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 나이순 정렬
public class Main {
    // 1. 회원의 수 N
    // 2. 각 회원의 나이, 이름
    // 나이 (1 <= age <= 200)
    // 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열
    // 나이가 증가하는 순으로 오름차순
    // 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] members = new String[N][2]; // [0] : 나이, [1] 이름
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members[i][0] = st.nextToken();
            members[i][1] = st.nextToken();
        }

        Arrays.sort(members, new Comparator<String[]>(){
            @Override
            public int compare(String[] s1, String[] s2) {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(members[i][0]).append(" ").append(members[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}