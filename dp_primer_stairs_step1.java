import java.util.*;
public class dp_primer_stairs_step1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        //階段の 0段目からn段目まで、各段への登り方が何通りあるかを格納する配列
        int[] array = new int[n + 1];
        
        //0段目までに登る方法は一通り(何もしないの一択)
        array[0] = 1;
        
        //i段目までの登り方が何通りあるかを求める
        for(int i = 1; i<=n; i++){
            array[i] = 0; 

            if(i>=a){
                array[i] += array[i-a];
            }
            
            if(i>=b){
                array[i] += array[i-b];
            }
        }
        
        System.out.println(array[n]);

        sc.close();
    }
}
