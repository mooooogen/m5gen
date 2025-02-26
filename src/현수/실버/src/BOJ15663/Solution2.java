package BOJ15663;
import java.util.*;
//N과 M (9): 메모리(45404), 시간(572)
//string로 전체 부분조합을 set으로 저장함
//이때 set은 중복을 허용하지 않음
//부분 조합 배열을 따로 만듦.
public class Solution2 {
	static int[] arr, part;
	static boolean[] visited;
	static int n,m;
	static Set<String> set; //부분조합을 문자열로 저장
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		arr = new int[n];
		part = new int[m];
		visited = new boolean[n];
		for(int i=0; i<n; i++)arr[i]=sc.nextInt();
		Arrays.sort(arr);
		
		set = new LinkedHashSet<>();
		dfs(0);
		
		for (String string : set) System.out.println(string);
//		set.forEach(System.out::println);
	}

	private static void dfs(int depth) {
		
		//기저조건 : 원하는 길이를 완성하면 전체 리스트르 문자열에 저장
		if(depth >= m) {
			String temp="";
			for(int num : part) temp += num+" ";
			set.add(temp);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i])continue;
			part[depth] = arr[i];
			visited[i]=true;
			dfs(depth+1);
			visited[i] = false;
		}
		
		
	}
	

}

