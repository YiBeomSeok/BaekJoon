import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] line = new int[100001];
    public static int N, K, count = 0;
    public static int[] dir;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N >= K) {
            System.out.printf("%d\n1", N - K);
            return;
        }

        Arrays.fill(line, -1);
        bfs();
        System.out.printf("%d\n%d", line[K], count);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        line[N] = 0;
        q.add(N);

        // 처음 방문할 때마다 시간을 1씩 더해준다.
        while (!q.isEmpty()) {
            int cur = q.poll();

            if (line[K] != -1 && line[cur] >= line[K]) return;

            dir = new int[]{1, -1, cur};
            for (int i = 0; i < 3; i++) {
                int next = cur + dir[i];
                if (next < 0 || next > 100000) continue;
                if (next == K) count++;

                if (line[next] == -1 || line[next] == line[cur] + 1) {
                    line[next] = line[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}
