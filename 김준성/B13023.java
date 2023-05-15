import java.util.*;
import java.io.*;


public class B13023 {
    static int m;
    static ArrayList<Integer>[] list;
    static int result = 0;
    static boolean[] visited;


    public static void dfs(int start, int depth) {
        if(depth == 5) {
            result = 1;
            return;
        }

        visited[start] = true;
        for(int i : list[start]) {
            int next = i;
            if(!visited[next]) {
                dfs(next, depth+1);
            }
        }
        visited[start] = false;

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        m = M;
        list = new ArrayList[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        //N-1까지의 모든 정점에서 DFS를 통해 확인
        for(int i = 0; i < N; i++) {
            if(result == 0)
                dfs(i, 1);
        }

        System.out.println(result);
    }


}
