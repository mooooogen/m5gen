import java.util.Scanner;

public class Boj_2851 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int[] mushroom = new int[11];
			
			for(int i = 1; i <= 10; i++) {
				mushroom[i] = sc.nextInt();
			}
			
			int max = 0;
			int front = 0;
			int back = 0;
			int answer = 0;
			
			for(int i = 1; i <= 10; i++) {
				max += mushroom[i];
				if(max >= 100) {
					front = max;
					back = max - mushroom[i];
					break;
				}
			}
			
			int option1 = Math.abs(100-front);
			int option2 = Math.abs(100-back);
			
			answer = front;
			//front는 무조건 back보다 큰 값이므로 절대값이 back이 더 적을때만 답으로 출력
			//나머지 모든 경우는 front가 정답의 조건에 부합함.
			if(option2 < option1) {
				answer = back;
			}else {
	            answer = max; // 모든 버섯을 더한 값이 100 미만일 경우
	        }
	
			System.out.println(answer);
			sc.close();
	}
	
	

}
