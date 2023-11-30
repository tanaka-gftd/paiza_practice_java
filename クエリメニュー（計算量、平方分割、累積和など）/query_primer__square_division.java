//問題URL：https://paiza.jp/works/mondai/query_primer/query_primer__square_division

import java.util.*;
public class query_primer__square_division {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        
        int query  = sc.nextInt();

        //入力された10000件の数値を100*100で保管する二次元配列
        //これ以降、二次元配列内の内側の配列のことを、部分配列と呼称
        int[][] all_array = new int[100][100];

        //それぞれの部分配列での最大値を格納する配列
        int[] maxNum_array = new int[100];
        
        //入力された10000件の数値を二次元配列に保管
        for(int i = 0; i<100; i++){
            for(int j = 0; j<100; j++){
                all_array[i][j] = sc.nextInt();
            }
        }
        
        //部分配列ごとに最大値を求め保管
        for(int i = 0; i<100; i++){

            //比較用に使用する変数
            //初期値は問題文で指定されている、入力値の最小の値
            int max = -100000;

            for(int j = 0; j<100; j++){
                
                if(max<all_array[i][j]){
                    max = all_array[i][j];
                }
            }
            maxNum_array[i] = max;
        }
        
        //指定された区間内の最大値を求めて比較し、最終的に結果を表示する
        for(int i = 0; i<query; i++){

            //入力された開始位置と終了位置を保存
            int begin = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            
            //開始位置と終了位置の、二次元配列内での一つ目のインデックス
            int all_array_beginIndex_first = begin / 100;
            int all_array_endIndex_first = end / 100;

            //開始位置と終了位置の、二次元配列内での二つ目のインデックス
            int all_array_beginIndex_second = begin % 100;
            int all_array_endIndex_second = end % 100;

            //比較用に使用する変数
            //初期値は問題文で指定されている、入力値の最小の値
            int max = -100000;
            
            /*
              •開始位置と終了位置が同じ部分配列内の場合
              •開始位置を含む部分配列と、終了位置を含む部分配列が隣り合っていた場合
              •開始位置を含む部分配列と、終了位置を含む部分配列が離れていた場合
              で、それぞれ処理を切り分ける
            */
            if(all_array_beginIndex_first == all_array_endIndex_first){
            /* 開始位置と終了位置が同じ部分配列内の場合 */

                for(int j = all_array_beginIndex_second; j<=all_array_endIndex_second; j++){
                    if(max<all_array[all_array_beginIndex_first][j]){
                        max = all_array[all_array_beginIndex_first][j];
                    }
                }
                
            }else if(all_array_beginIndex_first + 1 == all_array_endIndex_first){
            /* 開始位置を含む部分配列と、終了位置を含む部分配列が隣り合っていた場合 */

                //指定された開始位置を含む配列内で、開始位置のインデックス〜その配列の最終インデックスで最大値との比較
                for(int k = all_array_beginIndex_second; k<=99; k++){
                    if(max<all_array[all_array_beginIndex_first][k]){
                        max = all_array[all_array_beginIndex_first][k];
                    }
                }
            
                //指定された終了位置を含む配列内で、その配列のインデックス0〜終了位置のインデックスで最大値との比較
                for(int l = 0; l<=all_array_endIndex_second; l++){
                    if(max<all_array[all_array_endIndex_first][l]){
                        max = all_array[all_array_endIndex_first][l];
                    }
                }
                
            }else if(all_array_beginIndex_first + 2<=all_array_endIndex_first){
            /* 開始位置を含む部分配列と、終了位置を含む部分配列が離れていた場合 */
                
                //指定された区間に、完全に含まれている部分配列内での最大値を求める
                for(int j = all_array_beginIndex_first + 1; j<=all_array_endIndex_first - 1; j++){
                    if(max<maxNum_array[j]){
                        max = maxNum_array[j];
                    }
                }
                
                //指定された開始位置を含む配列内で、開始位置のインデックス〜その配列の最終インデックスで最大値との比較
                for(int k = all_array_beginIndex_second; k<=99; k++){
                    if(max<all_array[all_array_beginIndex_first][k]){
                        max = all_array[all_array_beginIndex_first][k];
                    }
                }
            
                //指定された終了位置を含む配列内で、その配列のインデックス0〜終了位置のインデックスで最大値との比較
                for(int l = 0; l<=all_array_endIndex_second; l++){
                    if(max<all_array[all_array_endIndex_first][l]){
                        max = all_array[all_array_endIndex_first][l];
                    }
                }
            }
            //結果の表示
            System.out.println(max);
        }
        sc.close();
    }
}
