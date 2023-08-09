package com.test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {
		String[] str_list = {"abc", "def", "ghi"};
		String ex = "ef";
		Arrays.stream(str_list).filter(s -> !s.contains(ex)).collect(Collectors.joining());
	}
}