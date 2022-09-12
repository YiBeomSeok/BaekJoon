import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int M, N, H, day, not;
    public static int[] dirX = {0, 0, -1, 1, 0, 0}, dirY = {-1, 1, 0, 0, 0, 0}, dirZ = {0, 0, 0, 0, -1, 1};
    public static int[][][] boxes;
    public static int[][][] days;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        boxes = new int[H][N][M];
        days = new int[H][N][M];
        Deque<int[]> dq = new ArrayDeque<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    boxes[i][j][k] = Integer.parseInt(st.nextToken());
                    if (boxes[i][j][k] == 1)
                        dq.offer(new int[]{k, j, i});
                    else if (boxes[i][j][k] == 0)
                        not++;
                }
            }
        }
        if (not != 0)
            bfs(dq);

        if (not > 0)
            System.out.print(-1);
        else {
            for (int i = 0; i < H; i++)
                for (int j = 0; j < N; j++)
                    for (int k = 0; k < M; k++)
                        if (day < days[i][j][k]) day = days[i][j][k];
            System.out.print(day);
        }
    }

    public static void bfs(Deque<int[]> deque) {
        while (!deque.isEmpty()) {
            int[] now = deque.poll();
            int x, y, z;
            x = now[0];
            y = now[1];
            z = now[2];

            for (int i = 0; i < 6; i++) {
                int[] next = new int[]{x + dirX[i], y + dirY[i], z + dirZ[i]};
                int nx = next[0];
                int ny = next[1];
                int nz = next[2];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N || nz < 0 || nz >= H)
                    continue;

                if (boxes[nz][ny][nx] == 0) {
                    deque.offer(next);
                    not--;
                    boxes[nz][ny][nx] = 1;
                    days[nz][ny][nx] = days[z][y][x] + 1;
                }
            }
        }
    }
}
