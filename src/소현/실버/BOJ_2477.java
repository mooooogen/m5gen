package 소현.실버;

import java.util.Scanner;

public class BOJ_2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[] list = new int[6];
		int max = 0;
		long total = 0;
		for (int i = 0; i < 6; i++) {
			sc.nextInt();
			list[i] = sc.nextInt();
			if ((i + 1) % 2 == 1 && list[i] > max) {
				max = list[i];
			}

		}
		if (list[0] < max) {
			if (list[2] < list[4]) {
				total += list[5] * list[0];
				total += list[2] * list[3];
			} else {
				total += list[0] * list[1];
				total += list[3] * list[4];
			}
		} else {
			total += list[1] * list[2];
			total += list[5] * list[4];
		}

		System.out.println(total * cnt);
	}

}
