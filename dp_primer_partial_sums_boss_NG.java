//問題URL：https://paiza.jp/works/mondai/dp_primer/dp_primer_partial_sums_boss

/* 自分で解いてみたコード。失敗 */

/*
  問題：
  1 ~ n の番号がついた n 種類のおもりがあり、おもり i の重さは a_i です。
  それぞれのおもりは無限個存在しており、任意のおもりを任意の個数使うことができます。

  このとき、おもりを選んで重さの和を x となるようにすることができるかどうか判定してください。
*/

import java.util.*;
public class dp_primer_partial_sums_boss_NG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        
        int[] weights = new int[n];
        
        boolean[] dp = new boolean[x+1];
        
        Arrays.fill(dp, false);
        
        dp[0] = true;
        
        for(int i = 0; i<n; i++){
            weights[i] = sc.nextInt();
        }
        
        for(int i = 0; i<n; i++){
            for(int j = x; j>=weights[i]; j--){

                if(dp[j-weights[i]]==true){
                    dp[j] = true;
                }
                
                int ref = j-weights[i];
                
                for(int k = 0; k<n; k++){
                  if(ref%weights[k] == 0){
                    dp[j] = true;
                  }
                }
            }
        }
        
        for(int i = 0; i<dp.length; i++){
            System.out.println("重さ" + i + "は" + dp[i]);
        }

        sc.close();
    }
}