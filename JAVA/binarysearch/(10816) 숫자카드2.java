import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int[] A;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            if(binarySearch(0, N - 1, Integer.parseInt(st.nextToken())) < 0)
                sb.append("0").append("\n");
            else
                sb.append("1").append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int binarySearch(int st, int en, int target) {
        int mid;

        while(st <= en) {
            mid = (st + en) / 2;
            if(target < A[mid]) {
                en = mid - 1;
            }
            else if(target > A[mid])
                st = mid + 1;
            else
                return mid;
        }

        return -((st + en)/2) - 1;
    }
}
