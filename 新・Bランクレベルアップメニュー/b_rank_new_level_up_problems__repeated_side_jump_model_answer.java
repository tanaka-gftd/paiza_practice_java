//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__repeated_side_jump

/* 模範解答 */

/* 
    解説：
    4×N ≦ K ≦ 1,000,000,000より、
    実際に反復横跳びと線の移動をシミュレーションして答えを求めようとすると最大で 1,000,000,000 のループ処理が回ってしまうので、
    実行時間制限をオーバーしてしまいます。

    そこで、この問題の状況を整理して数学的な計算で答えが求められないかを考えてみましょう。
*/

import java.util.*;

public class b_rank_new_level_up_problems__repeated_side_jump_model_answer {
    public static void main(String... args) {
        
        var sc = new Scanner(System.in);
        
        var N = sc.nextLong();
        var X = sc.nextLong();
        var K = sc.nextLong();
        
        if (K % 4 == 3) {
            System.out.println(2 * X * ((K - 4 * N) / 4) + X);
        } else {
            System.out.println(2 * X * ((K - 4 * N) / 4));
        }

        sc.close();
    }
}
