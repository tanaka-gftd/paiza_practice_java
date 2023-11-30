//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__fuel_economy

/*
    問題：
    一般的な車では、車が止まった状態から発進する際は燃費がよくないことが知られています。
    このことを知った paiza 君は発進時とそれ以外での燃費を分けて考えることで実際の燃費を求めたいと考えました。

    具体的には、発進から X m 走るまでは 1 m あたり燃料が F_1 ml, 
    発進から X m 走った後から止まるまでは 1 m あたり燃料が F_2 ml かかります。
    途中、出発地点から s_1(m), ..., s_N(m) の地点で一時停止をしながら全長 L m を走ると、全体を通して必要な燃料は何 ml になるでしょうか？

    なお、停車中の燃料の消費や燃料切れについては考えないものとします。
*/

import java.util.*;
public class b_rank_new_level_up_problems__fuel_economy {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //桁数が多いので、本問ではlong型を使用
        long x = sc.nextLong();
        
        //走り始めてからxメートル進むまでの、1メートルあたりの消費燃料
        long f_1 = sc.nextLong();
        
        //xメートル進んだ後の、1メートルあたりの消費燃料
        //値の大小は、f_1 >= f_2
        long f_2 = sc.nextLong();
        
        long zentyou = sc.nextLong();
        int teisya = sc.nextInt();
        
        long result = 0;
        
        //停車位置を保存する配列
        long[] teisyaArray = new long[teisya + 1];

        //一番最初も、停車から進み始めるので、開始位置も停車位置とみなす
        teisyaArray[0] = 0;
        
        for(int i = 1; i < teisyaArray.length; i++){
            teisyaArray[i] = sc.nextInt();    
        }

        /* 
            1. まず、全ての距離を、f_2の燃費で走ったと仮定した場合の燃料消費量を求める。
                ↓
            2. 次にf_1の燃費で走った距離を求める。
                ↓
            3. f_1 >= f_2なので、1で求めた値に、f_1の燃費で走った距離 * (f_1とf_2の燃費差) を加える。(置き換えていくイメージ)
        */
        
        //全ての距離を、f_2の燃費で走ったと仮定した場合の燃料消費量
        result += zentyou * f_2;
        
        //全体のうち、実際にf_1の燃費で走った距離
        int f_1_kyori = 0;
        
        //f_1の燃費で走った距離を求める
        for(int i = 0; i < teisyaArray.length; i++){
            
            //停車位置が、前後の停車位置や目的地と間隔が狭い(x以下)を想定して、それぞれif文で計算する
            if(i == teisyaArray.length - 1){
                //最後の停車位置と目的地の間がxメートル以下か、そうでないか
                if(zentyou - teisyaArray[teisya] < x){
                    f_1_kyori += zentyou - teisyaArray[teisya];
                } else {
                    f_1_kyori += x;
                }
            } else {
                //停車位置と次の停車位置の間がxメートル以下か、そうでないか
                if(teisyaArray[i + 1] - teisyaArray[i] < x){
                    f_1_kyori += teisyaArray[i + 1] - teisyaArray[i];
                } else {
                    f_1_kyori += x;
                }
            }
        }
        
        /*
            全ての距離をf_2の燃費で走ったと仮定した場合の燃料消費量に、
            f_1の燃費で走った距離 * (f_1とf_2の燃費差) を加えることで、
            実際の燃料消費量を求めることができる。
        */
        result += (f_1 - f_2) * f_1_kyori;
        
        System.out.println(result);

        sc.close();
    }
}