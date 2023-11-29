//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__grid_numbering

/* 模範解答 */

/*
    問題：
    マップの行数 H と列数 W とナンバリングの向き D が与えられるので、
    (0, 0) から指示通りにナンバリングしたとき、マップ全体にどのように番号が振られるかを出力してください。

    D=1...左下から右上への方向
    D=2...左から右への横方向
    D=3...上から下方向への縦方向
    D=4...右上から左下への斜め方向
*/

/*
    解説：
    マップを範囲外参照しないように注意しつつ、二重ループなどを用いてナンバリングをおこないましょう。
    地道に手を動かして添字の動きを確認しましょう。

    斜め方向のナンバリングでは、各斜め列の最初の要素に注目してから斜めに移動していくイメージを持つとナンバリングのイメージがしやすいと思います
*/

import java.util.*;

public class b_rank_new_level_up_problems__grid_numbering_model_answer {
    public static void main(String... args) {
        
        var sc = new Scanner(System.in);
        
        var H = sc.nextInt();
        var W = sc.nextInt();
        var D = sc.nextInt();
        
        var count = 1;
        var ans = new int[H][W];
        
        switch(D) {
            
            case 1 -> {
                ans[0][0] = 1;
                count++;
                
                for (var i = 1; i < H; i++) {
                    for (int j = 0; j <= Math.min(i, W - 1); j++) {
                        ans[i - j][j] = count;
                        count++;
                    }
                }
                
                for (var i = 1; i < W; i++) {
                    for (var j = 0; j < Math.min(H, W - i); j++) {
                        ans[H - 1 - j][i + j] = count;
                        count++;
                    }
                }
            }
            
            case 2 -> {
                for (var i = 0; i < H; i++) {
                    for (var j = 0; j < W; j++) {
                        ans[i][j] = count;
                        count++;
                    }
                }
            }
            
            case 3 -> {
                for (var i = 0; i < W; i++) {
                    for (var j = 0; j < H; j++) {
                        ans[j][i] = count;
                        count++;
                    }
                }
            }
            
            case 4 -> {
                ans[0][0] = 1;
                count++;
                
                for (var i = 1; i < W; i++) {
                    for (var j = 0; j <= Math.min(i, H - 1); j++) {
                        ans[j][i - j] = count;
                        count++;
                    }
                }
                
                for (var i = 1; i < H; i++) {
                    for (var j = 0; j < Math.min(H - i, W); j++) {
                        ans[i + j][W - 1 - j] = count;
                        count++;
                    }
                }
            }
            
        }
        
        for (var i = 0; i < H; i++) {
            var sb = new StringBuilder();
            for (var j = 0; j < W; j++) {
                if (j != 0) {
                    sb.append(" ");
                }
                sb.append(ans[i][j]);
            }
            System.out.println(sb);
        }

        sc.close();
    }
}
