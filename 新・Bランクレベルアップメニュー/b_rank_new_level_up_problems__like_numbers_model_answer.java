//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__like_numbers

/* 模範解答 */
/* 当たり前のことが思いつかなかったのが、残念 */

/* 
    問題：
    システム開発をしている paiza 君は、与えられた文字列から自動で電話番号を取得するプログラムを作成しようと考えました。
    文字列からいきなり電話番号を取得するのは難しいと考えた paiza 君は、
    最初の文字と最後の文字が数字(0~9)であるような文字列を「疑似数字」として取り出すコードを作成することにしました。
    文字列 S が与えられるので、そこに含まれる疑似数字を全て出力してください。
    数字 1 文字の場合であっても疑似数字とみなされる点に注意してください。
*/

/* 
    解説：
    最初の文字と最後の文字が数字(0~9)であるような文字列を「疑似数字」としているので、
    与えられた文字列 S に含まれる全ての 2 文字の組み合わせ S[i], S[j] (i ≦ j) について、
    「S[i] が数字である かつ S[j] が数字である」かを判定することで全ての疑似数字を列挙することができます。
*/

import java.util.*;

public class b_rank_new_level_up_problems__like_numbers_model_answer {
    public static void main(String... args) {
        
        var sc = new Scanner(System.in);
        
        var S = sc.next();

        //文字列から取り出せる2文字の組み合わせ全てで判定していく
        for (var i = 0; i < S.length(); i++) {
            for (var j = i; j < S.length(); j++) {
                //取り出した2文字が両方とも数値なら、取り出した2文字を基準に、全体の文字列からsubstringで切り取る
                if (Character.isDigit(S.charAt(i)) && Character.isDigit(S.charAt(j))) {
                    System.out.println(S.substring(i, j + 1));
                }
            }
        }

        sc.close();
    }
}
