package com.test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test {
	
	public static void main(String[] args) {
		int[] num_list = {12, 4, 15, 46, 38, -2, 15};
		int answer = 0;
		for(int i = 0; i<num_list.length; i++) {
			if (num_list[i]<0) {
				answer = i;
			}
		}
		
		System.out.println(IntStream.range(0, num_list.length).filter(i -> num_list[i] < 0).findFirst().orElse(-1));
		
    }
}

