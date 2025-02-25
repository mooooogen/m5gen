package BOJ15663;
import java.util.*;
//N과 M (9) : 메모리(69580), 시간(1272)
//dfs 반복별 before 변수를 통한 중복 처리
public class Solution1 {
	
	static boolean[] visited;
	static Stack<Integer> stack = new Stack<>();
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		visited = new boolean[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			}
		
		Arrays.sort(arr);
		dfs(0,m,arr);
	}

	private static void dfs(int i, int m, int[] arr) {
		
		if(i>=m) {
			for(int j=0; j<m; j++) {
				System.out.print(stack.get(j)+" ");
			}
			System.out.println();
			return;
		}
		
		int before = 0;
		for(int k=0; k<n; k++) {
			if(visited[k] == true) continue;
			
			if(before != arr[k]) {
				stack.add(arr[k]);
				before = arr[k];
				visited[k] = true;
				dfs(i+1,m,arr);
				visited[k] = false;		
				stack.pop(); //요소를 지우는 건 dfs 재귀를 빠져 나온 후에 하는게 좋다.
			}
		}
				
	}

}
