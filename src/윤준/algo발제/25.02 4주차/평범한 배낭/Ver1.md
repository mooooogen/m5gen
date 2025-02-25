#  평범한 배낭
```

import java.util.*;

  

public class BOJ_12865_Bag_HS {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

int n = sc.nextInt(); // 물건 개수

int k = sc.nextInt(); // 배낭 최대 무게

int[][] arr = new int[n+1][2]; // 물건 정보 저장

int[][] dp = new int[n+1][k+1]; // DP 테이블 (물건 개수 x 배낭 최대 무게)

  

// 입력 받기

for (int i = 1; i <= n; i++) {

arr[i][0] = sc.nextInt(); // 무게

arr[i][1] = sc.nextInt(); // 가치

}

  

// DP 테이블 채우기

for (int thing = 1; thing <= n; thing++) { // 물건 1개부터 n개까지 고려

for (int w = 0; w <= k; w++) { // 배낭 무게 0~K까지 고려

if (arr[thing][0] <= w) { 

dp[thing][w] = Math.max(dp[thing-1][w], dp[thing-1][w - arr[thing][0]] + arr[thing][1]);

} else {

dp[thing][w] = dp[thing-1][w];

}

}

}

  

// 결과 출력

System.out.println(dp[n][k]);

}

}


```

## DP 해설 

1~4까지 돌면서 업데이트가 되고 4까지 돌았을 때 최종 업데이트

  

thing2인 경우는 1번 물건과 2번물건을 비교해서 넣었을 때 최대 가치

  

thing3이되면 1,2를 비교한 것과 3을 비교하는 것이라서 1,2,3중에 최대값을 구하는 것임.

  

dp[3][3] = Math.max(dp[2][3],dp[2][0]+6);

  

이전 dp를 돌면서 업데이트했던 배낭에 들어갈 수 있는 최대 가치와 비교

  

2번물건까지 비교했을 때 가방 무게가 3일때 들어갈 수 있던 최대값과 3번 물건을 포함해서 가방 무게가 3일때 들어갈 수 있는 최대값

  

Math.max(dp[2][3],dp[2][0]+6); -> dp[thing-1][w] = 배낭 무게 w라고 가정했을 때 물건 3의 무게를 뺀 나머지 무게에서 넣을 수 있는 최대 가치의 값

  

dp[3][4] = Math.max(dp[2][4],dp[2][1]+6); 이전에 무게가 4일때 넣을 수 있던 최대 가치와 무게 3인 물건의 가치 + 여분 1의 배낭에 들어갈 수 있는 최대가치의 합을 비교

## **시간 복잡도 분석**

시간 복잡도는 **O(N × K)**

### **이유 분석**

-   **2중 반복문을 사용**
    
````
    
    `for (int thing = 1; thing <= n; thing++) { // O(N)
        for (int w = 0; w <= k; w++) { // O(K)` 
 ````
 
 
   -   `thing`은 `1`부터 `n`까지 `O(N)` 반복
   -   `w`는 `0`부터 `k`까지 `O(K)` 반복
   -   따라서, 총 반복 횟수는 **O(N × K)**


## 🔹 정리

| **설계 요소** | **설명** |
|--------------|-----------------------------------------------|
| **DP 테이블 정의** | `dp[i][w] = i번째 물건까지 고려했을 때, 배낭 무게 w에서 얻을 수 있는 최대 가치` |
| **점화식** | `dp[thing][w] = max(dp[thing-1][w], dp[thing-1][w - arr[thing][0]] + arr[thing][1])` |
| **시간 복잡도** | `O(N × K)` |
| **공간 복잡도** | `O(N × K)` (2차원 배열 사용) |
| **최적화 가능 여부** | 1차원 DP 배열 (`O(K)`)을 사용하여 공간 최적화 가능 |