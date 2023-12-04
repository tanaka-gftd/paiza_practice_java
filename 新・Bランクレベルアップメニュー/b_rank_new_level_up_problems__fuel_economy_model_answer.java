//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__fuel_economy

/* 模範解答 */

/*
    問題：
    一般的な車では、車が止まった状態から発進する際は燃費がよくないことが知られています。
    このことを知った paiza 君は発進時とそれ以外での燃費を分けて考えることで実際の燃費を求めたいと考えました。

    具体的には、発進から X m 走るまでは 1 m あたり燃料が F_1 ml, 
    発進から X m 走った後から止まるまでは 1 m あたり燃料が F_2 ml かかります。
    途中、出発地点から s_1(m), ..., s_N(m) の地点で一時停止をしながら全長 L m を走ると、全体を通して必要な燃料は何 ml になるでしょうか？

    なお、停車中の燃料の消費や燃料切れについては考えないものとします。
*/

/*
    解説：
    s_N ≦ L ≦ 1,000,000,000という制約より、
    車が 1 m ずつ進んでいく様子をシミュレーションして燃料を計算すると最大でループが 1,000,000,000 回おこなわれる可能性があり、
    実行時間制限をオーバーしてしまう可能性があります。

    そこで、1 ≦ N ≦ 1000という制約に注目して計算と場合分けを用いて燃料の総量を求めてみましょう。
    A m 地点から出発して B m 地点で一時停止するまでに必要な燃料を求めることを考えます。

    出発から X m 移動するまでは 1 m あたり F_1 ml, それ以降は F_2 ml の燃料が必要なので、
    B-A が X m 以下か否かで場合分けをすることで次の式で燃料を計算することができます。
        • B-A ≦ X のとき・・・ F_1 × (B-A)
        • X ≦ B-A のとき・・・ F_1 × X + F_2 × (B-A-X)

    この計算を全ての一時停止地点についておこなうことで O(N) で答えを求めることができます。
    最初の区間（スタートから最初の一時停止地点まで）と最後の区間（最後の一時地点から L m まで）の計算を忘れないように注意しましょう。
*/

import java.util.*;

public class b_rank_new_level_up_problems__fuel_economy_model_answer {
    public static void main(String... args) {
        
        var sc = new Scanner(System.in);
        
        var x = sc.nextInt();
        var f1 = sc.nextInt();
        var f2 = sc.nextInt();
        var l = sc.nextInt();
        var n = sc.nextInt();
        
        var s = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        
        s[n] = l;
        
        var now = 0L;
        var ans = 0L;
        
        for (var i = 0; i <= n; i++) {
            if (x < s[i] - now) {
                ans += f1 * x + f2 * ((s[i] - now) - x);
            } else {
                ans += f1 * (s[i] - now);
            }
            now = s[i];
        }
        
        System.out.println(ans);

        sc.close();
    }
}
