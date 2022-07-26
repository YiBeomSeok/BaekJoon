import java.io.*;
import java.util.*;

public class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] line = new int[100001];
    public static int N, K, count = 0;
    public static int[] dir, time = {1, 1, 0};
    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(line, -1);
        bfs();

        System.out.println(line[K]);
    }

    public static void bfs() {
        line[N] = 0;
        q.add(N);

        while(!q.isEmpty()) {
            int cur = q.poll();

            dir = new int[]{1, -1, cur};
            for(int i=0; i<3; i++) {
                int next = cur + dir[i];

                if(next < 0 || next > 100000) continue;

                if(line[next] == -1 || line[next] > line[cur] + time[i]) {
                    line[next] = line[cur] + time[i];
                    q.add(next);
                }
            }
        }
    }
}
