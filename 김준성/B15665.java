import java.util.*;
import java.io.*;
public class B15665 {

    static int [] selected;
    static StringBuilder sb;

    static void recFunc(int count, Integer[] numArr){
        if(count == M){
            for(int i = 0; i < M; i++){ sb.append(selected[i]).append(' ');}
            sb.append('\n');
            return;
        }
        else {
            for (int i = 0; i < numArr.length; i++) {
                // 선택한 숫자를 넣어줌
                selected[count] = numArr[i];
                recFunc(count + 1, numArr);
            }
        }
    }

    static int N;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine()," ");
        sb = new StringBuilder();
        Integer[] numArr = new Integer[N];
        selected = new int[M];
        for (int i = 0; i < N; i++){
            numArr[i] = Integer.parseInt(stk.nextToken());
        }
        //중복되는 수열을 만드는 원인이 중복된 숫자가 포함되어있는 입력배열이라고 생각하였음 => 그래서 중복된 수를 지워주기 위해 set을 사용함
        // 처음에는 count값이 M이 될 때 선택된 숫자를 따로 저장하는 StringBuilder를 만들고 static으로 있던 sb와 비교하여 그 숫자들을 포함하면 sb에 append하지 않는 걸로 구현을 했었는데
        // IDE에서는 잘 돌아갔으나 제출하니 시간초과가 걸렸음 => 1초의 시간이면 1억번의 연산이 가능하다는데 어디서 연산이 많이 나오는지 잘 모르겠음
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(numArr));
        Integer[] arr = set.toArray(new Integer[0]);
        recFunc(0, arr);
        System.out.println(sb.toString());
    }
}