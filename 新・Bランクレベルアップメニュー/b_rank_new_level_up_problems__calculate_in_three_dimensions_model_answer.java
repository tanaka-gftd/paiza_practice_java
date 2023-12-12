//問題URL：https://paiza.jp/works/mondai/b_rank_new_level_up_problems/b_rank_new_level_up_problems__calculate_in_three_dimensions

/* 模範解答 */

/* 
    問題：
    N × N × N の三次元配列が与えられるので、N 要素からなる縦列・横列・斜め列の和のうち、最大値を求めてください。
    斜め列については、配列を立方体に見立てたときに各面を通るような斜め列と対角線のような斜め列が存在することに注意してください。
*/

/* 
    解説：
    縦列・横列・斜め列の和を全て求めてそれらの最大値を求めましょう。
    和を求める際にどの列・行を扱っているかわからなくなったら、インデックスの値を出力したり、配列の小さいケースを用いてデバッグするなどしましょう。
    三次元以上の配列は入力から構造をイメージしにくいことが多いため、手書きで立体的な配列を書いて試してみるのも良いでしょう。
*/

import java.util.*;

public class b_rank_new_level_up_problems__calculate_in_three_dimensions_model_answer {
    public static void main(String... args) {
        
        var sc = new Scanner(System.in);
        
        var N = sc.nextInt();
        
        var ans = 0;
        var A = new int[100][100][100];

        for (var i = 0; i < N; i++) {
            for (var j = 0; j < N; j++) {
                for (var k = 0; k < N; k++) {
                    A[i][j][k] = sc.nextInt();
                }
            }
        }

        for (var x = 0; x < N; x++) {
            for (var i = 0; i < N; i++) {
                var rowSum = 0;
                for (var j = 0; j < N; j++) {
                    rowSum += A[x][i][j];
                }
                ans = Math.max(rowSum, ans);
            }
        }

        for (var y = 0; y < N; y++) {
            for (var i = 0; i < N; i++) {
                var rowSum = 0;
                var colSum = 0;
                for (int j = 0; j < N; j++) {
                    rowSum += A[i][y][j];
                    colSum += A[j][y][i];
                }
                ans = Math.max(Math.max(rowSum, colSum), ans);
            }
        }

        for (var z = 0; z < N; z++) {
            for (var i = 0; i < N; i++) {
                var rowSum = 0;
                var colSum = 0;
                for (var j = 0; j < N; j++) {
                    rowSum += A[i][j][z];
                    colSum += A[j][i][z];
                }
                ans = Math.max(Math.max(rowSum, colSum), ans);
            }
        }

        for (var x = 0; x < N; x++) {
            var leftRightDown = 0;
            var leftRightUp = 0;
            for (var i = 0; i < N; i++) {
                leftRightDown += A[x][i][i];
                leftRightUp += A[x][N - 1 - i][i];
            }
            ans = Math.max(Math.max(leftRightDown, leftRightUp), ans);
        }

        for (var y = 0; y < N; y++) {
            var leftRightDown = 0;
            var leftRightUp = 0;
            for (var i = 0; i < N; i++) {
                leftRightDown += A[i][y][i];
                leftRightUp += A[N - 1 - i][y][i];
            }
            ans = Math.max(Math.max(leftRightDown, leftRightUp), ans);
        }

        for (var z = 0; z < N; z++) {
            var leftRightDown = 0;
            var leftRightUp = 0;
            for (var i = 0; i < N; i++) {
                leftRightDown += A[i][i][z];
                leftRightUp += A[i][N - 1 - i][z];
            }
            ans = Math.max(Math.max(leftRightDown, leftRightUp), ans);
        }

        var l1 = 0;
        var l2 = 0;
        var l3 = 0;
        var l4 = 0;

        for (var i = 0; i < N; i++) {
            l1 += A[i][i][i];
            l2 += A[i][N - 1 - i][N - 1 - i];
            l3 += A[i][N - 1 - i][i];
            l4 += A[i][i][N - 1 - i];
        }

        ans = Math.max(Math.max(Math.max(Math.max(ans, l1), l2), l3), l4);

        System.out.println(ans);
    }
}
