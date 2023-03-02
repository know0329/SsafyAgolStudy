import java.io.*;
import java.util.*;

class Pair{
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }


}

public class B15686 {
    static int N;
    static int M;
    static int [][] arr;
    static List<Pair> list; // 전체 치킨집들 좌표
    static List<Pair> choice; // 유지할 치킨집의 좌표 리스트
    static List<Pair> ones; // 집 리스트
    static int result;
    static void rec(int count, int index) {
        if(count == M) {
            int cnt = 0; // 각 치킨집의 전체 거리
            for (int i = 0; i < ones.size(); i++) { // 각 집 별로 최소 거리 구하기
                int distanceValue = Integer.MAX_VALUE; // 집 하나당 치킨집과의 거리
                for (int j = 0; j < M; j++) {
                    int two_r = choice.get(j).x;
                    int two_c = choice.get(j).y;
                    int one_r = ones.get(i).x;
                    int one_c = ones.get(i).y;
                    distanceValue = Math.min(distanceValue, Math.abs(one_r - two_r) + Math.abs(one_c - two_c));
                }
                cnt += distanceValue;
            }
            result = Math.min(result, cnt);
            return;
        }
        for(int i = index; i < list.size(); i++) { // 조합 (중복 허용 x, 순서 허용 x)
            choice.add(list.get(i));
            rec(count+1, i+1);
            choice.remove(choice.size()-1);
        }
    }


    public static void main(String[] args) throws IOException {

        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        M = scn.nextInt();
        arr = new int [N][N];
        list = new ArrayList<>();
        ones = new ArrayList<>();
        choice = new ArrayList<>();
        result = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = scn.nextInt();
                if(arr[i][j] == 2) {
                    list.add(new Pair(i, j));
                }
                if(arr[i][j] == 1) {
                    ones.add(new Pair(i, j));
                }
            }
        }
        rec(0,0);
        System.out.println(result);
    }
}