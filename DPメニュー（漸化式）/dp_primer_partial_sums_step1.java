//問題URL：https://paiza.jp/works/mondai/dp_primer/dp_primer_partial_sums_step1

/*
    問題：
    1 ~ n の番号がついた n 個のおもりがあり、おもり i の重さは a_i です。

    おもりを何個か選んで重さの和が x となるようにする方法が何通りあるか求めてください。
    なお、同じおもりを2個以上選ぶことはできません。

    重さが同じおもりが複数存在する場合、それらは区別して別のものとして扱うことにします。

    答えは非常に大きくなる可能性があるので、答えを 1,000,000,007 で割った余りで出力してください。
*/

/*
    解説：
    おもり k までを用いて重さの和が x となるようにおもりを選ぶ方法の通り数が求まっていれば、
    おもり k+1 までを用いて重さの和が x となるようにおもりを選ぶ方法の通り数を求めることができますから、
    これをおもり 1 から始めておもり n まで繰り返せばよいです。

    dp_k[x] を、おもり k までを用いて重さの和が x となるようにおもりを選ぶ方法の通り数とすると、
    漸化式は dp_k[x] = dp_{k-1}[x-a_k] + dp_{k-1}[x] となります。

    おもり k までを用いて重さの和が x となるようにおもりを選ぶ方法の通り数
                            ||
    おもり k-1 までを用いて重さの和が x-おもりkの重さ となるようにおもりを選ぶ方法の通り数
                            ＋
    おもり k-1 までを用いて重さの和が x となるようにおもりを選ぶ方法の通り数
    
    dp_1 から dp_k に対応する k 本の1次元配列 (もしくはこれに相当する2次元配列) を用いて問題を解くこともできますが、
    dp_{k-1}[0] ~ dp_{k-1}[y (≦ x) ] がわかっていれば dp_k[x] が計算できることに気付くと、
    ループの回し方を工夫することで1つの1次元配列 dp だけで問題を解くことができます。
*/

import java.util.*;
public class dp_primer_partial_sums_step1 {

    static final int mod = 1000000007;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        
        int mod = 1000000007;
        
        int[] weightArray = new int[n];
        
        for(int i = 0; i<n; i++){
            weightArray[i] = sc.nextInt();
        }
        
        int[] dp = new int[x+1];
        dp[0] = 1;

        for(int i = 0; i<n; i++){
            for(int j = x; j >= weightArray[i]; j--){
                dp[j] += dp[j - weightArray[i]];
                dp[j] %= mod;
            }
        }
        
        System.out.println(dp[x]);

        sc.close();
    }
}
