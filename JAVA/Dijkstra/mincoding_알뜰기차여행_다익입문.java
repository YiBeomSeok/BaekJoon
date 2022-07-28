import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int node;
    int accCost;

    public Node(int node, int accCost) {
        this.node = node;
        this.accCost = accCost;
    }

    @Override
    public int compareTo(Node target) {
        return this.accCost <= target.accCost ? -1 : 1;
    }
}

class Edge {
    int node;
    int cost;

    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static int[] dist, process;   // 0 ~~> x의 최단거리, 과정
    public static ArrayList<Edge>[] adj;

    public static void main(String[] args) throws IOException, NullPointerException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int T = Integer.parseInt(st.nextToken()); // 간선 개수

        ///////
        // test();
        ///////
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            input(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        int[] dist, process;
        dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        process = new int[N];

        pq.add(new Node(0, 0));
        dist[0] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (process[now.node] == 1) continue;
            process[now.node] = 1;
            for (Edge next : adj[now.node]) {
                if (dist[next.node] > now.accCost + next.cost) {
                    dist[next.node] = now.accCost + next.cost;
                    pq.add(new Node(next.node, now.accCost + next.cost));
                }
            }
        }

        if(dist[N-1] == Integer.MAX_VALUE)
            System.out.println("impossible");
        else
            System.out.println(dist[N-1]);
    }

    public static void input(int from, int to, int cost) {
        // int[] edge == {node, cost}
        adj[from].add(new Edge(to, cost));
    }

    public static void testInput() {
        adj[0].add(new Edge(1, 6));
        adj[0].add(new Edge(2, 1));
        adj[0].add(new Edge(3, 7));
        adj[1].add(new Edge(3, 4));
        adj[1].add(new Edge(4, 1));
        adj[2].add(new Edge(3, 2));
        adj[3].add(new Edge(1, 2));
        adj[4].add(new Edge(3, 3));
    }

    public static void test() {
        adj = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            adj[i] = new ArrayList<>();
        }
        testInput();

        int[] testDist = new int[5];
        int[] testProcess = new int[5];

        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (testProcess[now.node] == 1) continue;
            // now.node에 대해서 process가 진행?
            for (Edge next : adj[now.node]) {
                pq.add(new Node(next.node, now.accCost + next.cost));
            }
        }
    }
}
