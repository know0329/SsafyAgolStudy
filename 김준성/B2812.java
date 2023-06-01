import java.util.*;
import java.io.*;

public class B2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String num = st.nextToken();

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < N; i++) {
            int current = num.charAt(i) - '0';

            while(count < K && !stack.isEmpty() && stack.peek() < current) {
                stack.pop();
                count++;
            }
            stack.add(current);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N - K; i++) {
            sb.append(stack.get(i));
        }
        System.out.print(sb);
    }
}
