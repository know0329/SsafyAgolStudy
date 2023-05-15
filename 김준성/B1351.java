import java.util.*;
import java.io.*;
public class B1351 {

    //	static long[] dp;
    static Map<Long, Long> map = new HashMap<>();
    static int p,q;

    static long rec(long num) {
        long prevP= num/p;
        long prevQ= num/q;
        if(num==0) return 1;
        if(map.containsKey(num)) return map.get(num);
        map.put(num, rec(prevP)+rec(prevQ));
        return map.get(num);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        System.out.println(rec(n));

    }


}