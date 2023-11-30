//問題URL：https://paiza.jp/works/mondai/query_primer/query_primer__two_dimensions_interval_sum

/* 二次元区間和問題 */
/* ちゃんと解けました */
/* どこの区間の和なのか、どの部分を引くのか、実際に図に書き出してみるとわかりやすい */

import java.util.*;
public class query_primer__two_dimensions_interval_sum {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int query = sc.nextInt();
    
        int[][] array = new int[h][w];
        
        /* 
          計算量を減らすために横一列に関しては、その要素までの和を挿入しておく。

          (例)
          入力された値が
          1, 2, 3, 4, 5, 6, 7, 8, 9
          2, 4, 6, 8, 10, 12, 14, 16, 18
          3, 6, 9, 12, 15, 18, 21, 24, 27
          なら、
          2次元配列に挿入するのは
          1, 3, 6, 10, 15, 21, 28, 36, 45
          2, 6, 12, 20, 30, 42, 56, 72, 90
          3, 9, 18, 30, 45, 63, 84, 108, 135
          としておく
        */
        for(int i = 0; i<h; i++){
            for(int j = 0; j<w; j++){
                if(j==0){
                    array[i][j] = sc.nextInt();
                }else{
                    //上記の説明通り、和を挿入していく
                    array[i][j] = sc.nextInt() + array[i][j - 1];
                }
            }
        }
        
        for(int i = 0; i<query; i++){
            
            int begin_h = sc.nextInt() - 1;
            int begin_w = sc.nextInt() - 1;
            int end_h = sc.nextInt() - 1;
            int end_w = sc.nextInt() - 1;
            
            int result = 0;
            int minus = 0;


            /* 
              解答すべき区間和の範囲は、
              array[begin_h][begin_w]....array[begin_h][end_w]
                      :                            :
                      :                            :
              array[end_h][begin_w]......array[end_h][end_w]
            */

            
            /*
              まずは、
              array[begin_h][0]....array[begin_h][end_w]
                      :                       :
                      :                       :
              array[end_h][0]......array[end_h][end_w]
              の区間和を求める
            */
            for(int j = begin_h; j<=end_h; j++){
                result += array[j][end_w];
            }

            /*
              次に、
              array[begin_h][0]....array[begin_h][begin_w - 1]
                      :                       :
                      :                       :
              array[end_h][0]......array[end_h][begin_w - 1]
              の区間和を求める
            */
            if(begin_w!=0){  //begin_w==0の時はこの処理は不要(minusは0のまま)
                for(int k = begin_h; k<=end_h; k++){
                    minus += array[k][begin_w-1];
                }  
            }

            /*
              array[begin_h][0]....array[begin_h][end_w]
                      :                       :
                      :                       :
              array[end_h][0]......array[end_h][end_w]
              の区間和から、

              array[begin_h][0]....array[begin_h][begin_w - 1]
                      :                       :
                      :                       :
              array[end_h][0]......array[end_h][begin_w - 1]
              の区間和を差し引けば、

              解答となる、
              array[begin_h][begin_w]....array[begin_h][end_w]
                      :                            :
                      :                            :
              array[end_h][begin_w]......array[end_h][end_w]
              の区間和が求められる
            */
            System.out.println(result - minus);
        }
        sc.close();
    }
}