//https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__get_richer_sushi

/* 模範解答 */

/*
    問題：
    paiza 君は家族と一緒に回転寿司に来ています。
    回転寿司の円形のレーンには、価格が P_1, ..., P_N の N 枚の寿司が順番に流れています。
    （価格が P_1 の寿司と P_N の寿司は隣接しています。）
    paiza 君は、家族が目を離した隙にレーンから連続した K 枚の寿司をこっそり取って食べてしまおうと考えました。
    paiza 君は普段食べれない高いお寿司を多く食べたいので、取る K 枚の寿司の合計金額ができるだけ高くなるように寿司を取りたいです。
    paiza 君が食べることができる寿司の合計金額の最大値を求めてください。
*/

/*
    全ての連続する K 枚の寿司の組み合わせについて金額の和を求めて、それらのうち最大のものを出力しましょう。
    今回のように最初の要素と最後の要素が円形に繋がっている要素を 1 次元配列に格納した場合、
    それらから連続した K 個を取り出す際は要素数の剰余(インデックスを要素数で割った値)を用いると良いです。
    例として、P[i] から連続する K 枚を取り出すとき、j = 0, ..., K-1 と遷移するループを用いて P[(i + j) % N] で要素を取得することができます。
    なぜなら、(i + j) % N の値は j の値が0, ..., K-1 と遷移するとき、i, i+1, ..., N-1, 0, 1,... と遷移して範囲外参照を起こさないからです。
*/

import java.util.*;

public class b_rank_new_level_up_problems__get_richer_sushi_model_answer {
    public static void main(String... args) {
        
        var sc = new Scanner(System.in);
        
        var N = sc.nextInt();
        var K = sc.nextInt();
        
        var ans = 0;
        var P = new int[N];

        for (var i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }

        for (var i = 0; i < N; i++) {
            var sum = 0;
            for (var j = 0; j < K; j++) {
                sum += P[(i + j) % N];
            }
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}
