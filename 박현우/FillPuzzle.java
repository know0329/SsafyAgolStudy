import java.util.*;
import java.io.*;
import java.awt.Point;

class Solution {
    static int[] dy = {-1, 1, 0 ,0};
    static int[] dx = {0, 0, -1 ,1};
    static int n;
    static ArrayList<Point> p;
    static ArrayList<Point> org;
    
    public int solution(int[][] game_board, int[][] table) throws Exception{
        int answer = 0;
        n = game_board[0].length;
        
        // 0도 90도 180도 270도 - rot
        for(int rot=1;rot<=4;rot++){
            if(rot != 1) game_board = rotation(game_board);
            boolean[][] v = new boolean[n][n];
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(table[i][j] == 1 && !v[i][j]) {
                        // 퍼즐 조각을 찾음
                        p = new ArrayList<>();
                        org = new ArrayList<>();
                        puzzle(i,j,table, v, p, org);
                        // 퍼즐 조각 좌표를 시작점 기준으로 수정
                        edit(p);
                        // 찾은 퍼즐조각을 끼워 맞춤
                        int tAnswer = search(game_board, p);
                        answer += tAnswer;
                        
                        // 퍼즐이 끼워졌으면 퍼즐조각에서 제외
                        if(tAnswer != 0) {
                            for(Point p : org) {
                                table[p.y][p.x] = 0;
                            }
                        }
                        
                    }
                } 
            }
        }
        return answer;
    }
        
    private static void puzzle(int y, int x,int[][] table,boolean[][] v, ArrayList<Point> list, ArrayList<Point> org) {
        v[y][x] = true;
        list.add(new Point(x,y));
        org.add(new Point(x,y));
        for(int i=0;i<4;i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n || table[ny][nx] == 0 || v[ny][nx]) continue;
            puzzle(ny,nx,table,v,list, org);
        }
    }
    
    private static int search(int[][] game_board, ArrayList<Point> list) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(game_board[i][j] == 0) {
                    // 끼울 곳이 있는지 확인
                    if(insert(new Point(j,i), game_board, list)) {
                        // 끼우고 나서 주변에 공백이 없는지 확인, 끼워지면 바로 리턴하기
                        if(boundary(new Point(j,i), game_board, list)) {
                            return list.size();                 
                        } else {
                            // 만약 boundary 체크에서 실패하면 끼운 조각 해제하기
                            desert(new Point(j,i), game_board, list);
                        }                  
                    }
                }
            }
        }
        return 0;
    }
    
    private static int[][] rotation(int[][] game_board) {
        int[][] copyMap = new int[n][n];
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copyMap[j][n - 1 - i] = game_board[i][j];
			}
		}
        return copyMap;
    }
    
    private static void edit(ArrayList<Point> list) {
        Point first = list.get(0);
        for(int i=0;i<list.size();i++) {
            int ny = list.get(i).y - first.y;
            int nx = list.get(i).x - first.x;
            list.set(i,new Point(nx,ny));
        }
    }
    
    private static boolean insert(Point cur, int[][] game_board, ArrayList<Point> list) {
        for(Point next : list) {
            if(cur.y + next.y < 0 || cur.y + next.y >= n || cur.x + next.x < 0 || cur.x + next.x >= n) return false;
            if(game_board[cur.y + next.y][cur.x + next.x] == 1) return false;
        }
        // 실제로 끼우기 
        for(Point next : list) {
            game_board[cur.y + next.y][cur.x + next.x] = 1;
        }
        
        return true;
    }
    // 끼운조각 해제하기
    private static void desert(Point cur, int[][] game_board, ArrayList<Point> list) {
        // 해제 
        for(Point next : list) {
            game_board[cur.y + next.y][cur.x + next.x] = 0;
        }
    }    
    
    private static boolean boundary(Point cur, int[][] game_board, ArrayList<Point> list) {
        for(Point next : list) {
            for(int i=0;i<4;i++) {
                int ny = cur.y + next.y + dy[i];
                int nx = cur.x + next.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if(game_board[ny][nx] == 0) return false; // 끼워넣은 곳 4방향에 빈칸이 있으면 실패
            }
        }
        
        return true;
    }
}