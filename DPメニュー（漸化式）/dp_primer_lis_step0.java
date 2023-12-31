//問題URL：https://paiza.jp/works/mondai/dp_primer/dp_primer_lis_step0

/*
    問題：
    n 本の木が横一列に並んでいます。左から i 番目の木を木 i と呼ぶことにします。木 i の高さは a_i [cm] です。
    あなたは、何本かの木を伐採することによって、残った木を左から順に見ると高さが単調増加になっているようにしたいと考えています。
    つまり、残った木を左から 木 k_1, 木 k_2, ... , 木 k_m とすると、
    a_{k_1} < a_{k_2} < ... < a_{k_m} が満たされているようにしたいです。
    なるべく多くの木が残るように、伐採する木を工夫して選んだとき、伐採されずに残る木の本数が最大でいくつになるか求めてください。
    なお、最初から n 本の木が単調増加に並んでいる場合は、1本も伐採しなくてよいものとします。
*/

/*
    ヒント：
    まずは問題を整理しましょう。
    この問題は、添字の部分列 x1 < x2 < ... < xk であって、a_x1 < a_x2 < ... < a_xk を満たしているようなもの (通称、増加部分列) のうち、k が最も大きいもの (通称、最長増加部分列 (Longest Increasing Subsequence, LIS) ) を求めよという問題に言い換えることができます。

    dp[k] を、最後が木 k であるような増加部分列のうち最長であるものの長さとしてみましょう。
    dp[1] ~ dp[k-1] が求まっているとして、dp[k] とこれらの関係はどのようになっているかを考えてみましょう。

    少し考えると、1以上 k 未満の i について a_i < a_k が成り立っているとき、
    最後が木 i であるような増加部分列の最後に木 k をくっつけることで、新しく長さ dp[i] + 1 の増加部分列を作れることがわかります。
    そして、最後が木 k であるような最長増加部分列は、このようにして作られる部分列のうち最長のものであることがわかります。

    これで、dp[1] ~ dp[k-1] と dp[k] の関係が明らかになりました。自信のある方は自分で漸化式を立ててみましょう。
    以下の疑似コードに従ってあなたの得意な言語で実装してみましょう。

    dp[1] <- 1

    for i = 2 to n
        dp[i] <- 1  // 木 i のみからなる部分列の長さ
        for j = 1 to i-1
            if a[j] < a[i] then
                dp[i] <- max(dp[i], dp[j]+1)    // 最後が木 j であるような増加部分列の末尾に木 i をくっつける

    print max({dp[1], ... ,dp[n]})
*/

/*
    解説：
    dp[k] を最後が木 k であるような増加部分列のうち最長であるものの長さとすると、
    dp[1] ~ dp[k-1] と dp[k] の関係は dp[k] = max({{dp[j]+1 | j < k, a_j < a_k)}, 1}) となります。
    この漸化式に従って、dp[1] から dp[n] まで順に計算すればよいです。
    答えは dp[1] ~ dp[n] の最大値です。
*/

import java.util.*;

public class dp_primer_lis_step0 {

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
            if (array[j] < array[i]) {
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