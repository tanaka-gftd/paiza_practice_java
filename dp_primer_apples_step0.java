import java.util.*;

public class dp_primer_apples_step0 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();

    int[] dp = new int[n + 1];

    Arrays.fill(dp, 10000000);
    dp[0] = 0;
    dp[1] = a;
    for (int i = 2; i <= n; i++) {
      dp[i] = Math.min(dp[i - 1] + a, dp[i - 2] + b);
    }

    System.out.println(dp[n]);

    sc.close();
  }
}
