import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] line = new int[100001], parent = new int[100001];
    public static int N, K, count = 0;
    public static int[] dir;

    public static Queue<Integer> q = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(line, -1);
        bfs();
    }

    public static void bfs() {
        line[N] = 0;
        q.add(N);
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) {
                sb.append(line[cur]).append("\n");
                while (cur != N) {
                    s.push(cur);
                    cur = parent[cur];
                }
                s.push(cur);
                while(!s.isEmpty()) {
                    sb.append(s.pop()).append(" ");
                }
                System.out.print(sb);
                return;
            }
            dir = new int[]{1, -1, cur};

            for (int i = 0; i < 3; i++) {
                int next = cur + dir[i];

                if (next < 0 || next > 100000 || line[next] >= 0) continue;
                line[next] = line[cur] + 1;
                parent[next] = cur;
                q.add(next);

            }
        }
    }
}
