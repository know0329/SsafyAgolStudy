package algorithm;

import java.io.*;
import java.util.*;

class Node{
	int parent = -1;
	List<Integer> child = new ArrayList<>();
}

public class Tree1068 {
	static int n, m, res;
	static Node[] tree;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		tree = new Node[n];
		int start = 0;
		
		for(int i=0;i<n;i++) tree[i] = new Node();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int temp = Integer.parseInt(st.nextToken());

			if(temp == -1) start = i;
			else tree[temp].child.add(i);
			tree[i].parent = temp;
		}
		
		st = new StringTokenizer(br.readLine());
		int removed = Integer.parseInt(st.nextToken());
		
		if(start != removed) post(start, removed);
		
		System.out.println(res);
	}
	
	private static void post(int s,int skip) {	
		int loop = tree[s].child.size(); 
		int del = -2;
		for(int i=0;i<loop;i++) {
			if(tree[s].child.get(i) == skip) del = i;
			else post(tree[s].child.get(i), skip);		
		}
		
		if(del != -2) tree[s].child.remove(del);
		
		// size로 말단노드판단하므로 remove로 지워줘야함. << 수정하고 싶다..
		int curChild = tree[s].child.size();
		res = curChild == 0 ? res+1 : res;
	}
}
