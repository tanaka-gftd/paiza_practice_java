//問題URL：https://paiza.jp/works/mondai/dp_primer/dp_primer_apples_step0

/*
  問題：
  八百屋にて、りんご1個が a 円で、りんご2個が b 円で売られています。

  りんごの買い方を工夫したとき、n 個のりんごを手に入れるために必要な金額の最小値はいくらでしょうか。
  なお、買い方を工夫した結果、買ったりんごが n+1 個以上になってもよいものとします。
*/

/*
  ヒント：
  りんご1つあたりの値段を計算し、安いほうのりんごを買うことで金額の最小値を達成することもできますが、練習だと思ってDPで解いてみましょう。

  部分問題として、りんご i 個 (1 ≦ i ≦ n-1) を買うのに必要な金額の最小値を求める問題を考えてみましょう。
  これらの問題の答えがすべて分かっているとして、n 個のりんごを買うのに必要な金額の最小値はどうなるかを考えてみましょう。

  少し考えると、n 個のりんごを最も安く買う方法は、
    •n-1 個のりんごを最も安く買ってから最後に1個のりんごを a 円で買う
    •n-2 個のりんごを最も安く買ってから最後に2個のりんごを b 円で買う
  の2通りのうち安いほうであることがわかります。

  なお、a < b という制約があるため、n-1 個のりんごを最も安く買ってから最後に1個買う代わりに2個買うのは常に無駄であることに注意しましょう。
  これで、部分問題と元の問題との関係が明らかになりました。
  dp[n] をちょうど n 個のりんごを買うのに必要な金額の最小値として、漸化式を立ててみましょう。

  漸化式を自力で立てられましたか？
  漸化式は dp[n] = min(dp[n-1] + a, dp[n-2] + b) となります。

  以下の疑似コードに従って、あなたの得意な言語で実装してみましょう。
    dp[0] <- 0
    dp[1] <- a

    for i = 2 to n
        dp[i] <- min(dp[i-1] + a, dp[i-2] + b)

    print dp[n]
*/
import java.util.*;

public class dp_primer_apples_step0 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();

    int[] dp = new int[n + 1];

    Arrays.fill(dp, 10000000);
    dp[0] = 0;
    dp[1] = a;
    for (int i = 2; i <= n; i++) {
      dp[i] = Math.min(dp[i - 1] + a, dp[i - 2] + b);
    }

    System.out.println(dp[n]);

    sc.close();
  }
}
