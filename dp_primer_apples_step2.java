//問題URL：https://paiza.jp/works/mondai/dp_primer/dp_primer_apples_step2

/* 
  問題：
  八百屋にて、りんご x 個が a 円で、りんご y 個が b 円で売られています。

  りんごの買い方を工夫したとき、最終的に n 個のりんごを手に入れるために必要な金額の最小値はいくらでしょうか。
  なお、買い方を工夫した結果、買ったりんごが n+1 個以上になってもよいものとします。
*/

/*
  解説：
  まず、dp[n] をちょうど n 個のりんごを買うのに必要な金額の最小値とすると、
  dp[0] ~ dp[k-1] と dp[k] の関係は dp[k] = min(dp[k-x] + a, dp[k-y] + b) となります。
  まずはこの漸化式に従って dp を小さい方から順に計算しましょう。

  このままでは、x と y の組合せで作れない個数について、答えを正しく計算することができません。
  そこで、この dp を利用してちょうど n 個ではなく、n 個以上のりんごを買うのに必要な金額の最小値を求めることを考えます。

  dp2[n] を n 個以上のりんごを買うのに必要な金額の最小値とすると、定義から dp2[n] = min(dp[n], dp[n+1], ...) であることがわかります。
  dp2[n] が問題の答えです。

  ループの回し方を工夫して配列 dp をうまく書き換えると、わざわざ dp2 のような配列を新しく作らなくても答えを求めることができます。
  具体的には、dp2[n] = min(dp[n], dp[n+1], ...) = min(dp[n], dp2[n+1]) であることに注目し、
  dp を添字が大きい方から dp[k] = min(dp[k], dp[k+1]) のように書き換えていけば、
  dp[n] が n 個以上のりんごを買うのに必要な金額の最小値となります。

  このとき、dp[k]を書き換えた時点では、dp[i (< k) ] はちょうど i 個のりんごを買うのに必要な金額の最小値に、
  dp[i (≧ k) ] は i 個以上のりんごを買うのに必要な金額の最小値 (=dp2[i]) になっています。

  n 個のりんごを最も安く手に入れたいときに n+y 個以上のりんごを買うのは無駄ですから、dp は dp[n+y-1] 程度まで計算しておけば十分です。
*/

import java.util.*;
public class dp_primer_apples_step2 {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int a = sc.nextInt();
        int y = sc.nextInt();
        int b = sc.nextInt();
        
        int[] array = new int[n + y];
        Arrays.fill(array, 10000000);
        
        array[0] = 0;
        
        for(int i = 1; i < n + y; i++){
            if(i>=x){
                array[i] = Math.min(array[i], array[i - x] + a);
            }
            if(i>=y){
                array[i] = Math.min(array[i], array[i - y] + b);
            }
        }
        
        for(int i = n + y - 2; i >= 1; i--){
            array[i] = Math.min(array[i], array[i+1]);
        }
        
        System.out.println(array[n]);

        sc.close();
    }
}
