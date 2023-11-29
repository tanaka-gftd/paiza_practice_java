//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__get_row_col

/* 自分で解いたコード */
/* この内容で正解だが、斜め方向の座標の求め方が冗長である */

/*
    問題：
    マップの行数 H と列数 W とマップを表す H 行 W 列の文字列 S_1 ... S_H と y , x 座標 が与えられるので、
    与えられた座標のマス(y, x) と、 (y, x) と同じ縦・横・斜めの列に存在する全てのマスについて次の処理をおこなった後の盤面を出力してください。

    マスに書かれている文字が "." の場合は "#" に、"#" の場合は "." に書き換える。

    なお、マスの座標系は左上端のマスの座標を ( y , x ) = ( 0 , 0 ) とし、
    下方向が y 座標の正の向き、右方向が x 座標の正の向きとします。
    マス(y,x) と同じ斜めの列とは整数 a を用いて (y+a,x+a), (y+a,x-a), (y-a,x-a), (y-a,x+a) のいずれかで表されるマスの集合です。
*/

import java.util.*;
public class b_rank_new_level_up_problems__get_row_col {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        
        char[][] array = new char[h][w];
        
        //入力された文字列をchar型にして、二重配列に保存
        for(int i = 0; i < h; i++){
            String str = sc.next();
            for(int j = 0; j < w; j++){
                array[i][j] =  str.charAt(j);
            }
        }
        
        //指定された座標
        int h_fix = sc.nextInt();
        int w_fix = sc.nextInt();
        
        //斜め座標の算定に使用する(for文でループ)
        //問題文より、入力されるhとwの最大値に、念の為+1しておく
        int limit = 20 + 1;
        
        //指定された座標の文字を含め、指定された座標と同じ横一列の文字を切り替え
        for(int i = 0; i < h; i++){
            if(array[i][w_fix] == '#'){
                array[i][w_fix] = '.';
            }else{
                array[i][w_fix] = '#';
            }
        }
        
        //指定された座標と同じ縦一列を、文字切り替え
        for(int i = 0; i < w; i++){
            
            //指定された座標自体は、すでに切り替え済みなので除外
            if(i == w_fix){
                continue;
            }
            
            if(array[h_fix][i] == '#'){
                array[h_fix][i] = '.';
            }else{
                array[h_fix][i] = '#';
            }
        }
        
        //指定された座標から、右斜め下
        for(int i = 1; i < limit; i++){
            
            //端まで到達したらbreakしてループ終了
            //他の斜め座標でも同様の処理をする
            if((h_fix + i == h)||(w_fix + i == w)){
                break;
            }
            
            if(array[h_fix + i][w_fix + i] == '#'){
                array[h_fix + i][w_fix + i] = '.'; 
            }else{
                array[h_fix + i][w_fix + i] = '#'; 
            }
        }
        
        //指定された座標から、左斜め下
        for(int i = 1; i < limit; i++){
            
            if((h_fix + i == h)||(w_fix - i < 0)){
                break;
            }
            
            if(array[h_fix + i][w_fix - i] == '#'){
                array[h_fix + i][w_fix - i] = '.'; 
            }else{
                array[h_fix + i][w_fix - i] = '#'; 
            }
        }
        
        //指定された座標から、右斜め上
        for(int i = 1; i < limit; i++){
            
            if((h_fix - i < 0)||(w_fix + i == w)){
                break;
            }
            
            if(array[h_fix - i][w_fix + i] == '#'){
                array[h_fix - i][w_fix + i] = '.'; 
            }else{
                array[h_fix - i][w_fix + i] = '#'; 
            }
        }
        
        //指定された座標から、左斜め上
        for(int i = 1; i < limit; i++){
            
            if((h_fix - i < 0)||(w_fix - i < 0)){
                break;
            }
            
            if(array[h_fix - i][w_fix - i] == '#'){
                array[h_fix - i][w_fix - i] = '.'; 
            }else{
                array[h_fix - i][w_fix - i] = '#'; 
            }
        }
        
        //表示していく
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}