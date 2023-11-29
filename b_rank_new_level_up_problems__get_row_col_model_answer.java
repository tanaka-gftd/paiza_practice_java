//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__get_row_col

/* 模範解答 */

/*
    問題：
    マップの行数 H と列数 W とマップを表す H 行 W 列の文字列 S_1 ... S_H と y , x 座標 が与えられるので、
    与えられた座標のマス(y, x) と、 (y, x) と同じ縦・横・斜めの列に存在する全てのマスについて次の処理をおこなった後の盤面を出力してください。

    マスに書かれている文字が "." の場合は "#" に、"#" の場合は "." に書き換える。

    なお、マスの座標系は左上端のマスの座標を ( y , x ) = ( 0 , 0 ) とし、
    下方向が y 座標の正の向き、右方向が x 座標の正の向きとします。
    マス(y,x) と同じ斜めの列とは整数 a を用いて (y+a,x+a), (y+a,x-a), (y-a,x-a), (y-a,x+a) のいずれかで表されるマスの集合です。
*/

/* 
    解説：
    マップを二次元配列で管理しましょう。

    今回の座標系において、(y,x)と同じ縦列のマスは 0 ≦ i < W であるような i を用いて (i,x) の通り表されます。
    同様にして、横列のマスは 0 ≦ i < H であるような i を用いて (i,x), 
    斜めの列のマスは 0 ≦ i < min(h,w) であるような i を用いて (y±i,x±i) (ただし、0 ≦ y±i < H かつ 0 ≦ x±i < W を満たすもの) と表すことができます。

    このことと for 文などの繰り返しを用いて、縦横斜めの全ての列について問題文の通りの処理をおこないましょう。
*/

import java.util.*;

public class b_rank_new_level_up_problems__get_row_col_model_answer {
    public static void main(String... args) {
        
        var sc = new Scanner(System.in);
        
        var H = sc.nextInt();
        var W = sc.nextInt();
        var S = new String[H][W];
        
        //入力された文字列をsplitで１文字ずつ分解して配列化
        //配列化された文字列を、S[i]に格納することで、二重配列となる
        //個々の配列の要素は1文字だけだが、あくまでもString型(splitで1文字に分解してもchar型にはならない)
        for (var i = 0; i < H; i++) {
            S[i] = sc.next().split("");
        }
        
        //入力された座標を保管
        var y = sc.nextInt();
        var x = sc.nextInt();
        
        //入力された座標と同じ横座標の一列について、文字を切り替え
        for (var i = 0; i < H; i++) {
            if (S[i][x].equals(".")) {  //String型なので、equalsで比較
                S[i][x] = "#";
            } else {
                S[i][x] = ".";
            }
        }

        //入力された座標と同じ縦座標の一列について、文字を切り替え
        for (var i = 0; i < W; i++) {
            if (S[y][i].equals(".")) {
                S[y][i] = "#";
            } else {
                S[y][i] = ".";
            }
        }

        //斜め方向の文字切り替えについては、縦or横が端まで到達するまでループ処理
        //Math.min(H, W)で、iの最大値を設定できる
        for (var i = 1; i < Math.min(H, W); i++) {
            
            //y + i < H で、下方向の端まで処理できる
            if (y + i < H) {
                
                //入力された座標から、右斜め下方向
                if (x + i < W) {
                    if (S[y + i][x + i].equals(".")) {
                        S[y + i][x + i] = "#";
                    } else {
                        S[y + i][x + i] = ".";
                    }
                }
                
                //入力された座標から、左斜め下方向
                if (0 <= x - i) {
                    if (S[y + i][x - i].equals(".")) {
                        S[y + i][x - i] = "#";
                    } else {
                        S[y + i][x - i] = ".";
                    }
                }
            }
            
            //0 <= y - i で、上方向の端まで処理できる
            if (0 <= y - i) {
                
                //入力された座標から、右斜め上方向
                if (x + i < W) {
                    if (S[y - i][x + i].equals(".")) {
                        S[y - i][x + i] = "#";
                    } else {
                        S[y - i][x + i] = ".";
                    }
                }
                
                //入力された座標から、左斜め上方向
                if (0 <= x - i) {
                    if (S[y - i][x - i].equals(".")) {
                        S[y - i][x - i] = "#";
                    } else {
                        S[y - i][x - i] = ".";
                    }
                }
            }
        }
        
        //入力された座標の文字を切り替え
        /*
            入力された座標の文字切り替えは、以上までの処理で偶数回(*)行ったので、元の文字に戻っており、
            最後にもう一回文字切り替えを行う必要がある。
            (* 横一列切り替えで1回、縦一列切り替えで1回、斜め方向切り替えで4回、1+1+4で計6回行っている)
        */
        if (S[y][x].equals(".")) {
            S[y][x] = "#";
        } else {
            S[y][x] = ".";
        }

        for (var i = 0; i < H; i++) {
            for (var j = 0; j < W; j++) {
                System.out.print(S[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}