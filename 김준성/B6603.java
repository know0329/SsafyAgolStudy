import java.util.*;
import java.io.*;

public class B6603 {
    static int k;
    static int [] s;
    static StringBuilder sb;
    static boolean [] visited;
    static void rec(int count, int index){
        if(count == 6){
            for(int i = 0; i < k; i++){
                if(visited[i])
                    sb.append(s[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        else{
            for(int i = index; i < k; i++){
                if(!visited[i]){
                    visited[i] = true;
                    rec(count+1, i);
                    visited[i] = false;
                }
            }
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        while(true){

            k = sc.nextInt();
            if(k == 0) {
                sb.delete(sb.length()-2, sb.length());
                break;
            }
            s = new int[k];
            visited = new boolean[k];
            for(int i = 0; i < k; i++){
                s[i] = sc.nextInt();
            }
            rec(0, 0);
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}