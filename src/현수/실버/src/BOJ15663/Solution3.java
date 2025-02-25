package BOJ15663;
import java.util.*;
//N과 M (9) : 메모리(51952), 시간(1160) / 그나마 빠르긴한데,,
// 스택을 쓰는 것보다 차라리 배열을 하나 만드는게 낫다.
//stack을 사용하지 않는 1번의 방법(before를 이용한 중복제거)
public class Solution3 {
	
	static int n,m;
	static int[] arr,part;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		arr=new int[n];
		part=new int[m];
		visited=new boolean[n];
		for(int i=0; i<n; i++) arr[i]=sc.nextInt();
		
		Arrays.sort(arr);
		dfs(0);
		
	}

	private static void dfs(int depth) {
		if(depth >= m) {
			for(int num:part)System.out.print(num + " ");
			System.out.println();
			return;
		}
		
		int before=0;
		for(int i=0; i<n; i++) {
			if(visited[i])continue;
			
			if(before != arr[i]) {
				part[depth] = arr[i];
				before=arr[i];
				visited[i]=true;
				dfs(depth+1);
				visited[i]=false;
			}
			
		}
		
	}

}
