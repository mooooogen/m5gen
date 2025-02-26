package BOJ15654;
import java.util.*;
//N과 M (5) : 메모리(81736), 시간(2136) 
//set을 이용한 중복 제한

public class Main {
	static int[] arr, part;
	static int n,m;
	static boolean[] visited;
	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		part = new int[m];
		visited = new boolean[n];
		
		for(int i=0; i<n; i++)arr[i]=sc.nextInt();
		Arrays.sort(arr);
		set = new LinkedHashSet<>();
		dfs(0);
		
	}

	private static void dfs(int depth) {
		
		if(depth >= m) {
			for(int i=0; i<m; i++) {
				System.out.print(part[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i])continue;
			
			part[depth] = arr[i];
			visited[i] = true;
			dfs(depth+1);
			visited[i] = false;
		}
		
	}

}
