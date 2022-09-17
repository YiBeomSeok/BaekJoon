import java.io.*;
import java.util.*;

class Snake {
    int x, y;

    public Snake (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    /*
    map
    -1: 뱀
    0: 빈칸
    1: 사과
     */
    public static int[][] map;
    public static Queue<int[]> timing = new LinkedList<>(); // -1 좌, 1 우
    public static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1}; // 시계방향순
    public static int N, K, L;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    // 보드가 주어진다. N x N
    // 사과의 개수 K. 2개 이상일 수 있다.
    // 사과의 위치는 모두 다르다. 0,0에는 없다.
    // 왼쪽 회전 = L (좌로 90도)
    // 오른쪽 회전 = D (우로 90도)
    public static int solution () throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < K; i++) {
            int x, y;
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            map[x - 1][y - 1] = 1;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            int sec;
            char cmd;

            st = new StringTokenizer(br.readLine());
            sec = Integer.parseInt(st.nextToken());
            cmd = st.nextToken().charAt(0);

            if (cmd == 'L')
                timing.offer(new int[] {sec, -1});
            else
                timing.offer(new int[] {sec, 1});
        }

        Deque<Snake> snake = new ArrayDeque<>();
        snake.addFirst(new Snake(0, 0));
        int dir = 1; // 처음엔 '우'방향
        int hx = 0, hy = 0; // 머리 좌표
        map[hx][hy] = -1;
        int nx = hx, ny = hy; // 다음 위치시킬 머리 좌표, 일단 머리 좌표로 초기화
        int sec = 0; // 진행 시간
        while(true) {
            sec++;

            nx = nx + dx[dir];
            ny = ny + dy[dir];

            if(nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) return sec;
            if(map[nx][ny] == -1) return sec;

            // 다음 칸에 사과가 있다면 그 칸은 머리가 된다.
            if(map[nx][ny] == 1) {
                hx = nx;
                hy = ny;
                map[hx][hy] = -1;   // 머리(뱀)가 된다.
                snake.addFirst(new Snake(hx, hy));
            } else if(map[nx][ny] == 0) {
                // 다음 칸에 사과가 없는 빈 칸이면 꼬리를 줄이고 꼬리칸을 0으로 만든다.
                // 물론 다음 칸은 머리가 된다.
                hx = nx;
                hy = ny;
                snake.addFirst(new Snake(hx, hy));
                Snake tail = snake.pollLast();
                map[tail.x][tail.y] = 0;
                map[hx][hy] = -1;
            }

            if(!timing.isEmpty() && timing.peek()[0] == sec) {
                // dir 0상, 1우, 2하, 3좌
                int tmp = timing.poll()[1];
                if(tmp == -1) {
                    dir = (dir + 3) % 4;
                } else if(tmp == 1) {
                    dir = (dir + 1) % 4;
                }
            }
        }
    }

    public static void main (String[] args) throws IOException {
        System.out.print(solution());
    }
}
