/*
  問題：
  n 本の木が横一列に並んでいます。
  左から i 番目の木を木 i と呼ぶことにします。木 i の高さは a_i [cm] です。

  あなたは、何本かの木を伐採することによって、残った木を左から順に見ると高さが単調減少になっているようにしたいと考えています。
  つまり、残った木を左から 木 k_1, 木 k_2, ... , 木 k_m とすると、a_{k_1} > a_{k_2} > ... > a_{k_m} が満たされているようにしたいです。なるべく多くの木が残るように工夫して伐採する木を選んだとき、伐採されずに残る木の本数が最大でいくつになるか求めてください。

  なお、最初から n 本の木が単調減少に並んでいる場合は、1本も伐採しなくてよいものとします。
*/

import java.util.*;

public class dp_primer_lis_boss {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] array = new int[n + 1];
    for (int i = 1; i <= n; i++){
        array[i] = sc.nextInt();
    }

    int[] dp = new int[n + 1];

    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = 1;  // 木 i のみからなる部分列の長さ
        for (int j = 1; j < i; j++) {
            if (array[j] > array[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);  // 最後が木 j であるような増加部分列の末尾に木 i をくっつける
            }
        }
    }

    int result = 1;

    for (int v : dp) {
        result = Math.max(result, v);
    }

    System.out.println(result);

    sc.close();
    }
}
