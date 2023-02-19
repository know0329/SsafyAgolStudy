import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
public class B17478 {
    static int N;
    static String [] chatBot = {
            "\"재귀함수가 뭔가요?\""
            , "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어."
            , "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지."
            , "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""
    };
    static List<String> list; // 재귀하면서 나오는 말들을 기록할 자료구조
    static Stack<String> lastStack; // "라고 답변하셨지를 넣기 위한 스택 , LIFO이기에 반대로 출력"
    static String prefix;
    static void rec(int count, String prefix, String plus, String last){
        lastStack.push(prefix+last);
        if(count == N){
            list.add(prefix+chatBot[0]);
            list.add(prefix+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            return;
        }
        else{

            for(String chat : chatBot){
                list.add(prefix + chat);
            }
            prefix = prefix+plus;
            rec(count+1, prefix, plus, last);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        list = new ArrayList<>();
        String start =  "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
        String last = "라고 답변하였지.";
        prefix = "";
        lastStack = new Stack<>();
        rec(0, prefix, "____", last);
        System.out.println(start);
        for(String str : list){
            System.out.println(str);
        }
        while(!lastStack.isEmpty()){
            System.out.println(lastStack.pop());
        }
    }
}