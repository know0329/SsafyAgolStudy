import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Node root = new Node();
        
        for(String word : words) root.insert(word);
        for(String word : words) answer += root.cnt(word);   
        
        return answer;
    }
    
    class Node {
        Node[] subNode = new Node[26]; 
        boolean isLeaf = true;
        
        void insert(String key) {
            int index = 0;
            int loop = key.length();
            Node node = this;
            node.isLeaf = false; // insert하면 자기자신은 더 이상 말단이 아님
            
            while(index < loop) {
                int next = charToNumber(key.charAt(index));
                if(node.subNode[next] == null) node.subNode[next] = new Node();
                else node.subNode[next].isLeaf = false;
                
                node = node.subNode[next];
                index++;
            }
        }
        
        int cnt(String key) {
           int sameCharCount = 0, index = 0, loop = key.length();
           Node node = this;
               
           while(index < loop) {
                if(node.isLeaf) break;
                int next = charToNumber(key.charAt(index));
                node = node.subNode[next]; 
                index++; sameCharCount++;
           }
           return sameCharCount;
        }
        
        int charToNumber(char c) {
            return c - 'a';
        }
    }
}