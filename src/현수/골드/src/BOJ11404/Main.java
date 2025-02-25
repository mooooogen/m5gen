package BOJ11404;
import java.util.*;
//플로이드 : 그래프
//출력 : 전체 루트에 대한 이차원 출력
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//도시갯수
		int m= sc.nextInt();//노선갯수
		
		//출발도시번호 , 도착도시번호, 버스비 
		int[][] arr = new int[3][m];//3행 14열
		for(int i=0; i<m; i++) {
			for(int j=0; j<3; j++) arr[i][j] = sc.nextInt();
		}
		
		
		
		
		
	}

}
