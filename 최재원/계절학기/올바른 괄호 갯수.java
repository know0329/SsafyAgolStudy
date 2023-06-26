import java.util.*;

// class Solution {
//     static int count;
//     public int solution(int n) {
//         count = 0;
//         dfs(0,0,n);
//         return count;
//     }
    
//     public void dfs(int left, int right, int n) {
//         if(left < right) return;
//         if(left > n || right > n) return;
        
//         if(left == n && right == n) {
//             count++;
//             return;
//         }
        
//         dfs(left + 1, right, n);
//         dfs(left, right + 1, n);
//     }

// }

class Solution {
    public int solution(int n) {
        return countValidParentheses("", n, n);
    }

    private int countValidParentheses(String parentheses, int openCount, int closeCount) {
        if (openCount == 0 && closeCount == 0) {
            if (isValidParentheses(parentheses)) {
                return 1;
            } else {
                return 0;
            }
        }
        int count = 0;

        // 열린 괄호를 추가할 수 있는 경우
        if (openCount > 0) {
            count += countValidParentheses(parentheses + "(", openCount - 1, closeCount);
        }

        if (closeCount > openCount) {
            count += countValidParentheses(parentheses + ")", openCount, closeCount - 1);
        }

        return count;
    }

    private boolean isValidParentheses(String parentheses) {
        Stack<Character> stack = new Stack<>();

        for (char c : parentheses.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                // 스택이 비어있거나 pop한 값이 열린 괄호가 아닐 경우
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}