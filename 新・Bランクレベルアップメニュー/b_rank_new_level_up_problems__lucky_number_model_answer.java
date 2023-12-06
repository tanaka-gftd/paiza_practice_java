//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__lucky_number

/* 模範解答 */

/*
    問題：    
    有名な占い師である paiza 君は次のようなラッキーナンバーの求め方を提唱しました。

    1. 占い師が N 個の自然数 X_1, ..., X_N を宣言する。

    2. それらから 2 つの自然数を選ぶような全ての組み合わせについて次の操作をおこなう。

        選んだ 2 つの各数字に対して、次のいずれかの操作を 1 回おこなうことができる。各数字について別々の操作をおこなうことができる。（おこなわなくても良い）

        ・その数字を +1 する。ex)25->26

        ・その数字を -1 する。ex)25->24

        ・その数字を、その数字の先頭に 1 をつけた数に置き換える。ex)25>125

        ・その数字を、その数字の末尾に 1 をつけた数に置き換える。ex)25->251

        操作後の 2 つの数の差の絶対値の最小値を求める。

    3. 2で求めることができる値のうち最小の値をラッキーナンバーとする。

    占い師が宣言した自然数 X_1, ..., X_N が与えられるので、試しにこの方法でラッキーナンバーを計算してみましょう。
*/

/*
    解説：
    今回の問題では 2 ≦ N ≦ 8 という小さな制約が与えられているので、手順 2 で求めることができる値を実際に全て求めてそれらのうち最小の値を求めましょう。

    X_1,...,X_N のそれぞれについて 2.1 で作ることができる値を求めておき、それらの全ての組み合わせをループ処理などで列挙し、
    差の絶対値を求めて最小であれば更新するという操作をおこないましょう。

    数字の先頭や末尾に 1 をつける操作を行う際は数値⇔文字列の変換を利用すると便利です。
    言語ごとに数値⇔文字列の方法は異なるので言語仕様を調べてみましょう。
*/


import java.util.*;

public class b_rank_new_level_up_problems__lucky_number_model_answer {

    public static void main(String... args) {
        var sc = new Scanner(System.in);

        var N = sc.nextInt();

        //Integer.MAX_VALUE...Integerクラスで設定できる数の最大値
        var ans = Integer.MAX_VALUE;
        var X = new int[N][5];

        for (var i = 0; i < N; i++) {
            X[i][0] = sc.nextInt();
            X[i][1] = X[i][0] + 1;
            X[i][2] = X[i][0] - 1;
            X[i][3] = Integer.valueOf("1" + X[i][0]);
            X[i][4] = Integer.valueOf(X[i][0] + "1");
        }

        for (var i = 0; i < N; i++) {
            for (var j = i + 1; j < N; j++) {
                for (var k = 0; k < 5; k++) {
                    for (var l = 0; l < 5; l++) {
                        ans = Math.min(ans, Math.abs(X[i][k] - X[j][l]));
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
