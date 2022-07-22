import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int[] arr = {1, 3, 4, 5, 7};

    public static void main(String[] args) throws IOException {
        System.out.println("test1");
        test1();


    }

    public static void test1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " : " + Arrays.binarySearch(arr, i));
        }

        List<Obj> li = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            li.add(new Obj(3, i));
        for(int i=4; i < 6; i++)
            li.add(new Obj(5, i));
        for (int i = 6; i < 10; i++)
            li.add(new Obj(2, i));

        Collections.sort(li);
        for(int i=0; i<10; i++)
            System.out.printf("%d ",li.get(i).getX());
        System.out.println();
        for (int i = 0; i < 10; i++)
            System.out.printf("lower_bound : %d upper_bound : %d\n", lower(li, i), lower(li, i + 1));
    }

    // 좌표 압축
    public static void test2() {
        int lo; // location
        int lower, upper;
        // 중복이 제거된 정렬된 리스트에서 lower_bound와 upper_bound 구현

        for (int i = 0; i < 10; i++) {
            lo = Arrays.binarySearch(arr, i);
            lower = lo;
            System.out.printf("[%d]", i);
            if (lo < 0)
                upper = lower = -(lo + 1);
            else
                upper = lo + 1;
            System.out.printf("lower_bound : %d, upper_bound : %d\n", lower, upper);
        }
    }

    public static int lower(List<Obj> tar, int x) {
        int lo = -Collections.binarySearch(tar, new Obj(x, -1)) - 1;
        return lo;
    }
}

class Obj implements Comparable<Obj> {
    private int x;
    private int lo;

    Obj(int x, int lo) {
        this.x = x;
        this.lo = lo;
    }

    @Override
    public int compareTo(Obj o) {
        if (x != o.getX())
            return x - o.getX();
        return lo - o.getLo();
    }

    public int getX() {
        return x;
    }

    public int getLo() {
        return lo;
    }
}
