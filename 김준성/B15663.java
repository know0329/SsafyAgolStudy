import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B15663 {
    static int N;
    static int M;
    static int[] arr;
    static boolean [] visited;
    static int[] choice;
    static StringBuilder sb;
    static Set<String> set = new HashSet<>();
    static void rec(int count){
        if(count == M){
            StringBuilder newSb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                newSb.append(choice[i]).append(" ");
            }
            if (!set.contains(newSb.toString())) {
                sb.append(newSb).append("\n");
                set.add(newSb.toString());
            }
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]) {
                visited[i] = true;
                choice[count] = arr[i];
                rec(count + 1);
                visited[i] = false;
            }

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        choice = new int [M];
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            arr[i] = (Integer.parseInt(st.nextToken()));
        }


        Arrays.sort(arr);

        rec(0);
        System.out.println(sb.toString());
    }
}