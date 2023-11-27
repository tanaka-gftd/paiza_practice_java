/* 自分で解いてみたコード */
/* うまくいく場合もあれば、うまくいかない場合もある。原因不明。*/

/*
  問題：
  1 ~ n の番号がついた n 個のおもりがあり、おもり i の重さは a_i です。

  おもりを何個か選んで重さの和が x となるようにする方法を考えたとき、選ぶおもりの個数の最小値を出力してください。
  なお、同じおもりを2個以上選ぶことはできません。

  なお、重さの和が x となるようにおもりを選ぶ方法が存在しない場合は-1と出力してください。
*/

import java.util.*;

public class dp_primer_partial_sums_step2_NG {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        
        int[] weights = new int[n];
        
        int[] dp = new int[x+1];
        Arrays.fill(dp, 999);
        
        for(int i = 0; i<n; i++){
            weights[i] = sc.nextInt();
        }
        
        for(int i = 0; i<n; i++){

            int weight_i = weights[i];
            if(weight_i<=x){
                dp[weight_i] = 1;
            }
            
            for(int j = x; j>=weight_i; j--){
                
                if(dp[j - weight_i]!=999){
                    if(dp[j] > dp[j - weight_i] + 1){
                        dp[j] = dp[j - weight_i] + 1;
                    }
                }
            }
        }
        
        if(dp[x]==999){
            System.out.println(-1);
        }else{
            System.out.println(dp[x]);
        }

        sc.close();
    }
}



