//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__similar_randamize

/* 
    これで正解。
    桁数が多くオーバーフローするので、BigIntegerクラスを使用した。

    正解ではあるが、もっと他のやり方を考えるべきである。
*/

/* 
    問題：
    指定した範囲内の値を一様ランダムに出力する装置を乱数生成機といい、出力された数値を乱数といいます。
    この乱数は乱択アルゴリズムなどで利用されており、IT の分野で大きな役割を果たしています。
    この乱数を手元で再現する方法として疑似乱数というものがあります。
    この疑似乱数は、乱数を得る代わりに事前に用意しておいた計算式の結果を乱数として採用するというものです。

    この問題では試しに以下のような計算式によって定められた疑似乱数生成機を用いて、乱数を N 個(rnd_1, ..., rnd_N)生成してみましょう。

    rnd_i = (X^i + X^{i-1} ... + X^1) mod M
*/


import java.util.*;
import java.math.BigInteger;

public class b_rank_new_level_up_problems__similar_randamize {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        BigInteger m_biginteger = BigInteger.valueOf(m);
        
        for(int i = 0; i<n; i++){
            
            String[] array = new String[i+1];
            
            for(int j = 0; j<array.length; j++){
                BigInteger x_bigInteger = BigInteger.valueOf(x);
                BigInteger b = x_bigInteger.pow(j+1);
                String b_string = b.toString();
                array[j] = b_string;
            }
            
            int sum = 0;
            BigInteger sum_biginteger = BigInteger.valueOf(sum);
            
            for(int j = 0; j<array.length; j++){
                BigInteger b = new BigInteger(array[j]);
                sum_biginteger = sum_biginteger.add(b);
            }
            
            System.out.println(sum_biginteger.remainder(m_biginteger));
        }

        sc.close();
    }
}
