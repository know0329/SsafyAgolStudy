package algorithm;

import java.util.*;
import java.io.*;

public class Main2630
{
    private static int[][] arr;
    static int white = 0;
    static int blue = 0;
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
            
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
            
        f(0, 0, n);
            
        System.out.println(white + "\n" + blue);
    }
    
    private static void f(int y, int x,int size) {
        boolean go = false;
        int temp = arr[y][x];
        
        for(int i=y;i<y+size;i++) {
            for(int j=x;j<x+size;j++) {
                if(temp != arr[i][j]) {
                    go = true;
                    break;
                }
            }
        }
        
        if(go){
            f(y,x,size/2);
            f(y,x+size/2,size/2);
            f(y+size/2,x,size/2);
            f(y+size/2,x+size/2,size/2);
        } else {
            if(temp == 1)blue++; 
            else white++;
        }
    }
}

