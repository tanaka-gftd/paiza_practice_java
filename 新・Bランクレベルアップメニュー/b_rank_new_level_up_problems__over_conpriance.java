//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__over_conpriance

/*
    自分で書いたコード。
    これで正解。

    模範回答を見る限り、
    文字列前半一致と後半一致は、substringとequalsの組み合わせで判定し、
    文字列置き換えについては、同じ文字を繰り返すだけなので、repeatを使うと簡潔に書けるようだ。
*/

/*
    問題：
    君主の paiza 国王によって情報統制が厳しくなった paiza 国では、今回新たに使用禁止用語の検閲についての次のような法律ができました。

        今後、放送禁止単語 S と文字数が同じで、前半分または後ろ半分が同じ文字である単語 V を放送する時は、
        放送禁止用語と重なっている部分（前半分または後ろ半分）の文字を全て x で置き換えた単語を放送する。
        また、V が放送禁止用語と完全に一致する場合は V を放送せず、代わりに "banned" と出力する。
    以上、

    放送禁止用語 S と N 個の放送したい単語 V_1, ..., V_N が与えられるので、検閲をおこなった後の V_1, ..., V_N を出力してください。

    例として、S = math, V_1 = main, V_2 = programming, V_3 = memo, V_4 = paiza の場合は、
    検閲後の各単語は xxin, programming, memo, paiza となります。
*/

import java.util.*;

public class b_rank_new_level_up_problems__over_conpriance {
    public static void main(String[] args) throws Exception {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);

        //放送したい単語数
        int numberOfWords = sc.nextInt();

        //放送禁止単語とその文字数を保存
        String ng_word = sc.next();
        int ng_word_length = ng_word.length();
        
        //放送禁止単語の文字列の半分の長さを算出
        //問題文の指定より、放送禁止単語の文字数が奇数の場合は、中央部分の文字も含めた文字数とする
        //前半一致判定、後半一致判定、及び文字列の置き換えで使用
        int half = ng_word_length % 2 == 0 ? ng_word_length / 2: (ng_word_length + 1) / 2;
        
        for(int i = 0; i<numberOfWords; i++){
            String word = sc.next();
            int word_length = word.length();
            
            //放送禁止単語と文字数が同じ場合だけ、一致判定と文字の置き換え処理を行う
            if(ng_word_length == word_length){
                
                //一致判定用
                //初期値はtrueで、後の処理で一致判定を行い、一致していなければfalseとする
                boolean firstHalfMatch = true;
                boolean lastHalfMatch = true;
                
                //放送禁止単語と完全一致
                if(ng_word.equals(word)){
                    System.out.println("banned");
                    continue;
                }
                
                //放送禁止単語と前半部分が一致しているかを判定
                for(int j = 0; j<half; j++){
                    if(ng_word.charAt(j) != word.charAt(j)){
                        firstHalfMatch = false;
                        break;
                    }
                }
                
                //放送禁止単語と後半部分が一致しているかを判定
                //放送しようとした単語が、偶数か奇数かで処理を切り分ける
                for(int j = word_length % 2 == 0 ? half : half - 1; j < word_length; j++){
                    if(ng_word.charAt(j) != word.charAt(j)){
                        lastHalfMatch = false;
                        break;
                    }
                }
                
                //放送禁止単語と前半部分が一致していた場合、一致していた部分をxに置き換え
                if(firstHalfMatch){
                    for(int j = 0; j < half; j++){
                        System.out.print("x");
                    }
                    for(int j = half; j < word_length; j++){
                        System.out.print(word.charAt(j));
                    }
                    System.out.println();
                    continue;
                }
                
                //放送禁止単語と後半部分が一致していた場合、一致していた部分をxに置き換え
                //放送しようとした単語が、偶数か奇数かで処理を切り分ける
                //(比較演算子に三項目式をはめ込む時は、三項目式を括弧で括ること)
                if(lastHalfMatch){
                    for(int j = 0; j < (word_length % 2 == 0? half : half - 1); j++){
                        System.out.print(word.charAt(j));
                    }
                    for(int j = word_length % 2 == 0 ? half : half - 1; j < word_length; j++){
                        System.out.print("x");
                    }
                    System.out.println();
                    continue;
                }
            }

            //放送禁止単語と文字数が違う場合は、そのまま出力
            System.out.println(word);
        }
        sc.close();
    }
}