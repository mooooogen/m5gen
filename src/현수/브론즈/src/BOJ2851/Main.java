package BOJ2851;
import java.util.*;
//슈퍼 마리오 : 메모리(17672), 시간(172)
//100을 넘어선 순간에 그때의 인덱스와 그 직전의 인덱스까지의 합 비교
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum=0;
		for(int i=0; i<10; i++) {
			int num =sc.nextInt();
			int postsum = sum + num;
			
			if(postsum>=100) {
				if(Math.abs(postsum-100) > Math.abs(sum-100)) System.out.println(sum);
				else System.out.println(postsum);
				break;
			}
			else sum=postsum;
			
			if(i==9) System.out.println(postsum);
		}
		sc.close();
	}
}
