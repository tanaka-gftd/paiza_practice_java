//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__leet_paiza

/* 模範解答 */

/* 
    問題：
    英単語に含まれるアルファベットの一部を形の似た数字や記号で置き換えることを Leet といいます。Leet はパスワードやユーザー名の作成の際に便利な手法の一つです。


    paiza では、エゴサーチを強化するためにツイートの中に Leet 表記された paiza が含まれているかを判定するプログラムを作成することになりました。
    ツイートの文章 S が与えられるので、
    ツイートに "paiza" が含まれる場合は "paiza", 
    "paiza" が含まれず Leet 表記された "paiza" が含まれる場合は "leet", 
    どちらも含まれない場合は "nothing" と出力してください。

    なお、"paiza" の leet 文字列は、"paiza" について以下の置き換えを 1 回以上おこなうことで得られる文字列をさすものとします。

    ・a -> 4 または a -> @
    ・i -> 1 または i -> !
    ・z -> 2
*/

/* 
    解説： 
    "paiza" も Leet 表記された "paiza" も 5 文字であるため、
    与えられた文字列の全ての連続した 5 文字について "paiza" か Leet かいずれでもないかを判定すれば良いです。

    Leet かを判定するためにあらかじめ考えられる Leet 文字列を列挙しておくと良いです。
    列挙の際は Leet を 「aとそのLeet + iとそのLeet + zとそのLeet + aとそのLeet」 という具合に組み合わせて列挙すると良いでしょう。
*/

import java.util.*;

public class b_rank_new_level_up_problems__leet_paiza_model_answer {
    public static void main(String... args) {
        
        var sc = new Scanner(System.in);
        
        var S = sc.next();
        
        var existLeet = false;
        
        //"paiza"各文字について、一致 or Leet表記 を設定したものを保存しておく
        var okChar = new String[5];
        okChar[0] = "p";
        okChar[1] = "a4@";
        okChar[2] = "i1!";
        okChar[3] = "z2";
        okChar[4] = "a4@";

        //入力された文字列の先頭から、一致 or Leetで一致 しているかを判定していく
        //文字列の範囲外をチェックしないよう、iの最大値に注意
        for (var i = 0; i < S.length() - 4; i++) {

            var isLeet = true;

            //"paiza"と完全に一致している箇所があれば、結果を表示して終了
            if (S.substring(i, i + 5).equals("paiza")) {
                System.out.println("paiza");
                return;
            }

            //指定した範囲内の文字列が、Leet表記で一致しているかを判定
            for (var j = 0; j < 5; j++) {

                var charLeetOk = false;

                //指定した範囲内の文字列の先頭から順にチェック
                for (int k = 0; k < okChar[j].length(); k++) {
                    if (S.charAt(i + j) == okChar[j].charAt(k)) {
                        charLeetOk = true;
                    }
                }

                if (!charLeetOk) {
                    isLeet = false;
                    break;
                }
            }

            if (isLeet) {
                existLeet = true;
            }
        }

        //結果を表示
        if (existLeet) {
            System.out.println("leet");
        } else {
            System.out.println("nothing");
        }

        sc.close();
    }
}
