import java.util.Arrays;
import java.util.Scanner;

public class N과M_5 {

		static int N,M;
		static int[] num;
		static int[] answer;
		static boolean[] visited;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[N];
		answer = new int[M];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		
		Dfs(0);
	}
	public static void Dfs(int depth) {
		if(depth == M) {
			for (int i = 0; i < M; i++) {
                System.out.print(answer[i] + " ");
            }
			 System.out.println();
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				answer[depth] = num[i];
				Dfs(depth+1);
				visited[i] = false;
			}
		}
	}

}
