//問題文URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__perfect_shuffle

/* 模範解答 */

/*
    問題：
    トランプのシャッフルの種類の一つにパーフェクトシャッフルというものがあり、
    パーフェクトシャッフルにおける 1 回のシャッフルは次の一連の操作を指します。

    1. 全52枚の山札を上半分と下半分に分ける。
    2. 下半分の一番下のカード, 上半分の一番下のカード, 下半分の下から 2 番目のカード, 上半分の下から 2 番目のカード, ... , 下半分の一番上のカード, 上半分の一番上のカード という順番でカードを積み重ねていく。

    トランプの絵柄をS(スペード), H(ハート), D(ダイア), C(クラブ) と表現するものとし、
    その絵柄の 1 からキングまでの各カードを S_1 , ... , S_13 のように表現するものとします。

    上から S_1, ... , S_13, H_1, ... , H_13, D_1, ... , D_13, C_1, ... , C_13 という順のトランプの山札を用いてパーフェクトシャッフルの操作を K 回おこなった後の山札のカードを上から順に出力してください。

    カードの出力には {絵柄のアルファベット}_{カードの数字} の表現法を用いてください。
*/

import java.util.*;

public class b_rank_new_level_up_problems__perfect_shuffle_model_answer {

    public static void main(String... args) {
        var sc = new Scanner(System.in);

        var K = sc.nextInt();

        var deck = new String[52];
        var upperSide = new String[26];
        var lowerSide = new String[26];

        var mark = new String[] { "S", "H", "D", "C" };

        for (var i = 3; 0 <= i; i--) {
            for (var j = 13; 1 <= j; j--) {
                deck[i * 13 + j - 1] = mark[i] + "_" + j;
            }
        }

        for (var i = 0; i < K; i++) {
            for (var j = 0; j < 26; j++) {
                upperSide[j] = deck[j];
            }

            for (var j = 0; j < 26; j++) {
                lowerSide[j] = deck[26 + j];
            }

            for (var j = 0; j < 52; j++) {
                if (j % 2 == 0) {
                    deck[j] = upperSide[j / 2];
                } else {
                    deck[j] = lowerSide[j / 2];
                }
            }
        }

        for (var val : deck) {
            System.out.println(val);
        }

        sc.close();
    }
}
