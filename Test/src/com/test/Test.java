package com.test;


public class Test {
	
	public static void main(String[] args) {
		int[] num_list = {2, 1, 6};
		int[] answer = new int[num_list.length];
		int n = 1;
		System.out.println(num_list.length);
		for(int i = 0; i<num_list.length; i++) {
			if(num_list.length-(n+i)>0) {
				answer[i] = num_list[i+n];
			} else {
				answer[i] = num_list[i-n];
			}
		}
		for(int a:answer) {
			System.out.println(a);
		}
	}
	

}