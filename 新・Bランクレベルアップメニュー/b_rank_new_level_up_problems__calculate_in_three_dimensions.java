//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__calculate_in_three_dimensions

/* 
    自分で書いたコード。
    これで正解。
*/

/* 
    問題：
    N × N × N の三次元配列が与えられるので、N 要素からなる縦列・横列・斜め列の和のうち、最大値を求めてください。
    斜め列については、配列を立方体に見立てたときに各面を通るような斜め列と対角線のような斜め列が存在することに注意してください。
*/

import java.util.*;

public class b_rank_new_level_up_problems__calculate_in_three_dimensions {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        int[][][] array = new int[num][num][num];
        
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                for(int k = 0; k < num; k++){
                    array[i][j][k] = sc.nextInt();
                }
            }
        }
        
        
        //各方向の和を格納していくリスト
        List<Integer> list = new ArrayList<Integer>();
        
        //手前の面と奥の面について、縦方向と横方向
        for(int i = 0; i<num; i++){
            for(int j = 0; j< num; j++){
                
                int sum_tate = 0;
                int sum_yoko = 0;
                
                for(int k = 0; k<num; k++){
                    sum_tate += array[i][j][k];
                    sum_yoko += array[i][k][j];
                }
                list.add(sum_tate);
                list.add(sum_yoko);
            }
        }
        
        //手前の面と奥の面について、面上の斜め方向
        for(int i = 0; i<num; i++){
            
            int sum_naname_1 = 0;
            int sum_naname_2 = 0;
            
            for(int j = 0; j<num; j++){
                sum_naname_1 += array[i][j][j];
                sum_naname_2 += array[i][num - j -1][j];
            }
            list.add(sum_naname_1);
            list.add(sum_naname_2);
        }
        
        //上面と底面について、縦方向
        //横方向は計算済み
        //以降、[x,y,x]+[a,b,c] は、num=2 の時の、加算すべき三次元配列の座標の組み合わせ
        /*
            [0,0,0]+[1,0,0]
            [0,0,1]+[1,0,1]
            
            [0,1,0]+[1,1,0]
            [0,1,1]+[1,1,1]
        */
        for(int i = 0; i<num; i++){
            for(int j = 0; j<num; j++){
                
                int sum = 0;
                
                for(int k = 0; k<num; k++){
                    sum += array[k][i][j];
                }
                list.add(sum);
            }
        }
        
        //上面と底面について、面上の斜め方向
        /*
          [0,0,0]+[1,0,1]
          [0,0,1]+[1,0,0]
          
          [0,1,0]+[1,1,1]
          [0,1,1]+[1,1,0]
        */
        for(int i = 0; i<num; i++){
            
            int sum_naname_1 = 0;
            int sum_naname_2 = 0;
            
            for(int j = 0; j<num; j++){
                sum_naname_1 += array[j][i][j];
                sum_naname_2 += array[j][i][num - j -1];
            }
            list.add(sum_naname_1);
            list.add(sum_naname_2);
        }
        
        //右側面と左側面について、面上の斜め方向
        //縦方向と横方向は計算済み
        /*
          [0,0,0]+[1,1,0]
          [0,1,0]+[1,0,0]
          
          [0,0,1]+[1,1,1]
          [0,1,1]+[1,0,1]
        */
        for(int i = 0; i < num; i++){
            
            int sum_naname_1 = 0;
            int sum_naname_2 = 0;
            
            for(int j = 0; j<num; j++){
                sum_naname_1 += array[j][j][i];
                sum_naname_2 += array[j][num - j -1][i];
            }
            list.add(sum_naname_1);
            list.add(sum_naname_2);
        }
        
        //面を通らない、頂点同士の対角線の和(計４個)
        /*
          [0,0,0]+[1,1,1]
          [0,0,1]+[1,1,0]
          [0,1,0]+[1,0,1]
          [0,1,1]+[1,0,0]
        */
        int sum_naname_a = 0;
        int sum_naname_b = 0;
        int sum_naname_c = 0;
        int sum_naname_d = 0;
        for(int i = 0, j = num - 1; i < num; i++,j--){
            sum_naname_a += array[i][i][i];
            sum_naname_b += array[i][i][j];
            sum_naname_c += array[i][j][i];
            sum_naname_d += array[i][j][j];
        }
        list.add(sum_naname_a);
        list.add(sum_naname_b);
        list.add(sum_naname_c);
        list.add(sum_naname_d);
        
        int result = 0;
        
        for(int n: list){
            if(result<n){
                result = n;
            }
        }
        
        System.out.println(result);
        sc.close();
    }
}
