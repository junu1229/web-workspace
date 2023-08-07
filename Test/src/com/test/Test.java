package com.test;

import java.util.Arrays;

public class Test {
	
	public static void main(String[] args) {
		int[] num_list = {12, 4, 15, 46, 38, -2, 15};
		int answer = 0;
		Arrays.stream(num_list).filter(n -> n < 0);
		Arrays.asList(num_list).indexOf(num_list);
    }
}

