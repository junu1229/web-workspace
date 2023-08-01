package com.test;

public class Test {

	public static void main(String[] args) {
		String answer = "";
		String my_string = "bus";
		answer = my_string.replaceAll("[aeiou]", "");
        System.out.println(answer);
    }
}

