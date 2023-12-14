//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__taxi_distance

/* 
    模範解答。
    ソート関連が、思っていたより複雑だった。
*/

/*
    問題：
    幾何学における距離概念にユークリッド距離とマンハッタン距離というものがあります。
    ユークリッド距離では、二点 P_1(x_1,y_1), P_2(x_2,y_2) の間の距離 len(P1,P2) を次のように定義しています。

        len(P_1,P_2) = sqrt( (x_1 - x_2)^2 + (y_1 - y_2)^2 )
        (sqrt(A) は ルート A, つまり A の平方根を表す)

    一方、マンハッタン距離では二点 P_1(x_1,y_1), P_2(x_2,y_2) の間の距離 len(P1,P2) を次のように定義しています。

        len(P_1,P_2) = |x_1 - x_2| + |y_1 - y_2|

    地点 P の座標と、1〜N(>3) 番の番号が振られた地点 F_1, ..., F_N の座標が与えられるので、
    ユークリッド距離で計算した際に地点 P からの距離が近い 3 地点の番号と、
    マンハッタン距離で計算した際に地点 P からの距離が近い 3 地点の番号を求めてください。
    ただし距離が同じ地点が複数存在する場合、番号が小さい地点ほど近い地点であるものとしてください。
*/

/* 
    解説：
    各地点についてユークリッド距離とマンハッタン距離を求めて、比較や並び替えをおこないましょう。
    ユークリッド距離を求める際は小数の扱いに注意しましょう。
    また小数を用いずとも sqrt(A) < sqrt(B) であるならば A < B であり、
    その逆も成り立つため sqrt の中身 (x_1 - x_2)^2 + (y_1 - y_2)^2 を比較することで距離の大小関係を求めることができます。
*/

import java.util.*;
import java.util.stream.*;

public class b_rank_new_level_up_problems__taxi_distance_model_answer {
    public static void main(String... args) {
        
        var sc = new Scanner(System.in);
        
        var px = sc.nextInt();
        var py = sc.nextInt();
        var N = sc.nextInt();

        //レコードクラスを作成し、インスタンスにデータを保持できるようにする
        /* 
            レコードクラス：
            単純なデータ構造のみを持つクラスをシンプルに記述できるようになる。
            classキーワードの代わりに、recordキーワードを使用する。

            例として、
            record Pair(int first, int second) {
                
            };
            は、
        
            class Pair{
                int first;
                int second;

                public Pair(int first, int second){
                    this.first = first;
                    this.second = second;
                }

                public int first(){
                    return first;
                }
                
                public int second(){
                    return second;
                }
            }
            と同一である。
        */
        record Pair(int first, int second) {

        };
        
        //Pairクラスのインスタンスを保存するリストを準備
        var euclidLen = new ArrayList<Pair>();
        var taxiLen = new ArrayList<Pair>();
        
        /*
            入力された2個の数値を元に、ユークリッド距離とマンハッタン距離を算出し、
            算出されたそれぞれの値とインデックス用の値をセットにし、Pairクラスのインスタンスを生成。
            生成したPairクラスのインスタンスをリストに追加していく。
        */
        for (var i = 0; i < N; i++) {
            var x = sc.nextInt();
            var y = sc.nextInt();

            //問題文では平方根で比較しているが、平方根しなくても大小関係は変わらないので、そのまま格納
            euclidLen.add(new Pair((px - x) * (px - x) + (py - y) * (py - y), i + 1));

            taxiLen.add(new Pair(Math.abs(px - x) + Math.abs(py - y), i + 1));
        }
        
        /*
            Stream API：
            Java SE 8から追加されたイテレーションの拡張API。
            コレクションに対して行なっていた処理を、シンプルなコードで記述することが可能になる。

            streamの基本的な流れ
            １：コレクションからstreamを生成
            ２：streamに対して、「中間操作」を実行し、コレクションの中身を目的に応じて変換する
            ３：「終端操作」で、変換したコレクションの中身に対して処理を適用する。
        */
        euclidLen.stream()  //コレクションからstreamを生成
            .sorted(Comparator.comparing(Pair::first).thenComparing(Pair::second))  //streamの要素を複数のキーでソート
            .limit(3)  //要素数を設定(ここでは要素数３)
            .map(Pair::second) //ストリーム内の各要素に対して指定された関数を適用し、その結果を含む新しいストリームを生成(ここではPairクラスのsecondフィールド)
            .forEach(System.out::println);  //各要素を表示していく
            
        taxiLen.stream()
            .sorted(Comparator.comparing(Pair::first).thenComparing(Pair::second))
            .limit(3)
            .map(Pair::second)
            .forEach(System.out::println);

        sc.close();
    }
}
