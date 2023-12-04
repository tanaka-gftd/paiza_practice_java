//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__vision_test

/* 模範解答 */

/*
    問題：
    定期検診の一環として視力検査をおこなうことになりました。
    そこで、保健委員の paiza 君はクラスの視力検査の手伝いをすることになりました。
    視力検査の概要は次の通りです。

    ・視力を良い方から順に A, B, C, D, E の 5 段階で判定します。
    ・各段階の視力であることを検査するためのテスト TA, TB, TC, TD が用意されており、
        paiza 君がこれらのうちのいずれかを被験者に見せ、被験者が正しく解答した場合を「成功」、正しく解答できなかった場合を「失敗」とします。
    ・同じ段階のテストに 2 回失敗する前に 2 回成功した場合、その段階について「合格」、それ以外の場合を「不合格」とします。
    ・合格した段階のうち、最も良い段階をその被験者の視力として判定します。
    ・どのレベルのテストにも合格しなかった場合、被験者の視力は E として扱います。

    ある被験者に対しておこなったテストとその結果が与えられるので、被験者の視力を判定してください。
*/

/*
    解説：
    問題文の通り視力判定をおこなうコードを条件分岐などを用いて書きましょう。
    同じ段階のテストに 2 回成功する前に 2 回失敗した場合、その後何度成功したとしてもその段階について合格になることはないことに注意しましょう。
*/

import java.util.*;

public class b_rank_new_level_up_problems__vision_test_model_answer {
    
    static int testerLevel = 4;
    static int[] ok = new int[4];
    static int[] ng = new int[4];

    static void tests(int level, String result) {
        if (result.equals("ok")) {
            ok[level]++;
        } else {
            ng[level]++;
        }

        if (ok[level] == 2 && ng[level] < 2) {
            testerLevel = Math.min(testerLevel, level);
        }
    }

    public static void main(String... args) {
        
        var sc = new Scanner(System.in);
        
        var n = sc.nextInt();
        
        var testName = new String[] {"TA", "TB", "TC", "TD"};
        var levelName = new String[] {"A", "B", "C", "D", "E"};

        for (var i = 0; i < n; i++) {
            var test = sc.next();
            var result = sc.next();
            for (int j = 0; j < 4; j++) {
                if (test.equals(testName[j])) {
                  tests(j, result);
                }
            }
        }

        System.out.println(levelName[testerLevel]);

        sc.close();
    }
}
