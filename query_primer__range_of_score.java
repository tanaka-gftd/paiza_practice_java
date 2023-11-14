import java.util.*;
public class query_primer__range_of_score {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int numberOfStudents = sc.nextInt();
        int numberOfMatches = sc.nextInt();
        
        //問題文に設定されている上限（結局使わなかった）
        //double limit = numberOfStudents / 2.0;
        
        //生徒の点数を保存していく配列
        int[] scoreArray = new int[numberOfStudents];
        
        //生徒の点数を配列に保存
        for(int i = 0; i<numberOfStudents; i++){
            scoreArray[i] = sc.nextInt();
        }
        
        //入力された試合数の数だけ繰り返す
        for(int i = 0; i<numberOfMatches; i++){
            int a_begin = sc.nextInt() - 1;
            int a_end = sc.nextInt() - 1;
            int b_begin = sc.nextInt() - 1;
            int b_end = sc.nextInt() - 1;
            
            int a_min = 100000;
            int a_max = 0;
            
            int b_min = 100000;
            int b_max = 0;
            
            //A側が掴み取った最大値と最小値を求める
            for(int j = a_begin; j<=a_end; j++){
                int tmp = scoreArray[j];
                if(tmp>a_max){
                    a_max = tmp;
                }
                if(tmp<a_min){
                    a_min = tmp;
                }
            }
            
            //B側が掴み取った最大値と最小値を求める
            for(int j = b_begin; j<=b_end; j++){
                int tmp = scoreArray[j];
                if(tmp>b_max){
                    b_max = tmp;
                }
                if(tmp<b_min){
                    b_min = tmp;
                }
            }
            
            //AとBのスコアを求める
            int a_score = a_max - a_min;
            int b_score = b_max - b_min;
            
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