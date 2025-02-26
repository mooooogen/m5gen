## 	So현

```


import java.util.Arrays;
import java.util.Scanner;

// N과 M (9) : 중복되는 수열 출력 x 
public class BOJ_NnM_9_So {
	static int cnt, resCnt;
	static int[] list, ans;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cnt = sc.nextInt();
		resCnt = sc.nextInt();
		list = new int[cnt];
		ans = new int[resCnt];
		check = new boolean[cnt];
		for (int i = 0; i < cnt; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list);
		for (int i = 0; i < cnt; i++) {
			if (i > 0 && list[i] == list[i - 1]) {
				continue;
			}
			check[i] = true;
			ans[0] = list[i];
			getAns(1);
			check[i] = false;
		}

	}

	private static void getAns(int idx) {
		if (idx == resCnt) {
			for (int num : ans) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < cnt; i++) {
			if (i > 0 && list[i] == list[i - 1] && !check[i - 1]) {
				continue;
			}
			if (!check[i]) {
				check[i] = true;
				ans[idx] = list[i];
				getAns(idx + 1);
				check[i] = false;

			}
		}

	}
}
```



## 🔹 두 코드 비교 정리

| **비교 항목** | **NnM_09_visited (before 변수 사용)** | **BOJ_NnM_9_So (i > 0 && list[i] == list[i - 1] 사용)** |
|-------------|--------------------------------|--------------------------------|
| **중복 제거 방식** | DFS 내부에서 `before` 변수를 활용하여 같은 깊이에서 중복 방지 | DFS 호출 전에 `i > 0 && list[i] == list[i - 1]` 조건을 사용하여 탐색 자체를 줄임 |
| **DFS 호출 구조** | DFS 내부에서 `before` 변수를 업데이트하면서 중복 방지 | DFS 호출 전에 `continue;`를 사용하여 불필요한 호출 제거 |
| **불필요한 DFS 호출** | DFS 호출 후에 중복을 제거하므로 일부 불필요한 호출 가능 | DFS 호출 전에 중복을 검사하여 불필요한 호출 자체를 방지 |
| **출력 순서 유지 여부** | 유지됨 | 유지됨 |
| **시간 복잡도** | `O(N!)` (불필요한 DFS 호출이 있을 수 있음) | `O(N!)` (불필요한 DFS 호출이 줄어듦) |
| **코드 직관성** | DFS 내부에서 중복 체크를 진행하여 비교적 이해하기 쉬움 | DFS 호출 전에 미리 중복을 제거하여 효율적이지만 이해가 어려울 수 있음 |

✅ **추천 코드 선택**
- **탐색 속도를 빠르게 하고 싶다면?** `BOJ_NnM_9_So` (`continue;` 사용)
- **코드를 좀 더 직관적으로 이해하고 싶다면?** `NnM_09_visited` (`before 변수 사용`)

**최종적으로, `BOJ_NnM_9_So` 방식이 불필요한 DFS 호출을 줄이기 때문에 더 효율적.**  
**코드를 더 쉽게 이해하려면 `NnM_09_visited` 방식도 충분히 좋은 선택**
