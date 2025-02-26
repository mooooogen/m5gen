import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Boj_11404 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> bus = new ArrayList<>(); 
		
		int N = sc.nextInt();
		int M = sc.nextInt();

		sc.nextLine();
		
		int[][] map = new int[N][N];
		String[] info = new String[M];
		
		for(int i = 0; i < M; i++) {
			info[i] = sc.nextLine();
			bus.add(info[i]);
		}
		System.out.println(Arrays.toString(info));
	}

}
