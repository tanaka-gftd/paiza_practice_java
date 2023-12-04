//https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__move_simulation

/*
    問題：
    paiza 君は次のような仕組みの位置情報システムを作成することにしました。

    1. 時刻 t_1(=0), t_2, ... , t_n(=100) のユーザーの位置情報 (y,x) を取得する。

    2. 各時刻 T = 0, 1, ..., 100 のユーザーの座標(位置情報)を次の方法で計算する。

        T = t_1, T = t_2, ..., T = t_n のいずれかに当たる場合
            時刻 T における座標(1. で取得した位置情報)を時刻 T における座標 (y,x) とする。

        t_i < T < t_{i+1} (1 ≦ i < n) の場合
            t_i 時点での座標 (y_1, x_1) から t_{i+1} 時点での座標 (y_2, x_1) へ等速で直線移動すると仮定して時刻 T における座標を計算によって求める。
            ただし、座標が小数になる場合は小数点以下を四捨五入する。

    n 回の位置情報取得によって得られた座標が与えられるので、時刻 0, 1, ..., 100 の各時刻における座標を出力してください。
*/

/*
    解説：
    問題文の通り位置情報を求めるコードを書きましょう。

    時刻 t_1 で座標 (y_1,X_1), 時刻 t_2 で座標 (y_2,X_2) であるような 2 点の間を等速直線運動すると仮定したとき、
    時刻 t_1 ≦ T ≦ t_2 における y 座標は y_1 + (T-t_1)*(y_2-y_1)/(t_2-t_1) となります。これは、y_1 に等速直線運動の単位時間あたりに進む距離 (y_2-y_1)/(t_2-t_1) と移動時間 (T-t_1) をかけた値を足すといった計算をしています。

    小数点の四捨五入に注意しましょう。上の方法で計算すると計算の中で自然に四捨五入が行われます。
*/

import java.util.*;

public class b_rank_new_level_up_problems__move_simulation_model_answer {

    public static void main(String... args) {
        var sc = new Scanner(System.in);

        var n = sc.nextInt();

        //ループ内で使用する変数
        //位置情報の出力に利用
        var nowIndex = 0;

        //入力された時間と、位置情報を格納(位置情報は桁数が大きいのでlong型)する配列
        var t = new int[n];
        var x = new long[n];
        var y = new long[n];

        //入力された時間と、位置情報を格納していく
        for (var i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            y[i] = sc.nextLong();
            x[i] = sc.nextLong();
        }

        for (var i = 0; i <= 100; i++) {
            if (i == t[nowIndex]) {
                /* 
                    その時間帯の位置情報が入力されているのならば、それをそのまま出力する。
                    （計算では求めない）
                */
                System.out.println(y[nowIndex] + " " + x[nowIndex]);
                nowIndex++;
            } else {
                System.out.println(
                    //yの一つ前の位置情報を示す値に、「移動時間 * y方向への現在の速度」を加える
                    (y[nowIndex - 1] + (i - t[nowIndex - 1]) * (y[nowIndex] - y[nowIndex - 1]) / (t[nowIndex] - t[nowIndex - 1])) 
                    + 
                    " " 
                    +//xの位置情報についても、yと同様
                    (x[nowIndex - 1] + (i - t[nowIndex - 1]) * (x[nowIndex] - x[nowIndex - 1]) / (t[nowIndex] - t[nowIndex - 1]))
                );
            }
        }

        sc.close();
    }
}