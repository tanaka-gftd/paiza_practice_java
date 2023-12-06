//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__lucky_number

/* 
    自分で解いたコード。
    これで正解。

    数値を加工する処理が冗長気味。
    数値を格納する配列を２重配列にすれば、もっと簡潔にできる。
*/

/*
    問題：    
    有名な占い師である paiza 君は次のようなラッキーナンバーの求め方を提唱しました。

    1. 占い師が N 個の自然数 X_1, ..., X_N を宣言する。

    2. それらから 2 つの自然数を選ぶような全ての組み合わせについて次の操作をおこなう。

        選んだ 2 つの各数字に対して、次のいずれかの操作を 1 回おこなうことができる。各数字について別々の操作をおこなうことができる。（おこなわなくても良い）

        ・その数字を +1 する。ex)25->26

        ・その数字を -1 する。ex)25->24

        ・その数字を、その数字の先頭に 1 をつけた数に置き換える。ex)25>125

        ・その数字を、その数字の末尾に 1 をつけた数に置き換える。ex)25->251

        操作後の 2 つの数の差の絶対値の最小値を求める。

    3. 2で求めることができる値のうち最小の値をラッキーナンバーとする。

    占い師が宣言した自然数 X_1, ..., X_N が与えられるので、試しにこの方法でラッキーナンバーを計算してみましょう。
*/

import java.util.*;
public class b_rank_new_level_up_problems__lucky_number {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        /* これらの配列は、２重配列にすべき*/
        int[] array = new int[n];
        //選び出される2つの数値を格納しておく配列を準備
        int[] a_array = new int[5];
        int[] b_array = new int[5];

        //問題文より、とりうる最大値は100000なので、それを初期値として設定
        int result = 100000;
        
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                
                int a = array[i];
                int b = array[j];
                
                /* 数値を加工する処理は共通なので、二重配列にした方がいい */
                a_array[0] = a;
                a_array[1] = a + 1;
                a_array[2] = a - 1;
                
                a_array[3] = Integer.parseInt("1" + a);
                a_array[4] = a * 10 + 1;
                
                b_array[0] = b;
                b_array[1] = b + 1;
                b_array[2] = b - 1;
                
                b_array[3] = Integer.parseInt("1" + b);
                b_array[4] = b * 10 + 1;
                
                for(int k = 0; k < 5; k++){
                    for(int l = 0; l < 5; l++){
                        int diff = a_array[k] - b_array[l];
                        if(diff < 0){
                            diff *= -1;
                        }
                        
                        if(diff < result){
                            result = diff;
                        }
                    }
                }
                
            }
        }
        
        System.out.println(result);

        sc.close();
    }
}
