/* 自分で解いてみたもの */
/* スパチャ額の合計が同じだったユーザーについての処理(同じ金額ならユーザー名を辞書順降順にする)がうまくいかず、断念 */

import java.util.*;
public class query_primer_vtuber_NG {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int event = sc.nextInt();
        
        //メンバーシップを保持するセット
        //TreeSetなので、自動で昇順にソート
        Set<String> memberSet = new TreeSet<>();
        
        //スパチャを保持するMap
        Map<String, Integer> superChatMap = new TreeMap<>(Collections.reverseOrder());
        
        for(int i = 0; i<event; i++){
            String name = sc.next();
            String eventName = sc.next();
            
            if(eventName.equals("join")){
                
                memberSet.add(name);
                String sakujyo = sc.next();  //入力された文字列のうち、"membership!"部分は取得するだけで、何もせず
                
            } else if(eventName.equals("give")){
                
                int amount = sc.nextInt();
                String sakujyo = sc.next();  //入力された文字列のうち、"!"部分は取得するだけで、何もせず
                
                if(superChatMap.containsKey(name)){
                    int amount_sum = superChatMap.get(name);
                    superChatMap.put(name, amount + amount_sum);
                } else {
                    superChatMap.put(name, amount);
                }
            }
        }
        
        //スパチャ額でソートできるよう、スパチャを保持するMapのkeyとvalueを入れ替えたMapを用意
        //TreeMapなので、自動でソート（引数で降順に変更）
        Map<Integer, String> superChatMap_2 = new TreeMap<>(Collections.reverseOrder());
        
        //スパチャを保持するMapをもとに、keyとvalueを入れ替えたMapを作成する
        //スパチャ額でソートできるよう{スパチャの合計金額->ユーザー名}としたい <---------NG!
        /* 
          これはNG

          このやり方だと、スパチャ額の合計が同じユーザーがいた場合、後から追加されたユーザーが上書きしてしまう。
          (Mapが保持できるKeyは一意であり、同じKeyでputすると上書きされる)
        */
        for(Map.Entry<String, Integer> entry : superChatMap.entrySet()){
            superChatMap_2.put(entry.getValue(), entry.getKey());
        }
        
        //スパチャを送ったユーザーを表示
        for(Map.Entry<Integer, String> entry : superChatMap_2.entrySet()){
            System.out.println(entry.getValue());
        }
        
        //メンバーシップ加入者を表示
        for(String member : memberSet){
            System.out.println(member);
        }
        
        sc.close();
    }
}