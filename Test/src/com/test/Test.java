package com.test;

import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		int n = 10;
		ArrayList<Integer> list = new ArrayList<>();
		
		while(n!=1) {
			if(n%2==0) {
				n/=2;
				list.add(n);
			} else {
				n=3*n+1;
				list.add(n);
			}
		}
		int[] answer = new int[list.size()];
		
		for(int i = 0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
	}
	
	

}