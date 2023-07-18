import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static String answer;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] setting = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sushi = new int[setting[0]];

        for (int i = 0; i < setting[0]; i++) sushi[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < setting[0]; i++) {
            boolean[] eaten = new boolean[setting[1] + 1];
            int temp = 0;
            // 쿠폰 적용이 가능한 스시가 있는지 앞/뒤 확인을 위해 길이-1, 길이+1 로 범위 조정
            int start = i + setting[0] ;
            int end = start + setting[2];
            for (int j = start; j < end; j++) {
                if (eaten[sushi[j % setting[0]]]) continue;
                eaten[sushi[j % setting[0]]] = true;
                temp++;
            }

            if(!eaten[setting[3]]) temp++;

            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
    }
}
