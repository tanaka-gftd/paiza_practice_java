//https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__get_richer_sushi

/* 
    自分で書いたコード。
    これで正解。

    模範解答によると、範囲外参照を起こさないようにするためには、剰余を使うといいらしい。
    今回の場合だと、
    P[i] から連続する K 枚を取り出すとき、j = 0, ..., K-1 と遷移するループを用いて P[(i + j) % N] で要素を取得するようにする。
    こうすれば、(i + j) % N の値は j の値が0, ..., K-1 と遷移するとき、i, i+1, ..., N-1, 0, 1,... と遷移して範囲外参照を起こさなくなる。
*/

/*
    問題：
    paiza 君は家族と一緒に回転寿司に来ています。
    回転寿司の円形のレーンには、価格が P_1, ..., P_N の N 枚の寿司が順番に流れています。
    （価格が P_1 の寿司と P_N の寿司は隣接しています。）
    paiza 君は、家族が目を離した隙にレーンから連続した K 枚の寿司をこっそり取って食べてしまおうと考えました。
    paiza 君は普段食べれない高いお寿司を多く食べたいので、取る K 枚の寿司の合計金額ができるだけ高くなるように寿司を取りたいです。
    paiza 君が食べることができる寿司の合計金額の最大値を求めてください。
*/

import java.util.*;

public class b_rank_new_level_up_problems__get_richer_sushi {
    public static void main(String[] args) throws Exception {
        // Your code here!
        
        Scanner sc = new Scanner(System.in);
        int all = sc.nextInt();
        int choice = sc.nextInt();

        //最後の次は、最初にループするので、同じ要素を２回繰り返すような配列を用意する
        int[] price = new int[all * 2];

        int result = 0;
        
        for(int i = 0; i < all; i++){
            price[i] = sc.nextInt();
            //最後の次は、最初にループするので、同じ要素をもう一度繰り返すように、要素を保管する
            price[i + all] = price[i];
        }
        
        for(int i = 0; i < all; i++){
            int sum = 0;
            for(int j = 0; j < choice; j++){
                sum += price[i + j];
            }
            if(sum > result){
                result = sum;
            }
        }
        
        System.out.println(result);

        sc.close();
    }
}
