//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__super_long_int

/* 
    自分で解いたコード。
    流石に、これは簡単。
*/

/*
    問題：
    整数型が用意されている言語では、int や long int といった型を用いて数値を保持することが多いです。
    しかし、これらの型は扱える値の上限が 10^10 程度にされていることが多いです。
    そこで paiza 君は新たに 32 桁の数字を受け取ることができる型 super long int を定義することにしました。
    また super long int 型の値 X から int 型のハッシュ値を求める関数 hash(X) を次の通り定義しました。
        •hash(X) = X を 8 桁ずつに区切って得られる 4 つの 8 桁の数字の和

    super long int 型の値 X が与えられるので、hash(X) の値を求めてください。
*/

import java.util.*;
public class b_rank_new_level_up_problems__super_long_int {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        int[] array = new int[4];
        int sum = 0;
        
        for(int i = 0; i < 4; i++){
            String str = line.substring((0 + i * 8), (i + 1) * 8);
            array[i] = Integer.parseInt(str);
        }
        
        for(int n: array){
            sum += n;
        }
        
        System.out.println(sum);

        sc.close();
    }
}
