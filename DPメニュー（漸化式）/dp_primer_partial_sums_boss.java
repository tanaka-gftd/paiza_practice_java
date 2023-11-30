//問題URL：https://paiza.jp/works/mondai/dp_primer/dp_primer_partial_sums_boss

/*
  問題：
  1 ~ n の番号がついた n 種類のおもりがあり、おもり i の重さは a_i です。
  それぞれのおもりは無限個存在しており、任意のおもりを任意の個数使うことができます。

  このとき、おもりを選んで重さの和を x となるようにすることができるかどうか判定してください。
*/

/*
  解説：
  おもり k までを用いて重さの和が x となるようにおもりを選ぶことができるかどうかがわかっていれば、
  おもり k+1 までを用いて重さの和が x となるようにおもりを選ぶことができるかどうかがわかりますから、おもり 1 から始めて順におもり n まで計算していけばよいです。

  dp_k[x] を、おもり k までを用いて重さの和が x となるようにおもりを選ぶことができるかどうかを表す真偽値とすると、
  dp_{k-1}[0] ~ dp_{k-1}[x], dp_k[0] ~ dp_k[y (< x)] と dp_k[x] の関係は 
  dp_k[x] = dp_{k-1}[x] or dp_{k-1}[x-a_k] or dp_k[x-a_k] となります。

  dp_1 から dp_k に対応する k 本の1次元配列 (もしくはこれに相当する2次元配列) を用意し、上の漸化式に従って問題を解いても良いのですが、
  部分和問題 1 で考察したようにループの回し方を工夫すると1本の1次元配列でこの問題を解くことができます。
*/

import java.util.Arrays;
import java.util.Scanner;

public class dp_primer_partial_sums_boss {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x = sc.nextInt();

    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    boolean[] dp = new boolean[x + 1];

    Arrays.fill(dp, false);
    dp[0] = true;

    for (int i = 0; i < n; i++) {
      for (int j = a[i]; j <= x; j++) {
        if (dp[j - a[i]]) {
          dp[j] = true;
        }
      }
    }

    if (dp[x]) {
      System.out.println("yes");
    } else {
      System.out.println("no");
    }

    sc.close();
  }
}
