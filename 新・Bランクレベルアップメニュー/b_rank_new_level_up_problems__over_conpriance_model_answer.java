//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__over_conpriance

/* 模範解答 */

/*
    問題：
    君主の paiza 国王によって情報統制が厳しくなった paiza 国では、今回新たに使用禁止用語の検閲についての次のような法律ができました。

        今後、放送禁止単語 S と文字数が同じで、前半分または後ろ半分が同じ文字である単語 V を放送する時は、
        放送禁止用語と重なっている部分（前半分または後ろ半分）の文字を全て x で置き換えた単語を放送する。
        また、V が放送禁止用語と完全に一致する場合は V を放送せず、代わりに "banned" と出力する。
    以上、

    放送禁止用語 S と N 個の放送したい単語 V_1, ..., V_N が与えられるので、検閲をおこなった後の V_1, ..., V_N を出力してください。

    例として、S = math, V_1 = main, V_2 = programming, V_3 = memo, V_4 = paiza の場合は、
    検閲後の各単語は xxin, programming, memo, paiza となります。
*/

/*
    解説：
    放送禁止用語と各単語 V_1, ... について前半分・後ろ半分・文字列全体が一致するかを判定し、
    判定結果に応じて文字の一部を x に置き換えましょう。
    S_i の文字数が奇数の場合は、文字列の前半と後半に中央の文字が含まれることに注意してください。
*/

import java.util.*;

public class b_rank_new_level_up_problems__over_conpriance_model_answer {
    public static void main(String... args) {
        
        var sc = new Scanner(System.in);
        
        var n = sc.nextInt();
        var S = sc.next();

        for (var i = 0; i < n; i++) {
            
            var V = sc.next();
            
            if (V.length() == S.length()) {
                if (V.equals(S)) {
                    System.out.println("banned");
                } else if (V.substring(0, (V.length() + 1) / 2).equals(S.substring(0, (V.length() + 1) / 2))) {
                    System.out.println("x".repeat((V.length() + 1) / 2) + V.substring((V.length() + 1) / 2));
                } else if (V.substring(V.length() / 2).equals(S.substring(V.length() / 2))) {
                    System.out.println(V.substring(0, V.length() / 2) + "x".repeat((V.length() + 1) / 2));
                } else {
                    System.out.println(V);
                }
            } else {
                System.out.println(V);
            }
        }
    }
}
