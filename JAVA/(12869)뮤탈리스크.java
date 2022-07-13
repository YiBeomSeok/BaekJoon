/*
생각 메모

scv[3][61]
[0] {1 ~~~~~ 60}
[1] {1 ~~~~~ 60}
[2] {1 ~~~~~ 60}

0,1,1
0, 10, 12
1012

0, 60, 60

z - 9
if( z < 0 ) z = 0
y - 3
if( y < 0 ) y = 0
x - 1
if( x < 0 ) x = 0

0, 57, 51
정렬?
0, 51, 57

    x, y, z
-   9, 3, 1
-   3, 9, 1
041012
606060
596060
041012 = 4 * 3600 + 10 * 60 + 12
010101 = 1 * 3600 + 1 * 60 + 1
D[xxx] = 2
x, y, z
if(z >= 9)
    z -= 9;
    else
        z = 0;
D[X] = min(D[xyz], D[yxz]);

6060


 */
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int count;
    public static int[] hps = new int[3]; //
    public static int[] dp = new int[60 * 3600 + 60 * 60 + 61];

    public static void main(String[] args) throws IOException {
        count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            hps[i] = Integer.parseInt(st.nextToken());
        } // 입력 끝


        for (int i = 1; i <= 9; i++) {
            dp[i] = 1;
        }

        dp[3 * 60 + 9] = 1;
        dp[10 * 3600 + 3 * 60 + 9] = 1;

        System.out.print(topBottom(hps));
    }

    public static int topBottom(int[] hps) {
    /*
        sort먼저 한다. (오름차순)
        hps를 60진법 수로 생각하고 10진법으로 변환해서 그걸 M이라고 하자.

        hps = {x, y, z}이렇게 되어 있었다면 z > y > x이다.
        어쨌든 가장 큰 수에 첫 타를 날릴 것이라 예상하고 z가 9미만이면 0으로, 9이상이면 -9를 해준다.

        두번째 타는 y 또는 x에 날아간다.

        hps1 = {x - 1, y - 3, z} (위에서 이미 z에 대한 처리를 했으므로)
        마찬가지로 y가 3 미만이면 0으로, x가 1 미만이면 0으로 한다.

        새로운 hps2를 만들어서 다음과 같이 조치를 취한다.
        hps2 = {x - 3, y - 1, z}
        마찬가지로 x가 3 미만이면 0으로, y가 1 미만이면 0으로 한다.

        각각 다시 sort한 다음
        hps1를 10진법 수로 만들어서 그걸 M1이라고 하자.
        hps2를 10진법 수로 만들어서 그걸 M2라고 하자.

        dp[M1]이 있는지 조회하고 없으면
        topBottom(hps1)
        dp[M2]이 있는지 조회하고 없으면
        topBottom(hps2)

        dp[M] = min(dp[M1] + 1, dp[M2] + 1)이다.
        return dp[M];
         */
         
        Arrays.sort(hps);
        if (hps[2] == 0) return 0;

        int M = hps[0] * 3600 + hps[1] * 60 + hps[2];

        int[] hps2 = {hps[0] - 3, hps[1] - 1, hps[2] - 9};
        hps[0] -= 1;
        hps[1] -= 3;
        hps[2] -= 9;


        for (int i = 0; i < 3; i++) {
            if (hps2[i] < 0) hps2[i] = 0;
            if (hps[i] < 0) hps[i] = 0;
        }

        Arrays.sort(hps);
        Arrays.sort(hps2);

        int M1 = hps[0] * 3600 + hps[1] * 60 + hps[2];
        int M2 = hps2[0] * 3600 + hps2[1] * 60 + hps2[2];

        if (dp[M1] == 0)
            topBottom(hps);
        if (dp[M2] == 0)
            topBottom(hps2);

        dp[M] = Math.min(dp[M1] + 1, dp[M2] + 1);
        return dp[M];
    }

}

