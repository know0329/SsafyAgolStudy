import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        long a,b,c;
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        
        long temp = div(a,b,c)%c;
        
        System.out.println(temp);
    }
    
    private static long div(long num, long cnt, long bot) {
        if(cnt == 0) return 1;
        
        long temp = div(num,cnt/2,bot)%bot; // 반드시 임시변수에 저장해야 중복계산을 줄일 수 있음
        if(cnt % 2 == 0) return (temp * temp)%bot;
        else return ((temp * temp)%bot * (num%bot))%bot;
    }
}