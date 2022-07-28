import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int x;
    int y;
    int accCost;

    public Point(int y, int x, int accCost) {
        this.x = x;
        this.y = y;
        this.accCost = accCost;
    }

    @Override
    public int compareTo(Point target) {
        return accCost < target.accCost ? -1 : 1;
    }

}

public class Main {
    // 6 : 20
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1}; // 좌 우 상 하
    public static int[][] map;
    public static int[][] processed, dist;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        int x, y;
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        processed = new int[N][N];
        dist = new int[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        processed[y][x] = 1;
        dist[y][x] = map[y][x];
        pq.add(new Point(y, x, map[y][x]));

        while (!pq.isEmpty()) {
            Point now = pq.poll();

            for (int i = 0; i < 4; i++) {
                int[] next = new int[]{now.y + dy[i], now.x + dx[i]};
                if (next[0] < 0 || next[0] >= N ||
                        next[1] < 0 || next[1] >= N ||
                        map[next[0]][next[1]] == -1 ||
                        processed[next[0]][next[1]] == 1) continue;

                processed[next[0]][next[1]] = 1;
                if (dist[next[0]][next[1]] > now.accCost + map[next[0]][next[1]]) {
                    dist[next[0]][next[1]] = now.accCost + map[next[0]][next[1]];
                    if (max < dist[next[0]][next[1]]) max = dist[next[0]][next[1]];
                    pq.add(new Point(next[0], next[1], dist[next[0]][next[1]]));
                }
            }
        }

        System.out.print(max);
    }
}
