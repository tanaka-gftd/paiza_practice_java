//問題URL：https://paiza.jp/works/mondai/dp_primer/dp_primer_partial_sums_step2

/* 
  問題：
  1 ~ n の番号がついた n 個のおもりがあり、おもり i の重さは a_i です。

  おもりを何個か選んで重さの和が x となるようにする方法を考えたとき、選ぶおもりの個数の最小値を出力してください。なお、同じおもりを2個以上選ぶことはできません。

  なお、重さの和が x となるようにおもりを選ぶ方法が存在しない場合は-1と出力してください。
*/

/*
  解説：
  おもり k までを用いて重さの和が x となるようにおもりを選ぶときの個数の最小値が求まっていれば、
  おもり k+1 までを用いて重さの和が x となるようにおもりを選ぶときの個数の最小値を求めることができますから、
  これをおもり 1 から始めておもり n まで繰り返せばよいです。

  dp_k[x] をおもり k までを用いて重さの和が x となるようにおもりを選ぶときの個数の最小値 (ただし、そのようにおもりを選ぶ方法が存在しない場合は ∞ ) とすると、
  dp_{k-1}[0] ~ dp_{k-1}[x] と dp_k[x] の関係は dp_k[x] = min(dp_{k-1}[x], dp_{k-1}[x-a_k] + 1) となります。

  dp_1 から dp_k に対応する k 本の1次元配列 (もしくはこれに相当する2次元配列) を用いて問題を解くこともできますが、
  dp_k[x] の計算には dp_{k-1}[0] ~ dp_{k-1}[y (≦ x) ] さえわかっていれば十分であることに気付くと、
  ループの回し方を工夫することで1つの1次元配列 dp だけで問題を解くことができます。
*/

/* 
  解説で ∞ としていたところを、コード中では n+1 としています。
  おもりの個数は n なので、おもりを n+1 個選ぶような状況は起こりえないからです。
  Array クラスの fill メソッドを用いて、dp[k] の初期値を n+1 にしています
*/

import java.util.Arrays;
import java.util.Scanner;

public class dp_primer_partial_sums_step2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x = sc.nextInt();

    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    int[] dp = new int[x + 1];
    Arrays.fill(dp, n + 1);
    dp[0] = 0;

    for (int i = 0; i < n; i++) {
      for (int j = x; j >= a[i]; j--) {
        if (dp[j - a[i]] == n + 1) continue;
        dp[j] = Math.min(dp[j], dp[j - a[i]] + 1);
      }
    }

    if (dp[x] == n + 1) {
      System.out.println(-1);
    } else {
      System.out.println(dp[x]);
    }
    
    sc.close();
  }
}


