import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int y, x, accCost;

    public Point(int y, int x, int accCost) {
        this.y = y;
        this.x = x;
        this.accCost = accCost;
    }

    @Override
    public int compareTo(Point target) {
        if (this.accCost < target.accCost) return -1;
        else return 1;
    }
}

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer ST;
    public static StringBuilder SB = new StringBuilder();
    public static int[][] map, cost;
    public static int[] dY = {1, -1, 0, 0}, dX = {0, 0, -1, 1};
    public static int n, cnt = 1;

    public static void main(String[] args) throws IOException {

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            mapInput();
            solution();
            System.out.print(SB);
            SB = new StringBuilder();
        }
    }

    public static void mapInput() throws IOException {
        map = new int[n][n];
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            ST = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(ST.nextToken());
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public static void solution() {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        cost[0][0] = map[0][0];
        pq.offer(new Point(0, 0, cost[0][0]));

        while (!pq.isEmpty()) {
            Point now = pq.poll();

            for (int i = 0; i < 4; i++) {
                int[] next = {now.y + dY[i], now.x + dX[i]};
                if (next[0] < 0 || next[1] < 0 ||
                        next[0] >= n || next[1] >= n) continue;
                if (cost[next[0]][next[1]] <= cost[now.y][now.x] + map[next[0]][next[1]]) continue;

                cost[next[0]][next[1]] = cost[now.y][now.x] + map[next[0]][next[1]];
                pq.offer(new Point(next[0], next[1], cost[next[0]][next[1]]));
            }
        }

        SB.append("Problem ").append(cnt++).append(": ").append(cost[n-1][n-1]).append("\n");
    }
}
