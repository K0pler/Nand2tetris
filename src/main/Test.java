package main;

import java.util.HashMap;

public class Test {
	
	HashMap<String, String> symbolmap = new HashMap<String, String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String l = "D=A+M";
		
		//String line = l.substring(l.indexOf('@') + 1);
		//String binary = Integer.toBinaryString(Integer.parseInt(line));
		//System.out.println((String.format("%016d%n", Integer.parseInt(binary))));
		
		String dest = l.substring(0, l.indexOf("="));
		
		String comp = l.substring(l.indexOf("=")+1);
		
		System.out.println(dest);
		
		System.out.println(comp);
		
		//String line = l.substring(l.indexOf('@') + 1);
		//int binary = Integer.parseInt(line);
		
		//String bistring = Integer.toBinaryString(binary);
		
		//int love = Integer.parseInt(bistring);
		
		//System.out.println(String.format("%016d%n", love));
		
		//int foo = Integer.parseInt(l);
		
		//System.out.format("%016d%n", foo);
		
		//System.out.println(l.substring(l.indexOf("@") + 1));
		
		//System.out.println(Integer.toBinaryString(Integer.parseInt(line)));

	}

}
