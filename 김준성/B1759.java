import java.util.*;
import java.io.*;
public class B1759 {
    static int L;
    static int C;
    static ArrayList <String> alphabet;
    static boolean [] visited; // 문자 사용을 기록하기 위해
    static void make(int count, int index) {
        if(count == L) {
            int aeiou = 0; // 모음
            int other = 0; // 자음

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < C; i++) { // C개의 문자 사용
                if(visited[i]) { // 사용한 문자들이냐?
                    sb.append(alphabet.get(i));
                    if(alphabet.get(i).equals("a") || alphabet.get(i).equals("e") || alphabet.get(i).equals("i") ||
                            alphabet.get(i).equals("o") || alphabet.get(i).equals("u")) { // 모음이면
                        aeiou ++;
                    }
                    else { // 자음이면
                        other++;
                    }
                }
            }
            if(aeiou > 0 && other >= 2)   //최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
                System.out.println(sb);
        }
        for(int i = index; i < C; i++) { //  중복되는 것은 없다(visited 배열) + 전에 것에 접근 X (사전 순서이니까)(index)
            visited[i] = true;
            make(count+1, i+1);
            visited[i] = false;
        }

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc  =  new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        visited = new boolean [C];
        alphabet = new ArrayList<String>(); // 알파벳을 담을 자료구조
        for(int i = 0; i < C; i++) {
            alphabet.add(sc.next());
        }
        alphabet.sort(null); // 알파벳이 암호에서 증가하는 순서로 배열되었다고 했으니 정렬을 해준다.
        make(0,0);

    }

}