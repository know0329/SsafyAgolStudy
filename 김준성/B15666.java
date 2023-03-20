import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B15666 {
    static int N;
    static int M;
    static int[] arr;
    static boolean [] visited;
    static int[] choice;
    static StringBuilder sb;
    static Set<String> set = new HashSet<>();
    static void rec(int count, int start){ // 중복 허용 , 순서 x => 중복 조합
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
        for(int i = start; i < arr.length; i++){
            choice[count] = arr[i];
            rec(count + 1, i);

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

        rec(0, 0);
        System.out.println(sb.toString());
    }
}