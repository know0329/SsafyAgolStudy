import java.util.*;
import java.io.*;

public class B11559{


    static void down(int j) {
        Queue<Puyo> que = new LinkedList<>();
        int idx = 11;

        for(int i=11; i>=0; i--) {
            if(arr[i][j] != '.') {
                que.add(new Puyo(i, j, arr[i][j]));
                arr[i][j] = '.';
            }
        }

        while(!que.isEmpty()) {
            Puyo puyo = que.poll();

            char color = puyo.color;

            arr[idx][j] = color;

            idx--;
        }

    }

    static class Puyo{
        int x, y;
        char color;

        Puyo(int x, int y, char color){
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }



    static char arr [][];
    static int visited [][];
    static int dir [][] = {{1, 0}, {0, 1}, {-1, 0,} ,{0, -1}};
    static int result;
    static boolean stop;
    static List<Puyo> list;
    static void bfs(int r, int c){
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(r);
        que.add(c);
        visited[r][c] += 1;
        list.add(new Puyo(r, c, arr[r][c]));
        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll();

            for (int i = 0; i < 4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                if(arr[nx][ny] != arr[r][c]) continue;
                if(visited[nx][ny] != 0) continue;

                que.add(nx);
                que.add(ny);
                list.add(new Puyo(nx, ny, arr[nx][ny]));
                visited[nx][ny]  = visited[x][y] + 1;
            }
        }
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk ;
        result = 0;
        int N = 12;
        int M = 6;
        boolean flag = true;
        stop = false;
        int start = 0;
        arr = new char [N][M];
        visited = new int[N][M];
        for (int i = 0; i < N ; i++){
            stk = new StringTokenizer(br.readLine());
            String str = stk.nextToken();
            for(int j = 0; j < M; j++){
                char color = str.charAt(j);
                if(flag && color != '.'){
                    start = i;
                    flag = false;
                }
                arr[i][j] = color;
            }
        }
        while(true) {
            stop = true;
            for (int i = start; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] == 0 && arr[i][j] != '.') {
                        list = new ArrayList<Puyo>();
                        bfs(i, j);
                        if(list.size() >= 4) {
                            for (int k = 0; k < list.size(); k++) {
                                arr[list.get(k).x][list.get(k).y] = '.';

                            }
                            stop = false;
                        }
                    }
                }
            }

            if(stop){
                break;
            }
            visited = new int[N][M];

            for (int i = 0; i < 6; i++){
                down(i);
            }
            result ++;

        }
        System.out.print(result);
    }
}
