
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int students = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> line = new ArrayList<>();
        for(int i = 1; i <= students; i++) {
            int number = Integer.parseInt(st.nextToken());

            // 0 이면 제자리
            if(number == 0 || line.isEmpty()) line.add(i);
            else {
               line.add(line.size() - number, i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Integer num : line) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);

    }
}