import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cur = br.readLine();
        int cnt = 0;
        while(!cur.contains("-")) {
            cnt++;
            Stack<Character> s = new Stack<>();
            int loop = cur.length();

            for(int i = 0 ; i < loop ; i++) {
                if(!s.empty()) {
                    if(s.peek() == '{' && cur.charAt(i) == '}') {
                        s.pop();
                        continue;
                    }
                }
                s.push(cur.charAt(i));
            }
            System.out.println(cnt + "." + " " + chk(s));
            cur = br.readLine();
        }
    }

    private static int chk(Stack<Character> stack) {
        int answer = 0;
        while(!stack.isEmpty()) {
            Character f = stack.pop();
            Character s = stack.pop();
            if(f != s) answer += 2;
            else answer++;
        }
        return answer;
    }
}
