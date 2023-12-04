//https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__move_simulation

/* 
    不正解、自分で書いたコード
    考え方は正しいのだが、少し値のずれが生じている
    どこかでミスをしている
    （移動速度の算出方法？ 小数点以下の四捨五入？）
*/

/*
    問題：
    paiza 君は次のような仕組みの位置情報システムを作成することにしました。

    1. 時刻 t_1(=0), t_2, ... , t_n(=100) のユーザーの位置情報 (y,x) を取得する。

    2. 各時刻 T = 0, 1, ..., 100 のユーザーの座標(位置情報)を次の方法で計算する。

        T = t_1, T = t_2, ..., T = t_n のいずれかに当たる場合
            時刻 T における座標(1. で取得した位置情報)を時刻 T における座標 (y,x) とする。

        t_i < T < t_{i+1} (1 ≦ i < n) の場合
            t_i 時点での座標 (y_1, x_1) から t_{i+1} 時点での座標 (y_2, x_1) へ等速で直線移動すると仮定して時刻 T における座標を計算によって求める。
            ただし、座標が小数になる場合は小数点以下を四捨五入する。

    n 回の位置情報取得によって得られた座標が与えられるので、時刻 0, 1, ..., 100 の各時刻における座標を出力してください。
*/

import java.util.*;
public class b_rank_new_level_up_problems__move_simulation_NG {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] t_array = new int[n];
        long[] y_array = new long[n];
        long[] x_array = new long[n];
        
        for(int i = 0; i<n; i++){
            t_array[i] = sc.nextInt();
            y_array[i] = sc.nextLong();
            x_array[i] = sc.nextLong();
        }
        
        int[] t_array_result = new int[101];
        long[] y_array_result = new long[101];
        long[] x_array_result = new long[101];
        
        for(int i = 0; i<101; i++){
            t_array_result[i] = i;
        }
        
        for(int i = 0; i<n-1; i++){
            int diff = t_array[i + 1] - t_array[i];
            
            //移動速度を算出
            long y_diff = (y_array[i + 1] - y_array[i]) / diff;
            long x_diff = (x_array[i + 1] - x_array[i]) / diff;
            
            for(int k = t_array[i]; k<=t_array[i + 1]; k++){
                //移動速度*時間 を加えることで、現在位置を算出
                y_array_result[k] = y_array[i] + (y_diff * (k - t_array[i]));
                x_array_result[k] = x_array[i] + (x_diff * (k - t_array[i]));
            }
        }
        
        for(int v : t_array_result){
            System.out.println(y_array_result[v] + " " + x_array_result[v]);
        }
        
        sc.close();
    }
}

