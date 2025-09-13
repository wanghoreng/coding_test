
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        // 1. "학생수N 최대인원수K"
        // 2. "성별S(0-여,1-남) 학년Y"

        // arr[6][2] -> 열 : 학년, 행 : [0] - 여, [1] - 남
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] gradeRoom = new int[6][2];
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken()) - 1;

            gradeRoom[grade][gender]++;
        }
        // 학년별, 성별 따로따로
        int minRoom = 0;
        for(int i = 0; i < 6; i++) {

            // 여자방 일 때!
            int girlRoom = getMinRoom(gradeRoom[i][0], K);
            // 남자방 일 때!
            int boyRoom = getMinRoom(gradeRoom[i][1], K);

            minRoom += (girlRoom+boyRoom);
        }

        // 한 방에 배정할 수 있는 최대 인원 수 K
        // 출력 조건에 맞게 모든 학생을 배정하기 위해 필요한 방의 최소 개수 구하기!
        System.out.println(minRoom);
    }

    private static int getMinRoom(int studentCnt, int K) {

        // 경우 의 수 : 0명일 때, 최대 인원수를 넘지않을 때, 최대 인원수를 넘어설 때 !
        int minRoom = 0;

        if(studentCnt == 0) return minRoom;

        int remainCnt = studentCnt % K;
        int room = studentCnt / K;

        // 최대 인원수에 맞게 방이 딱 떨어지는 경우
        if(remainCnt == 0) minRoom += room;
        else {
            // 최대인원수에 맞지 않게 인원이 남는 경우
            minRoom += (room+1);
        }

        return minRoom;
    }
}