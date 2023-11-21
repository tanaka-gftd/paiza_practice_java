/* 
    問題：
    n 人が横一列に並んでいます。左から i 番目の人を人 i と呼ぶことにします。人 i の身長は a_i [cm]です。
    人 l ,人 l+1, ... , 人 r からなる区間 [l, r] について、すべての l ≦ i < r に対して a_i ≦ a_{i+1} が成り立っているとき、
    区間 [l, r] は背の順であると呼ぶことにします。
    また、区間 [l, r] の長さを r-l+1 とします。
    背の順であるような区間のうち、最長であるものの長さを出力してください。
*/

/*
    ヒント：
    元の問題を解くために、部分問題としてどのような問題を考えればよいでしょうか。

    dp[n] を、人 n が右端となっているような背の順区間のうち、最長であるような区間の長さとしてみましょう。
    dp[1] ~ dp[k-1] が既に求まっているとして、dp[k] がどうなるかを考えてみましょう。
    dp[k-1] に注目すると、dp[k-1] は人 k-1 を右端とする背の順区間の長さですから、
    もし a_{k-1} ≦ a_k なら、その区間の右端に人 k をくっつけることで新しく長さ dp[k-1]+1 の背の順区間を作ることができ、
    この区間の長さは人 k を右端として持つ背の順区間のうち最長であることがわかります。
    逆に、もし a_{k-1} ＞ a_k なら、人 k が右端となるような背の順区間は人 k のみからなる長さ1の区間しか存在しないことがわかります。

    以上の考察により、dp[k-1] と dp[k] の関係が明らかになりました。自信のある人は自分で漸化式を立ててみましょう。
    以下の疑似コードに従って、自分の得意な言語で実装してみましょう。

    dp[1] <- 1

    for i = 2 to n
        if a[i-1] <= a[i] then
            dp[i] <- dp[i-1]+1
        else
            dp[i] <- 1

    print max({dp[1], ... ,dp[n]})
*/

/*
    解説：
    dp[k] を人 k が右端となっているような背の順区間のうち最長であるような区間の長さとすると、dp[1] ~ dp[k-1] と dp[k] の関係は
        •dp[k] = dp[k-1] + 1 (a_{k-1} ≦ a_k)
        •dp[k] = 1 (a_{k-1} > a_k)
    となります。
    この漸化式に従って、dp[1] から dp[n] まで順に計算すればよいです。
    
    答えは、dp[1] ~ dp[n] の最大値です。
*/

import java.util.*;
public class dp_primer_lis_continuous_step0 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        //入力された数値を保存する配列
        int[] array = new int[num];

        //array[i]を右端にした時に、連続で増加した区間の長さをdp[i]に保存していく配列
        int[] dp = new int[num];
        
        for(int i = 0; i<num; i++){
            array[i] = sc.nextInt();
        }
        
        //array[0]を右端にしたときは、連続で増加する区間の長さは1（一つだけなので）
        dp[0] = 1;
        
        for(int i = 1; i<num; i++){
            if(array[i - 1] <= array[i]){
                dp[i] = dp[i - 1] + 1;
            }else{
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
