import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;




public class B1325 {

    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int N, M;
    static int count;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();



    public static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        visited[x] = true;
        while (!que.isEmpty()) {
            int v = que.poll();
            for(int i : list.get(v)){ // 자식 추출
                if(!visited[i]){
                    que.add(i);
                    visited[i] = true;
                    count++;
                }
            }

        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }



        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 자식
            int b = Integer.parseInt(st.nextToken()); // 부모
            list.get(b).add(a); // 그래프 표현
        }




        int[] result = new int[N + 1]; // 카운팅 배열
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            count = 0;
            bfs(i);
            result[i] = count;
            max = Math.max(count, max);

        }
        for (int i = 1; i <= N; i++) {
            if (result[i] == max)
                sb.append(i+" ");
        }
        System.out.println(sb);

    }




}
