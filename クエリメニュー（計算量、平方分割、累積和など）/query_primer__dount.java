//問題URL：https://paiza.jp/works/mondai/query_primer/query_primer__dount

import java.util.*;
public class query_primer__dount {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int q = sc.nextInt();

        //枠ごとのチョコレートの数を保存する二次元配列
        int[][] chocoArray = new int[h][w];
        
        /*
          本問は区間和の問題
          なので、計算量を減らすため、内側の配列には、その要素までの和を保管しておく
        */
        for(int i = 0; i<h; i++){
            int sum = 0;
            for(int j = 0; j<w; j++){
                sum += sc.nextInt();
                chocoArray[i][j] = sum;
            }
        }
        
        for(int i = 0; i<q; i++){
            int center_h_index = sc.nextInt() - 1;
            int center_w_index = sc.nextInt() - 1;
            
            int outer_diameter = sc.nextInt();
            int inner_diameter = sc.nextInt();
            
            //ドーナッツ全体や穴部分の座標を求めるのに使用
            int diff_inner = (inner_diameter - 1) /2;  //穴部分の座標を求めるのに使用
            int diff_outer = (outer_diameter - 1) /2;  //ドーナッツ全体の座標を求めるのに使用
            
            //切り取る生地に含まれるチョコレートの和（穴の部分を含める）を求めるのに使用
            int all = 0; 
            int all_leftSide = 0;
            
            //ドーナツの穴部分として切り落とすチョコレートの和を求めるのに使用
            int hole = 0;
            int hole_leftSide = 0;
            
            for(int j = center_h_index - diff_outer; j<= center_h_index + diff_outer; j++){
                all += chocoArray[j][center_w_index + diff_outer];
            }
            
            if(center_w_index - diff_outer!=0){
                for(int j = center_h_index - diff_outer; j<= center_h_index + diff_outer; j++){
                    all_leftSide += chocoArray[j][center_w_index - diff_outer - 1];
                }
            }
            
            //切り取る生地に含まれるチョコレートの和（穴の部分を含める）
            all -= all_leftSide;
            
            for(int j = center_h_index - diff_inner; j<= center_h_index + diff_inner; j++){
                hole += chocoArray[j][center_w_index + diff_inner];
            }
            
            for(int j = center_h_index - diff_inner; j<= center_h_index + diff_inner; j++){
                hole_leftSide += chocoArray[j][center_w_index - diff_inner - 1];
            }
            
            //ドーナツの穴部分のチョコレートの和
            hole -= hole_leftSide;
            
            System.out.println(all - hole);
        }
        sc.close();
    }
}
