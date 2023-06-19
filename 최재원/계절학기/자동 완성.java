// import java.util.*;

// class Solution {
//     public int solution(String[] words) {
//         int answer = 0;
//         int temp = 0;
        
//         ArrayList<String> list = new ArrayList<String>();
        
//         for(String word : words)
//             list.add(word);
//         Collections.sort(list);
        
//         // 1, 2번
//         String str1 = list.get(0);
//         String str2 = list.get(1);
//         int len = 0;
//         for(int i=0; i<str1.length() && i<str2.length(); i++){
//             if(str1.charAt(i) == str2.charAt(i))
//                 len++;
//             else
//                 break;
//         }
//         if(len < str1.length())
//             answer += len+1;
//         else 
//             answer += len;
        
//         // 2 ~ 마지막-1
//         for(int n=1; n<words.length-1; n++){
//             // 초기화
//             str1 = list.get(n-1);
//             str2 = list.get(n);
//             len = 0;
//             // 문자열 비교, 겹치는 만큼 len 추가
//             for(int i=0; i<str1.length() && i<str2.length(); i++){
//                 if(str1.charAt(i) == str2.charAt(i))
//                     len++;
//                 else
//                     break;
//             }
///////////////////////////////////////////////////////////////////////////
//             len = Math.max();
///////////////////////////////////////////////////////////////////////////
//             // answer에 추가
//             if(len < str1.length())
//                 answer += len+1;
//             else 
//                 answer += len;
//         }
        
//         // 마지막-1 ~ 마지막
//         // 초기화
//         str1 = list.get(words.length-2);
//         str2 = list.get(words.length-1);
//         len = 0;
//         for(int i=0; i<str1.length() && i<str2.length(); i++){
//             if(str1.charAt(i) == str2.charAt(i))
//                 len++;
//             else
//                 break;
//         }
//         if(len < str1.length())
//             answer += len+1;
//         else 
//             answer += len;
        
//         return answer;
//     }
// }

import java.util.*;

class Solution {
	public static int solution(String[] words) {
		int answer = 0;
		int value = 0;
		ArrayList<String> al = new ArrayList<String>();

		for(String word : words)
			al.add(word);
		Collections.sort(al);

        // 1, 2번 단어 겹치는 부분 길이 계산
		value = len(al.get(0), al.get(1));
        // 최댓값이 단어의 길이와 같다면 최댓값을, 같지 않다면 최댓값 + 1을 answer에
		if(value < al.get(0).length())
			answer += value + 1;
		else
			answer += value;

        // 가운데 단어들
		for(int i = 1; i < words.length - 1; i++) {
            // 이전 단어와의 겹치는 부분 길이 계산
			value = len(al.get(i), al.get(i-1));
            // 다음 단어와의 겹치는 부분 길이와 비교하여 더 큰 값 선택
			value = Math.max(len(al.get(i), al.get(i+1)), value);

			if(value < al.get(i).length())
				answer += value + 1;
			else
				answer += value;
		}
		
        // 마지막-1, 마지막 단어 겹치는 부분 길이 계산
		value = len(al.get(words.length - 2), al.get(words.length - 1));
		if(value < al.get(words.length-1).length())
			answer += value + 1;
		else
			answer += value;

		return answer;
	}

    // 겹치는 부분의 길이를 계산
	public static int len(String s1, String s2) {
		int length = 0;
		for(int i = 0; i < s1.length() && i < s2.length(); i++) {
			if(s1.charAt(i) == s2.charAt(i))
				length++;
			else
				break;
		}

		return length;
	}

}