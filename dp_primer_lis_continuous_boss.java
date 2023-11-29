//問題URL：https://paiza.jp/works/mondai/dp_primer/dp_primer_lis_continuous_boss

/*
  問題：
  n 人が横一列に並んでいます。左から i 番目の人を人 i と呼ぶことにします。
  人 i の身長は a_i [cm]です。

  人 l ,人 l+1, ... , 人 r からなる区間 [l, r] について、すべての l ≦ i < r に対して a_i ≧ a_{i+1} が成り立っているとき、
  区間 [l, r] は逆背の順であると呼ぶことにします。
  また、区間 [l, r] の長さを r-l+1 とします。

  逆背の順であるような区間のうち、最長であるものの長さを出力してください。
*/

import java.util.*;
public class dp_primer_lis_continuous_boss {
    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        
        for(int i = 0; i<n; i++){
            array[i] = sc.nextInt();
        }
        
        int[] dp = new int[n];
        
        dp[0] = 1;
        
        for(int i = 1; i<n; i++){
            if(array[i]<=array[i-1]){
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        
        int result = 0;
        
        for(int v : dp){
            if(v>result){
                result = v;
            }
        }
        
        System.out.println(result);

        sc.close();
    }
}
