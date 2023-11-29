//問題URL：//問題URL：https://paiza.jp/works/mondai/query_primer/query_primer__vtuber/

/* 模範回答 https://www.youtube.com/watch?v=J4wB_eg9oyk より */

import java.util.*;

/*
  元のコードでは、public class Main となっているが、
  publicクラスはクラス名と同名のファイルに記述しなければならないので、
  クラス名をquery_primer_vtuberに変更しておく。
  （ファイル名は中身がわかりやすいよう、命名）
*/
public class query_primer_vtuber {  
    
    //スパチャを送ってくれた人のクラスを作成
    /*
      implements Comparable<導入したいクラス名> とすることで、
      Comparableインターフェースで定義されたcompareToメソッドを使用できるようになる。

      ComparableインターフェースのcompareToメソッド
          自分で作ったクラスのオブジェクト同士の比較する場合、
          何をもって大小とするかを定義する。
    */
    static class SuperchatPerson implements Comparable<SuperchatPerson>{
        String name;
        int money;
        
        SuperchatPerson(String name, int money){
            this.name = name;
            this.money = money;
        }
        
        /*
          ソートのためのルールを作る。
          compareToメソッドをオーバーライドすることで、
          大小関係について独自のルールを設定する。
        */
        @Override public int compareTo(SuperchatPerson that){
            if(this.money != that.money){
                return -(this.money - that.money);
            } else {
                return -this.name.compareTo(that.name);
            }
        }
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
          ここを、int event = sc.nextInt() とすると、
          以降の sc.nextLine() でエラーが出る。
          ↓
          next() や nextInt() は区切り文字(デフォルトは半角スペース)ごとに取得するのに対し、
          nextLine() は行単位で取得するので、
          片方に統一した方が無難。

          なお、extLine()は文字列での取得なので、ここでは Integer.parseInt で数値化しておく必要がある。
        */
        int event = Integer.parseInt(sc.nextLine());
        
        //アカウント名とSuperchatPersonクラスのインスタンスを、Mapで紐づける
        HashMap<String, SuperchatPerson> superchatPersonMap = new HashMap<>();

        //メンシ加入者を保持する
        //昇順で表示するので、TreeSetで保持しておく
        Set<String> membershipSet = new TreeSet<>();
        
        for(int i = 0; i<event; i++){
            String line = sc.nextLine();

            /* 
              入力されるのは、
              •アカウント名 join membership!
              •アカウント名 give 金額 !
              の２パターンなので、
              split(" ")で、文字列を分割しつつ、続く[0]や[1]で、指定した番目の文字列を取得する
            */
            String name = line.split(" ")[0];  //アカウント名取得
            String eventName = line.split(" ")[1];  //イベント名取得
            
            //取得したイベント名のよって、処理を切り分ける
            if(eventName.equals("join")){
                membershipSet.add(name);
                
            } else {
                
                int amount = Integer.parseInt(line.split(" ")[2]);  //スパチャ額取得
                
                if(!superchatPersonMap.containsKey(name)){
                    superchatPersonMap.put(name, new SuperchatPerson(name, 0));
                } 
                superchatPersonMap.get(name).money += amount;
            }
        }
        
        //superchatPersonMapの全てのvalue(SuperchatPersonクラスのインスタンス群)を取り出し、それらをList化する
        var superchatPersonList = new ArrayList<SuperchatPerson>(superchatPersonMap.values());
        
        //ソートする
        //ソートのルールは、SuperchatPersonクラス内のcompareToメソッド内で定義してある
        Collections.sort(superchatPersonList);
        
        //スパチャをくれた人を表示
        for(SuperchatPerson s : superchatPersonList){
            System.out.println(s.name);
        }
        
        //メンバーシップ加入者を表示
        for(String member : membershipSet){
            System.out.println(member);
        }
        
        //最後にclose()しておくのが、Scannerのマナーらしい
        //close()しなくても実行はできるが、VScodeでは注意マークが表示される
        sc.close();
    }
}