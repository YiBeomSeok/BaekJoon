import java.util.*;
import java.io.*;
class Student {
    int cost;
    boolean isFriend = false;
    ArrayList<Student> fList = new ArrayList<>();
    public Student(int cost) {
        this.cost = cost;
    }
}

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer ST;
    public static int N, M, k, sum;
    public static Student[] list;

    public static void main(String[] args) throws IOException {
        ST = new StringTokenizer(br.readLine());
        N = Integer.parseInt(ST.nextToken());
        M = Integer.parseInt(ST.nextToken());
        k = Integer.parseInt(ST.nextToken());
        list = new Student[N];

        ST = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            list[i] = new Student(Integer.parseInt(ST.nextToken()));
        }

        for(int i=0; i<M; i++) {
            ST = new StringTokenizer(br.readLine());
            Student p1 = list[Integer.parseInt(ST.nextToken()) - 1];
            Student p2 = list[Integer.parseInt(ST.nextToken()) - 1];

            p1.fList.add(p2);
            p2.fList.add(p1);
        }

        solution();
    }
    // 일단 학생 한 명을 뽑는다.


    // 1. isFriend에서 아직 친구가 아닌 학생을 뽑는다.
    // 2. 그 학생을 기준으로 서로 친구 관계인 학생들을 큐에 넣는다. bfs
    // 3. 넣으면서 cost가 가장 작은 학생을 저장.
    // 4. 탐색이 끝난 뒤 cost가 가장 작은 학생을 친구로 삼으면 최소 비용이다.
    // 5. isFriend에서 아직 친구가 아닌 학생을 대상으로 1번 부터 반복
    // * 한 번의 탐색이 끝날 때 드는 비용이 k를 넘어가면 중단한다.

    public static void solution() {
        for(int i=0; i<N; i++) {
            if(!list[i].isFriend) {
                sum += bfs(list[i]);
                if(sum > k) {
                    System.out.println("Oh no");
                    return;
                }
            }
        }
        System.out.println(sum);
    }

    public static int bfs(Student student) {
        Queue<Student> q = new LinkedList<>();

        int min = student.cost;
        student.isFriend = true;
        q.offer(student);

        while(!q.isEmpty()) {
            Student now = q.poll();

            for(Student st : now.fList) {
                if(!st.isFriend) {
                    st.isFriend = true;
                    if(st.cost < min) min = st.cost;
                    q.offer(st);
                }
            }
        }

        return min;
    }
}
