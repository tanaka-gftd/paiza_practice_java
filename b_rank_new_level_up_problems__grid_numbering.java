//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__grid_numbering

/* 自分で解いたコード */
/* これで正解 */
/* 斜め方向の処理に関しては、模範解答よりも上手くできたかも */

/*
    問題：
    マップの行数 H と列数 W とナンバリングの向き D が与えられるので、
    (0, 0) から指示通りにナンバリングしたとき、マップ全体にどのように番号が振られるかを出力してください。

    D=1...左下から右上への方向
    D=2...左から右への横方向
    D=3...上から下方向への縦方向
    D=4...右上から左下への斜め方向
*/

import java.util.*;
public class b_rank_new_level_up_problems__grid_numbering {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int d = sc.nextInt();
        
        int[][] array = new int[h][w];
        
        int a = 1;
        
        //ifやelse ifで書いてしまったが、switch文の方がわかりやすいと思われる
        if (d == 1){
            /* 
                左下から右上への斜め方向に関しては、
                斜め一列の各座標は、縦座標+横座標 の値が一致している。
                この一致した値を変数sumとし、ループで処理していく。
            */
            for(int sum = 0; sum <= h + w - 2; sum++){
                for(int j = 0; j < w; j++){
                    
                    //次の斜め一列へと移る
                    if(sum - j < 0){
                        break;
                    }
                    
                    //範囲外の座標をマッピングしないようにする
                    if(sum - j > h - 1){
                        continue;
                    }
                    
                    array[sum-j][j] = a;
                    a++;
                }
            }
            
        } else if (d == 2){
            //左から右への縦方向
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    array[i][j] = a;
                    a++;
                }
            }
            
        } else if (d == 3){
            //上から下への縦方向
            for(int i = 0; i < w; i++){
                for(int j = 0; j < h; j++){
                    array[j][i] = a;
                    a++;
                }
            }
            
        } else {
            /* 
                右上から左下への斜め方向に関しても、
                斜め一列の各座標は、縦座標+横座標 の値が一致している。
                この一致した値を変数sumとし、ループで処理していく。

                基本的には、左下から右上への斜め方向の処理と同じ(縦と横が入れ替わっただけ)
            */
            for(int sum = 0; sum <= h + w - 2; sum++){
                for(int j = 0; j < h; j++){
                    
                    if(sum - j < 0){
                        break;
                    }
                    
                    if(sum - j > w - 1){
                        continue;
                    }
                    
                    array[j][sum-j] = a;
                    a++;
                }
            }
        }
        
        //結果を表示していく
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                System.out.print(array[i][j]);
                if(j == w-1){
                    System.out.println();
                }else{
                    System.out.print(" ");
                }
            }
        }

        sc.close();
    }
}