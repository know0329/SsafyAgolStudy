package Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B2992 {

	 	static int N;
	    static int M;
	    static int[] arr;
	    static boolean [] visited;
	    static int[] choice;
	    static String num;
	    static int result;
	    static void rec(int count){
	        if(count == num.length()){
	        	String num2 = "";
	            for(int i = 0; i < count; i++) {
	            	num2 += choice[i];
	            }
	            
	            if(Integer.parseInt(num2) > Integer.parseInt(num)) {
	            	result = Math.min(result, Integer.parseInt(num2));
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
	      
	    	Scanner scn = new Scanner(System.in);
	    	result = Integer.MAX_VALUE;
	    	num = scn.next();
	        choice = new int [num.length()];  
	        arr = new int[num.length()];
	        visited = new boolean[num.length()];
	        for(int i = 0; i < num.length(); i++){
	            arr[i] = num.charAt(i) - '0';
	        }


	        Arrays.sort(arr);

	        rec(0);
	        if(result == Integer.MAX_VALUE) {
	        	System.out.println(0);
	        }
	        else {
	        	System.out.println(result);
	        }
	        
	        
	    }

}
