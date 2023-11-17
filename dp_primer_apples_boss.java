/*
  八百屋にて、りんご x 個が a 円で、りんご y 個が b 円で、りんご z 個が c 円で売られています。

  りんごの買い方を工夫したとき、n 個のりんごを手に入れるために必要な金額の最小値はいくらでしょうか。
  なお、買い方を工夫した結果、買ったりんごが n+1 個以上になってもよいものとします。
*/

import java.util.*;
public class dp_primer_apples_boss {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int a = sc.nextInt();
        int y = sc.nextInt();
        int b = sc.nextInt();
        int z = sc.nextInt();
        int c = sc.nextInt();
        
        int[] array = new int[n + z];
        Arrays.fill(array, 10000000);
        
        array[0] = 0;
        
        for(int i = 1; i < n + z; i++){
            if(i>=x){
                array[i] = Math.min(array[i], array[i - x] + a);
            }
            if(i>=y){
                array[i] = Math.min(array[i], array[i - y] + b);
            }
            if(i>=z){
                array[i] = Math.min(array[i], array[i - z] + c);
            }
        }
        
        for(int i = n + z - 2; i>=1; i--){
            array[i] = Math.min(array[i], array[i + 1]);
        }
        
        System.out.println(array[n]);
    }
}