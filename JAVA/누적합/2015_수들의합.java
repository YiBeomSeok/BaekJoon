import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n, k;
        long cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] prefix = new int[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();    // 어떤 누적합 S의 개수

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());   // 누적합

            if (prefix[i] == k) cnt++;
        }

        for (int i = 1; i <= n; i++) {
            if (map.containsKey(prefix[i] - k))
                cnt += map.get(prefix[i] - k);

            if (map.containsKey(prefix[i]))
                map.put(prefix[i], map.get(prefix[i]) + 1);
            else
                map.put(prefix[i], 1);
        }

        System.out.println(cnt);
    }
}
