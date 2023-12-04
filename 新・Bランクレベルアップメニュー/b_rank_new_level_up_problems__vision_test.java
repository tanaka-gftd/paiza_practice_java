//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__vision_test

/*
    これで正解。
    ただ、swith文による条件分岐が冗長である。
    どの分岐でも同じ処理を行うのであれば、関数として切り出した方がいい。
*/

/*
    問題：
    定期検診の一環として視力検査をおこなうことになりました。
    そこで、保健委員の paiza 君はクラスの視力検査の手伝いをすることになりました。
    視力検査の概要は次の通りです。

    ・視力を良い方から順に A, B, C, D, E の 5 段階で判定します。
    ・各段階の視力であることを検査するためのテスト TA, TB, TC, TD が用意されており、
        paiza 君がこれらのうちのいずれかを被験者に見せ、被験者が正しく解答した場合を「成功」、正しく解答できなかった場合を「失敗」とします。
    ・同じ段階のテストに 2 回失敗する前に 2 回成功した場合、その段階について「合格」、それ以外の場合を「不合格」とします。
    ・合格した段階のうち、最も良い段階をその被験者の視力として判定します。
    ・どのレベルのテストにも合格しなかった場合、被験者の視力は E として扱います。

    ある被験者に対しておこなったテストとその結果が与えられるので、被験者の視力を判定してください。
*/

import java.util.*;

public class b_rank_new_level_up_problems__vision_test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int kensakaisu = sc.nextInt();
        int[] success = new int[4];
        int[] failed = new int[4];
        
        String[] level = {"A", "B", "C", "D"};
        
        boolean[] result = new boolean[4];
        Arrays.fill(result, false);
        
        for(int i = 0; i < kensakaisu; i++){
            String t = sc.next();
            String okOrNg = sc.next();
            
            /* 
                switch文エリアでは、どの分岐においても同じような処理を行なっているので、この処理は関数として別に切り出した方がいい
            */
            switch (t) {
                case "TA":
                    if (okOrNg.equals("ok")){
                        success[0] += 1;
                        if(success[0] == 2 && failed[0] < 2){
                            result[0] = true;
                        }
                    } else {
                        failed[0] += 1;
                    }
                break;
                
                case "TB":
                    if (okOrNg.equals("ok")){
                        success[1] += 1;
                        if(success[1] == 2 && failed[1] < 2){
                            result[1] = true;
                        }
                    } else {
                        failed[1] += 1;
                    }
                break;
                
                case "TC":
                    if (okOrNg.equals("ok")){
                        success[2] += 1;
                        if(success[2] == 2 && failed[2] < 2){
                            result[2] = true;
                        }
                    } else {
                        failed[2] += 1;
                    }
                break;
                
                case "TD":
                    if (okOrNg.equals("ok")){
                        success[3] += 1;
                        if(success[3] == 2 && failed[3] < 2){
                            result[3] = true;
                        }
                    } else {
                        failed[3] += 1;
                    }
                break;
            }
        }
        
        for(int i = 0; i <= 3; i++){
            if (result[i]){
                System.out.println(level[i]);
                return;
            }
        }
        
        System.out.println("E");

        sc.close();
    }
}