
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        // 1. 블록의 가로, 세로 길이
        // 2. 상점의 개수
        // - 가로, 세로, 상점 개수 모두 100 이하의 자연수
        // 3-1 상점이 위치한방향(1 북, 2 남, 3 서, 4 동)
        // 3-2 (북,남인 경우 왼쪽에서부터의/ 동,서 인 경우 위쪽에서부터의) 거리
        // 마지막 줄 동근이의 위치

        //조건!
        // 상점의 위치나 동근이의 위치는 블록의 꼭짓점이 될 수 없다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int storeCount = Integer.parseInt(br.readLine());

        List<Integer> storePositions = new ArrayList<>();
        int perimeter = 2 * (X + Y); // 직사각형 둘레를 직선으로 표현

        // 모든 상점 1차원 좌표로 변환
        for(int i = 0; i < storeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            storePositions.add(convertTo1D(direction, distance, X, Y));
        }

        // 경비원의 위치를 1차원 좌표로 변환
        st = new StringTokenizer(br.readLine());
        int myDirection = Integer.parseInt(st.nextToken());
        int myDistance = Integer.parseInt(st.nextToken());
        int myPosition = convertTo1D(myDirection, myDistance, X, Y);

        int totalDistance  = 0;
        for(int storePosition : storePositions) {
            int dist1 = Math.abs(myPosition - storePosition);
            int dist2 = perimeter - dist1;
            totalDistance  += Math.min(dist1, dist2);
        }

        System.out.println(totalDistance);

    }

    private static int convertTo1D(int direction, int distance, int X, int Y) {
        if(direction == 1) return distance; // 북
        else if(direction == 2) return X + Y + (X - distance);//남 (왼쪽에서부터 거리 계산)
        else if(direction == 3) return X + Y + X + (Y - distance); // 서 (위에서부터 거리계산)
        else return X + distance; // 동 (위에서부터 거리계산)
    }
}