//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__struck_out

/* 模範回答 */
/* 難しすぎ */

/* 
    問題：
    バッティングセンターに通っている paiza 君はそこに置いてある 1〜9 が以下のように配置されたストラックアウトに興味を持ちました。

    1 2 3
    4 5 6
    7 8 9

    ストラックアウトには得点が設定されており、店内ランキングが存在します。
    ランキングで一位になりたいと考えた paiza 君はストラックアウトで獲得できる最高得点を求めようと考えました。
    得点は次のように計算されます。初め得点は 0 点からスタートします。
    ・数字 i のパネルを倒すと s_i 点が加算される。
    ・数字 i のパネルを倒すことで新たに j 個のビンゴができたとき、b_i_j 点が加算される。
    ・n (1 < n) 個ビンゴができた場合であっても、加算されるのは b_i_n のみ(b_i_{n-1} などは加算されない)

    獲得できる得点の最大値を求めてください。
    なお、一度倒したパネルを再度倒すことはできないことに注意してください。
*/

/* 
    解説：
    まず、問題の制約よりパネルを倒すことによって獲得する得点は必ず正の値となるので、
    得点を最大化させるには明らかに全てのパネルを倒した方が良いということがわかります。

    得点が最大のとき、全てのパネルを倒すので答えとなる値は s_1 + ... + s_9 + ビンゴができた時に得られる得点の最大値 となります。

    この問題ではパネルの枚数が 9 枚であるので、全てのパネルを倒す順番の順列についてビンゴで獲得できる得点を計算し、その最大値を求めることができます。
    この処理でおこなわれるループの回数は 1 ~ 9 の値の並べ方の数と一致するので 9! となり、実行時間制限に間に合います。

    順列を列挙するには、再帰関数や言語によって用意されている関数を利用するなどしましょう。
*/

import java.util.*;

public class b_rank_new_level_up_problems__struck_out_model_answer {
    public static void main(String... args) {
        
        var sc = new Scanner(System.in);
        
        /* 
            個々のパネル自体に設定された点数の合計 + ボーナスが最大となるような時の点数 を解答としたい
        */
        var ans = 0;  //個々のパネル自体に設定された点数の合計
        var add = 0;  //ボーナスが最大となるような時の点数

        //個々のパネルを落とした時の得点を保存する配列
        var s = new int[9];

        //各パネルを落とした時、ビンゴが成立した時のボーナス点を保存する配列
        //各配列に格納される要素数は異なるが、最大の要素数が4なので、4にしておく
        var b = new int[9][4];

        //全てのパターンを作成するための自作の関数内で使用
        //[0, 1, 2, 3, 4, 5, 6, 7, 8] が格納される
        var panels = new Integer[9];

        //各パネルを落とした時の得点を配列に保存
        for (var i = 0; i < 9; i++) {
            s[i] = sc.nextInt();
            panels[i] = i;
            ans += s[i];
        }

        //各パネルを落とした時の、ビンゴボーナス点を保存する配列
        for (var i = 0; i < 9; i++) {
            if (i == 4) {
                for (var j = 0; j < 4; j++) {
                    b[i][j] = sc.nextInt();
                }
            } else if (i % 2 == 0) {
                for (var j = 0; j < 3; j++) {
                    b[i][j] = sc.nextInt();
                }
            } else {
                for (var j = 0; j < 2; j++) {
                    b[i][j] = sc.nextInt();
                }
            }
        }

        //Integer[]を要素として保存していく、ArrayListを作成
        /*  
            l1 の要素として、{0, 1, 2, 3, 4, 5, 6, 7, 8} とそれを並び替えた全てのパターンが、加えられていく。
            結果として、l1 の要素の数は、9!=362880 となる。
        */
        var l1 = new ArrayList<Integer[]>();

        //自作した関数で、[0, 1, 2, 3, 4, 5, 6, 7, 8] の要素の並び順を組み替えた全てのパターンを作成する
        permute(l1, Arrays.asList(panels), 0);
        
        //362880通りの、全てのパターンで点数を計算していく
        for (var p : l1) {

            //各パネルを落としたかどうか(初期値はfalseで、パネルを落としていない)
            var openedPanel = new boolean[9];

            //個々のパターンにおける、ビンゴボーナス点の合計を保存
            var tmp = 0;
            
            for (var i = 0; i < 9; i++) {
            
                //ビンゴボーナスの点数を格納した二次元配列のインデックス指定に使用
                var line = 0;
            
                /*
                    各パネルを落とした時、ビンゴが成立するための他のパネルを落としていたか判定し、
                    ビンゴが成立しているなら、ビンゴボーナスの点数を格納した二次元配列のインデックス指定用の数値を増やす。
                */
                switch (p[i]) {
                    
                    case 0 -> {
                        line += (openedPanel[1] && openedPanel[2] ? 1 : 0);
                        line += (openedPanel[3] && openedPanel[6] ? 1 : 0);
                        line += (openedPanel[4] && openedPanel[8] ? 1 : 0);
                    }
                    
                    case 1 -> {
                        line += (openedPanel[0] && openedPanel[2] ? 1 : 0);
                        line += (openedPanel[4] && openedPanel[7] ? 1 : 0);
                    }
                    
                    case 2 -> {
                        line += (openedPanel[0] && openedPanel[1] ? 1 : 0);
                        line += (openedPanel[5] && openedPanel[8] ? 1 : 0);
                        line += (openedPanel[4] && openedPanel[6] ? 1 : 0);
                    }
                    
                    case 3 -> {
                        line += (openedPanel[0] && openedPanel[6] ? 1 : 0);
                        line += (openedPanel[4] && openedPanel[5] ? 1 : 0);
                    }
                    
                    case 4 -> {
                        line += (openedPanel[0] && openedPanel[8] ? 1 : 0);
                        line += (openedPanel[2] && openedPanel[6] ? 1 : 0);
                        line += (openedPanel[1] && openedPanel[7] ? 1 : 0);
                        line += (openedPanel[3] && openedPanel[5] ? 1 : 0);
                    }
                    
                    case 5 -> {
                        line += (openedPanel[2] && openedPanel[8] ? 1 : 0);
                        line += (openedPanel[3] && openedPanel[4] ? 1 : 0);
                    }
                    
                    case 6 -> {
                        line += (openedPanel[0] && openedPanel[3] ? 1 : 0);
                        line += (openedPanel[2] && openedPanel[4] ? 1 : 0);
                        line += (openedPanel[7] && openedPanel[8] ? 1 : 0);
                    }
        
                    case 7 -> {
                        line += (openedPanel[1] && openedPanel[4] ? 1 : 0);
                        line += (openedPanel[6] && openedPanel[8] ? 1 : 0);
                    }
                    
                    case 8 -> {
                        line += (openedPanel[2] && openedPanel[5] ? 1 : 0);
                        line += (openedPanel[6] && openedPanel[7] ? 1 : 0);
                        line += (openedPanel[0] && openedPanel[4] ? 1 : 0);
                    }
                }

                //パネルを落とした時の、ビンゴボーナス点を加えていく
                //(0 = line となるのは、ビンゴボーナスが発生しなかった時)
                if (0 < line) {
                    tmp += b[p[i]][line - 1]; 
                }
                
                //落としたパネルは、true(落とし済み)にしておく
                openedPanel[p[i]] = true;
            }
            
            /* 
                今までのパターンで見つかった最大のビンゴボーナスの合計と、今回のパターンでのビンゴボーナスの合計を比較。
                大きい方を残す。
            */
            add = Math.max(add, tmp);
        }

        //個々のパネル自体に設定された点数の合計 + ボーナスが最大となるような時の点数
        System.out.println(ans + add);

        sc.close();
    }

    /* 
        順列を列挙したいときに、
        Javaではc++でいうnext_permutationのようなものがないので
        自作する必要がある。

        自作の関数
        第一引数...Integer[]を要素として保存していく、ArrayList
        第二引数...Arrays.asList(panels)、具体的には {0, 1, 2, 3, 4, 5, 6, 7, 8} というリスト
        第三引数...再帰的なループ内で使用する、要素組み替え時のインデックス指定用(本関数が初めて呼び出される時は 0 が渡される)

        これにより、{0, 1, 2, 3, 4, 5, 6, 7, 8}と、それを組み替えた全てのパターンが、
        リストl1 の要素として加えられていく
    */
    static void permute(List<Integer[]> l1, List<Integer> l2, int k){
        
        for(var i = k; i < l2.size(); /* l2.size()は9 */ i++){

            /* 
                Collections.swap...リスト内の2つの要素を交換する。引数は(リスト名、index, index)
            */
            Collections.swap(l2, i, k);

            //再帰的呼び出しで、組み替えのパターンを派生させていく
            permute(l1, l2, k + 1);
            Collections.swap(l2, k, i);
        }
        
        //Collections.swapによる リストl2 内の要素の組み替えが一通り終えるごとに、リストl2 を リストl1 の要素として追加
        if (k == l2.size() - 1){
            l1.add(l2.toArray(new Integer[l2.size()]));
        }
    }
}
