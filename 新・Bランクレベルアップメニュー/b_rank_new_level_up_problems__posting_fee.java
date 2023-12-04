//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__posting_fee

/*
    問題：
    paiza 国の郵便局では 縦 y(cm), 横 x(cm), 高さ h(cm) の荷物を送るのに必要な郵便料金が次のようなルールで決まっています。



    ・高さが l_1 cm 以下の場合

        縦と横の長い方の長さが l_2 以下の場合・・・m_1(円)

        縦と横の長さの和が l_3 以下の場合・・・m_2(円)

        それ以外の場合・・・m_3(円)

    ・それ以外の場合

        縦と横と高さのうち最も長いものの長さが l_4 以下の場合・・・m_4(円)

        縦と横と高さの長さの和が l_5 以下の場合・・・m_5(円)

        それ以外の場合・・・送るものの体積(cm3) × m_6(円)

    判定に必要な定数と送る荷物の縦・横・高さの値が与えられるので、必要な郵便料金を求めてください。

    なお、料金を決めるルールは上に書かれているものから順に判定していくものとします。
    例として、l_1 = l_2 = l_3 = 100, y=50, x=30, h=20 の場合
    ・縦と横の長い方の長さが 100 以下
    ・縦と横の長さの和が 100 以下
    のどちらも満たしますが、上に書かれている
    ・縦と横の長い方の長さが 100 以下
    を採用し、料金は m_1 円となります。
*/

import java.util.*;

public class b_rank_new_level_up_problems__posting_fee {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        int h = sc.nextInt();
        
        /* lとmの各値については、配列で保存した方がいいかも */

        int l_1 = sc.nextInt();
        int l_2 = sc.nextInt();
        int l_3 = sc.nextInt();
        int l_4 = sc.nextInt();
        int l_5 = sc.nextInt();
        
        int m_1 = sc.nextInt();
        int m_2 = sc.nextInt();
        int m_3 = sc.nextInt();
        int m_4 = sc.nextInt();
        int m_5 = sc.nextInt();
        int m_6 = sc.nextInt();
        
        int result = 0;
        
        if (h <= l_1){
            
            if (Math.max(y, x) <= l_2){
                result = m_1;
            } else if (y + x <= l_3){
                result = m_2;
            } else {
                result = m_3;
            }
            
        } else {
            
            if (Math.max(Math.max(y, x), h) <= l_4){
                result = m_4;
            } else if (y + x + h <= l_5){
                result = m_5;
            } else {
                result = m_6 * y * x * h;
            }
        }
        
        System.out.println(result);

        sc.close();
    }
}