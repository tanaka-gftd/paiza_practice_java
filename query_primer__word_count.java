import java.util.*;
public class query_primer__word_count {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int page = sc.nextInt();
        int round = sc.nextInt();
        
        //問題文より、ページ数/3 は整数であるとは限らないとのことなので、doubleにする
        double limit = page / 3.0;
        
        int[] iInPage = new int[page];
        
        for(int i = 0; i<page; i++){
            iInPage[i] = sc.nextInt();
        }
        
        for(int i = 0; i<round; i++){
            int a_begin = sc.nextInt() - 1;
            int a_end = sc.nextInt() - 1;
            int b_begin = sc.nextInt() - 1;
            int b_end = sc.nextInt() - 1;
            
            double a_holdPage = a_end - a_begin + 1;
            double b_holdPage = b_end - b_begin + 1;
            
            //反則負けの判定
            if(a_holdPage>=limit&&b_holdPage>=limit){
                System.out.println("DRAW");
                continue;
            }else if(a_holdPage>=limit){
                System.out.println("B");
                continue;
            }else if(b_holdPage>=limit){
                System.out.println("A");
                continue;
            }
            
            int a_score = 0;
            int b_score = 0;
            
            for(int j = a_begin; j<=a_end; j++){
                a_score += iInPage[j];
            }
            
            for(int j = b_begin; j<=b_end; j++){
                b_score += iInPage[j];
            }
            
            if(a_score>b_score){
                System.out.println("A");
            }else if(a_score<b_score){
                System.out.println("B");
            }else{
                System.out.println("DRAW");
            }
        }
        sc.close();
    }
}