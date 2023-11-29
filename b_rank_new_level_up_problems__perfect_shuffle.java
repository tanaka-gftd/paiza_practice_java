//問題文URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__perfect_shuffle

/*
    問題：
    トランプのシャッフルの種類の一つにパーフェクトシャッフルというものがあり、
    パーフェクトシャッフルにおける 1 回のシャッフルは次の一連の操作を指します。

    1. 全52枚の山札を上半分と下半分に分ける。
    2. 下半分の一番下のカード, 上半分の一番下のカード, 下半分の下から 2 番目のカード, 上半分の下から 2 番目のカード, ... , 下半分の一番上のカード, 上半分の一番上のカード という順番でカードを積み重ねていく。

    トランプの絵柄をS(スペード), H(ハート), D(ダイア), C(クラブ) と表現するものとし、
    その絵柄の 1 からキングまでの各カードを S_1 , ... , S_13 のように表現するものとします。

    上から S_1, ... , S_13, H_1, ... , H_13, D_1, ... , D_13, C_1, ... , C_13 という順のトランプの山札を用いてパーフェクトシャッフルの操作を K 回おこなった後の山札のカードを上から順に出力してください。

    カードの出力には {絵柄のアルファベット}_{カードの数字} の表現法を用いてください。
*/

import java.util.*;
public class b_rank_new_level_up_problems__perfect_shuffle {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        List<String> list = new ArrayList<String>();
        List<String> list_tmp = new ArrayList<String>();
        
        for(int i = 0; i<4; i++){
            String str = "";
            
            switch (i){
                case 0:
                    str += "S_";
                    break;
                case 1:
                    str += "H_";
                    break;
                case 2:
                    str += "D_";
                    break;
                case 3:
                    str += "C_";
                    break;
            }
            
            for(int j = 0; j<13; j++){
                int num = j + 1;
                String value = str + num;
                list.add(value);
            }
        }


        for(int i = 0; i<n; i++){
            for(int j = 0; j<52; j++){
                if(j%2==0){
                    String tmp =list.get(j/2);
                    list_tmp.add(tmp);
                }else{
                    String tmp =list.get((j-1)/2+26);
                    list_tmp.add(tmp);
                }
            }
            
            list.clear();
            
            for(String v : list_tmp){
                list.add(v);
            }
            
            list_tmp.clear();
        }

        
        for(String v : list){
            System.out.println(v);
        }

        sc.close();
    }
}

