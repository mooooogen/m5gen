package BOJ11404;
import java.util.*;
//플로이드 : 그래프 (시간초과)
//출력 : 전체 루트에 대한 이차원 출력
public class Main {
	
	static boolean[] visited;
	static int n,m;
	static int[][] fee;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();//도시갯수
		m= sc.nextInt();//노선갯수
		fee = new int[n][n];
		
		for(int i=0; i<m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int input = sc.nextInt();
			if(fee[start-1][end-1]==0 || (fee[start-1][end-1]>input)) fee[start-1][end-1] = input;
			else continue;
		}
		
		for(int s=0; s<n; s++) {
			for(int e=0; e<n; e++) {
				//임의의 s->e 로 가는 경로의 최소 비용 구하기
				visited = new boolean[n];
				int min = Integer.MAX_VALUE;
				visited[e] = true; //뒤에서부터 방문처리하고 시작.
				int sum =0;
				int ans = recurr(s,e, min,sum);
				System.out.print(ans + " ");
			}
			System.out.println();
		}
		
	}

	private static int recurr(int start, int end, int min, int sum) {
		
		//기저 조건
		if(start == end) {
			if(min == Integer.MAX_VALUE) return 0;
			else return min;
		}
		
		//도착점이 end인 모든 노선 조사
		for(int i=0; i<n; i++) {
			//방문 확인
			if(visited[i]) continue;
			
			//방문하지 않았다면
			if(fee[i][end] != 0) {//노선이 있다
				int tmp = sum + fee[i][end];
				if(tmp >= min) continue; //백 트래킹 : 도착 전에 최소값 초과
				
				//i->end 로 가는 노선의 가격을 더함
				if(i == start && (min>tmp)) {
					min = tmp; //도착 + 최소값 갱신
					min = recurr(start, i, min, tmp);
				}
				else {//도착까지 아직 멀었다면, i를 도착으로 하는거 노선 찾아오기
					visited[i] = true; // 환승역을 넣어두고 재귀
					int test = recurr(start, i, min, tmp);
					if(min>test)min=test;
					visited[i] = false;
				}
			}
		}
		return min;
	}

}
