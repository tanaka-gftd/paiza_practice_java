//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__similar_randamize

/* 模範解答 */

/* 
    問題：
    指定した範囲内の値を一様ランダムに出力する装置を乱数生成機といい、出力された数値を乱数といいます。
    この乱数は乱択アルゴリズムなどで利用されており、IT の分野で大きな役割を果たしています。
    この乱数を手元で再現する方法として疑似乱数というものがあります。
    この疑似乱数は、乱数を得る代わりに事前に用意しておいた計算式の結果を乱数として採用するというものです。

    この問題では試しに以下のような計算式によって定められた疑似乱数生成機を用いて、乱数を N 個(rnd_1, ..., rnd_N)生成してみましょう。

    rnd_i = (X^i + X^{i-1} ... + X^1) mod M
*/

/* 
    解説：
    rnd_i = (X^i + X^{i-1} ... + X^1) mod M の計算をおこないましょう。

    (X^i + X^{i-1} ... + X^1) は大きな値になりオーバーフローの可能性があるので、細かく mod M に変換して計算をおこないましょう。
*/

import java.util.*;

public class b_rank_new_level_up_problems__similar_randamize_model_answer {
    public static void main(String... args) {
        
        var sc = new Scanner(System.in);
        
        var X = sc.nextInt();
        var M = sc.nextInt();
        var N = sc.nextInt();
        
        var pow = 1;
        var seed = 0;

        for (var i = 0; i < N; i++) {
            pow *= X;
            pow %= M;
            seed += pow;
            seed %= M;
            System.out.println(seed);
        }
    }
}
