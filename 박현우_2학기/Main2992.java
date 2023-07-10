import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static String answer;
    private static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] number = br.readLine().toCharArray();
        char[] sorted = Arrays.copyOf(number,number.length);

        // 오름차순 정렬
        Arrays.sort(sorted);

        v = new boolean[number.length];
        f(number, sorted, 0, sorted.length,"");

        if(answer == null) answer = "0";
        System.out.println(answer);
    }

    private static void f(char[] org, char[] sort, int cur,int end, String ans) {
        if(answer != null) return;

        if(cur == end) {
            if(!ans.equals(String.valueOf(org))) answer = ans;
            return;
        }
        for(int i=0;i<end;i++) {
            if(v[i] || chk(String.valueOf(org),ans)) continue;
            v[i] = true;
            f(org,sort,cur+1,end,ans+sort[i]);
            v[i] = false;
        }
    }

    private static boolean chk(String org, String sort) {
        if(sort == "") return false;
        int or = Integer.parseInt(org.substring(0, sort.length()));
        int so = Integer.parseInt(sort);
        return or > so;
    }
}
