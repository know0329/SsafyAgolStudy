import java.io.*;
import java.util.*;

public class B2015 {
    //부분합이란 1 ≤ i ≤ j ≤ N인 정수 i와 j에 대해 A[i]부터 A[j]까지의 합
    //i부터 j까지의 합은 sum[j]-sum[i-1]이다, 그게 K가 되야 하므로 sum[j]-sum[i-1] = K, sum[i-1]-K = sum[j]
    //|K| ≤ 2,000,000,000
    // 200,000개 모두 값이 0이고 K가 0이면,  부분합의 경우의 수 : N*(N+1) / 2 => 20,000,100,000
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] sum = new int[N + 1];
        Map<Integer, Long> map = new HashMap<>();
        long result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
            System.out.println(sum[i]);
            //  i까지의 누적합이 k
            if (sum[i] == K) {
                result++;
            }
            //i와 j사이의 구간합이 k인 경우
            if (map.containsKey(sum[i] - K))
                result += map.get(sum[i] - K);
            if (!map.containsKey(sum[i]))
                map.put(sum[i], 1L);
            else
                map.put(sum[i], map.get(sum[i]) + 1);
        }

        System.out.println(result);
    }

}
