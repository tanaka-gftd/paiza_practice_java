//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__repeated_side_jump

/*
    問題：
    paiza 君の学校では体力テストがおこなわれており、現在反復横跳びの計測をしています。
    いたずら好きの paiza 君は、友達が光の速さで反復横飛びをしている途中、
    具体的には友達が線を跨ぐのが 4×N 回目になる直前に左の線を元の位置から外側に X cm 遠ざけました。

    最終的に友達の反復横跳びの計測結果は K 回となりました。
    友達は正規の反復横跳びで計測結果が K 回となるときよりも何 cm 多く移動したでしょうか

    なお、今回の反復横跳びでは中央の線を跨いだ状態から始めて、右の線→中央の線→左の線→中央の線→... といった順番で跨いで行くものとします。
*/

import java.util.*;
public class b_rank_new_level_up_problems__repeated_side_jump {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong() * 4;
        long x = sc.nextLong();
        long k = sc.nextLong();
        
        long count = 0;
        
        for(long i = n + 1; i <= k; i++){
            if((i + 1) % 4 == 0){
                count += 1;
            }
            if(i % 4 == 0){
                count += 1;
            }
        }

        System.out.println(count * x);

        sc.close();
    }
}