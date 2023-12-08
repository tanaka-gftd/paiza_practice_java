//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__calculate_in_two_dimensions

/*  
    自分で解いたコード。
    これで正解。

    模範解答も大体同じ。
*/

/* 
    N × N の二次元配列 A が与えられるので、
    N 要素からなる縦列・横列・斜め列の和のうち、最大のものを求めてください。
*/

import java.util.*;
public class b_rank_new_level_up_problems__calculate_in_two_dimensions {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] array = new int[num][num];
        
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                array[i][j] = sc.nextInt();
            }
        }
        
        //各方向の和を格納するリスト
        List<Integer> list = new ArrayList<Integer>();
        
        //横方向
        for(int i = 0; i < num; i++){
            int s = 0;
            for(int j = 0; j < num; j++){
                s += array[i][j];
            }
            list.add(s);
        }
        
        //縦方向
        for(int i = 0; i < num; i++){
            int s = 0;
            for(int j = 0; j < num; j++){
                s += array[j][i];
            }
            list.add(s);
        }
        
        //斜め方向
        int naname_1 = 0;
        int naname_2 = 0;
        
        for(int i = 0; i < num; i++){
            naname_1 += array[i][i];
        }
        
        for(int i = 0; i < num; i++){
            naname_2 += array[i][num-1-i];
        }
        
        list.add(naname_1);
        list.add(naname_2);
        
        int result = 0;

        //最大のものを見つける
        for(int n : list){
            if(result < n){
                result = n;
            }
        }

        System.out.println(result);

        sc.close();
    }
}
