//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__a_cup_of_water

/* 模範解答 */

/*
    問題：
    paiza 君は度胸試しとして、コップに水をギリギリまで入れるゲームをすることにしました。
    ルールは次の通りです。

      ・w_1 ml, ..., w_N ml の水の入った N 個の小さなコップを用意する。
      ・容量が X ml の大きなコップに、小さなコップの中から 1 つ選び、そのコップの水を全て入れる。
      ・大きなコップに溢れないようにギリギリまで水を入れることを目標にする。

    このゲームにおいて paiza 君が最適なプレイをしたとき、大きなコップに水を何 ml 入れることができるかを求めてください。
*/

/*
    解説：
    この問題では制約に1 ≦ N ≦ 15とあり 2^15=32768 であるので、各コップについて水を入れた場合と入れない場合の全ての組み合わせを試して、
    溢れなかった組み合わせのうち水の量が最大なものを出力すれば良いです。

    今回のように各要素について入れる・入れないを列挙する際には、bit全探索と呼ばれる手法が便利です。

    これは、N 個の要素について列挙をおこなう場合、
    ループ変数が 0~2^N まで変化するようなループ内でループ変数の各ビットの値を取得してそれを入れる入れないのフラグとすることで、
    全ての組み合わせを列挙できるというものです。

    このループ内で入れるとした要素の和を求め、それが X 以下かつその時点での最大値である場合に答えを更新する操作をおこなうことでこの問題を解くことができます。
*/

import java.util.*;

public class b_rank_new_level_up_problems__a_cup_of_water_model_answer {
    public static void main(String... args) {
        
        var sc = new Scanner(System.in);
        
        var n = sc.nextInt();
        var X = sc.nextInt();
        
        var ans = 0;
        var w = new int[n];

        for (var i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        
        //0〜2^nまでfor文でループ
        for (var i = 0; i < Math.pow(2, n); i++) {
            
            var sum = 0;
            var tmp = i;
            
            //ビット検索
            /*
                ループ変数が 0~2^N まで変化するようなループ内でループ変数の各ビットの値を取得してそれを入れる入れないのフラグとすることで、
                全ての組み合わせを列挙できる。
            */
            for (var j = 0; j < n; j++) {
                //0〜2^nまでループしていく中で、ループ変数と同じ数を２進数に転換した際の各ビットについて、on,offを考える
                if (tmp % 2 == 1) {  //各ビットが1の時onとする
                    sum += w[j];
                }
                tmp /= 2;  //一つ右のビットへ計算を進める
            }

            if (sum <= X) {
                ans = Math.max(ans, sum);
            }
        }

        System.out.println(ans);
    }
}
