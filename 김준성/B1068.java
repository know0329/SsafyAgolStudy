import java.util.*;
import java.io.*;
public class B1068 {
    static int N, root, result;
    static int[] parent;
    static boolean[] visited;

    private static void rec(int idx) {
        boolean isLeaf = true;
        visited[idx] = true;
        if(parent[idx] != -2){ // 연결되어 있다
            for(int i = 0 ; i < N ; i++){
                if(parent[i] == idx && !visited[i]){ // idx를 부모 노드를 하는 자식들을 탐색
                    rec(i);
                    isLeaf = false; // 자식들이 있으니까 현재 노드는 reaf노드가 아님
                }
            }
            if(isLeaf)
                result++;
        }

    }

    private static void removeNode(int idx) {
        parent[idx] = -2; // root가 -1이므로 그것보다 더 작은 값으로 설정하면 노드를 끊는다고 생각함

        for(int i = 0 ; i < N ; i++){
            if(parent[i] == idx) //  모든 연결을 끊기 위해 또 다른 자식노드들도 -2로 설정
                removeNode(i);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(br.readLine());
        parent = new int[N];

        stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ;i++){
            int node = Integer.parseInt(stringTokenizer.nextToken());
            parent[i] = node;
            if(node == -1) root = i;
        }

        int remove = Integer.parseInt(br.readLine());

        removeNode(remove); // 노드 제거하기

        result = 0;
        visited = new boolean[N];
        rec(root);

        System.out.println(result);
    }

}
