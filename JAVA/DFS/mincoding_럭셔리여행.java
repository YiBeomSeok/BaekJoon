import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    // 그래프의 인접행렬
    // arr[from][to] = from에서 to로 가는 비용, 갈수 없는 경우 0
    public static int[][] arr = new int[1010][1010];

    public static int[] used = new int[1010];

    public static int N, e, sum = 0; // sum = 현재 경로에 대한 비용 <- 선을 사용할 때마다 누적
    public static int minSum = Integer.MAX_VALUE, maxSum = -1;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int from = 0; from < N; from++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int to = 0; to < N; to++) {
                arr[from][to] = Integer.parseInt(st.nextToken());
            }
        }

        int s;
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        used[s] = 1;
        dfs(s);
        sb.append(minSum).append("\n").append(maxSum);

        System.out.print(sb);
    }

    public static void dfs(int now) {

        // 기저조건(끝에 해당 하는 의미)
        if(now == e) {
            if(sum < minSum) minSum = sum;
            if(sum > maxSum) maxSum = sum;
            return;
        }    // 끝 점이면 더 가볼 필요 없으므로 끝

        // now에서 갈 수 있는 다음 점(next)을 찾아 가도록 만듦
        for (int to = 0; to < N; to++) {
            if(arr[now][to] == 0 || used[to] == 1)
                continue;

            used[to] = 1;
            // now에서 갈 수 있는 점 : to
            sum += arr[now][to];    // now->to로 가는 비용만큼 누적
            dfs(to);
            // 실제 경로와 기록을 일치화 <- 다양한 경로를 만들어 볼 때
            used[to] = 0;   // to로 가는 경로는 취소, 들렸다는 기록을 제거
            sum -= arr[now][to]; // now -> to로 갔던 비용 복구
        }
    }
}
