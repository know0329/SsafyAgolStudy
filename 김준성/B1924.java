import java.io.*;
import java.util.*;
public class B1924 {
    static final  int[] months = {0, 31,28,31,30,31,30,31,31,30,31,30,31}; // months[1] 을 1월로 생각
    static final String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    //2007년 1월 1일 월요일 => days[1]을 1일이라 생각
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int today = d; // 주어진 날짜의 일 설정
        for (int i = 1; i < m ; i++) {
            today += months[i]; // 1월 1일부터 주어진 날짜의 월이 되도록 더한다.
        }

        System.out.print(days[today%7]); // 1월 1일부터 더했으므로 일주일씩 나누어 주면 그 날의 요일이 나온다.
    }
}
