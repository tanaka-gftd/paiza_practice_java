//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__leet_paiza

/* 
    自分で解いたコード。
    これで正解。

    Leet表記の判定処理については、改善の余地あり。
*/

/* 
    問題：
    英単語に含まれるアルファベットの一部を形の似た数字や記号で置き換えることを Leet といいます。Leet はパスワードやユーザー名の作成の際に便利な手法の一つです。


    paiza では、エゴサーチを強化するためにツイートの中に Leet 表記された paiza が含まれているかを判定するプログラムを作成することになりました。
    ツイートの文章 S が与えられるので、
    ツイートに "paiza" が含まれる場合は "paiza", 
    "paiza" が含まれず Leet 表記された "paiza" が含まれる場合は "leet", 
    どちらも含まれない場合は "nothing" と出力してください。

    なお、"paiza" の leet 文字列は、"paiza" について以下の置き換えを 1 回以上おこなうことで得られる文字列をさすものとします。

    ・a -> 4 または a -> @
    ・i -> 1 または i -> !
    ・z -> 2
*/

import java.util.*;
public class b_rank_new_level_up_problems__leet_paiza {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        
        //判定結果を格納する
        boolean paiza = false;
        boolean leet = false;
        
        //文字列の先頭から、1文字ずつ判定していく
        //文字列の範囲外をチェックしないよう、カウンタ変数の最大値に注意
        for(int i = 0; i<line.length() - 4; i++){
            
            if(line.charAt(i)=='p'){
                
                //"paiza"の文字列があるか判定
                if(line.substring(i, i+5).equals("paiza")){
                    paiza = true;
                    continue;
                }
                
                //"paiza"をLeet表記した文字列があるか判定
                if(
                    (line.charAt(i + 1)=='a'||line.charAt(i + 1)=='@'||line.charAt(i + 1)=='4')
                    &&
                    (line.charAt(i + 2)=='i'||line.charAt(i + 2)=='1'||line.charAt(i + 2)=='!')
                    &&
                    (line.charAt(i + 3)=='z'||line.charAt(i + 3)=='2')
                    &&
                    (line.charAt(i + 4)=='a'||line.charAt(i + 4)=='@'||line.charAt(i + 4)=='4')
                ){
                    leet = true;
                }
                
            }
        }
        
        //結果を表示
        if(paiza){
            System.out.println("paiza");
        }else if(!paiza&&leet){
            System.out.println("leet");
        }else{
            System.out.println("nothing");
        }

        sc.close();
    }
}
