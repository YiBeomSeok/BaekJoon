import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[][] board = new int[502][502];
    public static boolean[][] vis = new boolean[502][502];
    public static int n = 7, m = 10;
    public static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public static void main (String[] args) throws IOException {
        bfs();
    }

    /*
    1. 시작하는 칸을 큐에 넣고 방문했다는 표시를 남김
    2. 큐에서 원소를 꺼내어 그 칸에 상하좌우로 인접한 칸에 대해 3번을 진행
    3. 해당 칸을 이전에 방문했다면 아무 것도 하지 않고, 처음으로 방문했다면
        방문했다는 표시를 남기고 해당 칸을 큐에 삽입
    4. 큐가 빌 때까지 2번을 반복
    모든 칸이 큐에 1번씩 들어가므로 시간복잡도는 칸이 N개일 때 O(N)
     */

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        vis[0][0] = true;
        q.add(new int[] {0, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            System.out.printf("( %d, %d ) -> ", cur[0], cur[1]);
            for(int dir = 0; dir < 4; dir ++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(vis[nx][ny] || board[nx][ny] != 1) continue;
                vis[nx][ny] = true;
                q.add(new int[] {nx, ny});
            }
        }
    }
}
