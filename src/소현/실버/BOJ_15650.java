package 소현.실버;

import java.util.Scanner;
import java.util.Stack;

// N과 M(2)
public class BOJ_15650 {
	
	static int n, m;
	static Stack<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 1~n가지 수 중 선택
		m = sc.nextInt(); // m개 선택 
		list = new Stack<>();
		
		for (int i=1; i<=n; i++) {
			list.push(i);
			choose(i);
			list.pop();
		}
	}
	private static void choose(int num) {
		if(list.size()==m) {
			for(int n:list) {
				System.out.print(n+" ");
			}
			System.out.println();
			return;
		}
		if(m-list.size()>(n-num)) {
			return;
			}
		
		
		for(int l=num+1; l<=n; l++) {
			list.push(l);
			choose(l);
			list.pop();
			
		}
		
	}

}
