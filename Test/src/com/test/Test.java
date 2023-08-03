package com.test;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] array = {149, 180, 192, 170};
		int height = 167;
		int answer = 0;
		answer = (int) Arrays.stream(array).filter(key -> key>=height).count();
		System.out.println(answer);
    }
}

