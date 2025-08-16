import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        // 1. 테스트케이스
        // 2. "각T 20개정수"

        // 설계
        // 1. 처음 위치를 저장하는 배열 (공간 20 고정) -> 저장 순서는 들어온 순서대로 저장
        // 2. 마지막 위치를 저장하는 배열 (공간 20 고정)
        // 3. 처음 들어온 순서대로 정수 저장해두기
        // 4. 정수의 마지막 위치 indexOf 로 index를 찾은 뒤 해당 위치에 저장
        // 5. 마지막 위치 - 처음 위치 += 누적

        // 출력
        // "각T / 학생들이 뒤로 물러난 걸음 수 총합"
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            // 방법 2. 리팩토링
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tt = Integer.parseInt(st.nextToken());

            List<Integer> line = new ArrayList<>();
            int totalStep = 0;

            for(int i = 0; i < 20; i++) {
                int student = Integer.parseInt(st.nextToken());
                int insertIndex = -1;

                for(int j = 0; j < line.size(); j++) {
                    if(student < line.get(j)) {
                        insertIndex = j;
                        break;
                    }
                }

                // 줄이 비어있거나, 키가 가장 큰 경우
                if(insertIndex == -1) {
                    line.add(student);
                } else {
                    line.add(insertIndex, student);
                    totalStep += (line.size() - 1) - insertIndex;
                }
            }

            // 출력
            System.out.println(tt + " " + totalStep);

            // 방법 1. 비효율적
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int tt = Integer.parseInt(st.nextToken());
//            int[] number = new int[20];
//            int[] firstIndexArr = new int[20];
//            int[] lastIndexArr = new int[20];
//
//
//            // 20명 번호 담기
//            int index = 0;
//            while(st.hasMoreTokens()) {
//                number[index] = Integer.parseInt(st.nextToken());
//                index++;
//            }
//
//            // 오름차순으로 정렬한 번호를 담을 리스트
//            List<Integer> line = new ArrayList<>();
//
//            for(int i = 0; i < number.length; i++) {
//                boolean isOk = false;
//
//                // 줄을 서는 첫 학생이라면 바로 줄 세우기
//                if(line.isEmpty()) {
//                    line.add(number[i]);
//                    firstIndexArr[i] = i;
//                    continue;
//                }
//                // 이미 줄을 선 학생과 키 비교
//                for(int j = 0; j < line.size(); j++) {
//                    // 줄을 선 학생들은 이미 오름차순이므로
//                    // 바로 본인보다 키가 큰 학생이 나오면 해당 인덱스에 넣는다.
//                    if(number[i] < line.get(j)) {
//                        line.add(j, number[i]);
//                        firstIndexArr[i] = j; // 줄을 선 인덱스를 가지고 있는다.
//                        isOk = true;
//                        break;
//                    }
//                }
//
//                // 만약 줄을 선 학생들중 본인이 가장 크다면
//                // 맨 뒤에 선다.
//                if(!isOk) {
//                    line.add(number[i]);
//                    firstIndexArr[i] = i;
//                }
//            }
//
//            // 학생들의 마지막 위치를 line 에서 찾아서 넣는다.
//            for(int i = 0; i < number.length; i++) {
//                lastIndexArr[i] = line.indexOf(number[i]);
//            }
//
//            // 처음 위치와 마지막 위치를 비교해서 카운트한다.
//            int totalStep = 0, indexStep = 0;
//
//            while(indexStep < 20) {
//                totalStep += lastIndexArr[indexStep] - firstIndexArr[indexStep];
//                indexStep++;
//            }
//
//            // 출력
//            System.out.println(tt + " " + totalStep);
        }
    }
}