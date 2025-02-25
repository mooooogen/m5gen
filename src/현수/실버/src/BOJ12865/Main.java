package BOJ12865;
import java.util.Scanner;

//신발끈 공식 : 육각형은 확실하기에 6개의 꼭짓점 좌표를 연산
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt(); // 1m^2당 자라는 참외 개수
        int[] dir = new int[6]; // 방향
        int[] len = new int[6]; // 길이
        int[] xxx = new int[7]; // x 좌표 0~6까지지만 1부터 채움
        int[] yyy = new int[7]; // y 좌표

        int x = 0, y = 0; // 시작 좌표 (0,0)
        
        // (0,0) → (0,50) → (-160,50) → (-160,20) → (-100,20) → (-100,0) → (0,0)
        for (int i = 0; i < 6; i++) {
            dir[i] = sc.nextInt(); //방향 (동서남북)
            len[i] = sc.nextInt(); //거리

            // 동서남북 방향에 따라 좌표 이동
            if (dir[i] == 1) x += len[i]; // 동쪽
            else if (dir[i] == 2) x -= len[i]; // 서쪽
            else if (dir[i] == 3) y -= len[i]; // 남쪽
            else if (dir[i] == 4) y += len[i]; // 북쪽

            // 좌표 저장
            xxx[i + 1] = x;
            yyy[i + 1] = y;
        }

        // 신발끈 공식 적용 : area = 1/2 * | Σ(xi * yi+1 - xi+1 * yi) |
        int area = 0;
        for (int i = 0; i < 6; i++) {
            area += xxx[i] * yyy[i + 1] - xxx[i + 1] * yyy[i];
        }
        area = Math.abs(area) / 2; // 절댓값을 취하고 1/2 연산

        // 참외 개수 출력
        System.out.println(area * K);
    }
}

