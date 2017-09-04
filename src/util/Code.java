package util;

import java.util.HashMap;

public class Code {
	
	int i = 16;
	
	private String getAddress() {
		
		int j = i;
		i++;
		return j + "";
		
	}
	
	HashMap<String, String> symbolmap = new HashMap<String, String>();
	
	public void fillSymbolMap() {
		
		symbolmap.clear();
		
		symbolmap.put("SP", "0");
		symbolmap.put("LCL", "1");
		symbolmap.put("ARG", "2");
		symbolmap.put("THIS", "3");
		symbolmap.put("THAT", "4");
		symbolmap.put("R0", "0");
		symbolmap.put("R1", "1");
		symbolmap.put("R2", "2");
		symbolmap.put("R3", "3");
		symbolmap.put("R4", "4");
		symbolmap.put("R5", "5");
		symbolmap.put("R6", "6");
		symbolmap.put("R7", "7");
		symbolmap.put("R8", "8");
		symbolmap.put("R9", "9");
		symbolmap.put("R10", "10");
		symbolmap.put("R11", "11");
		symbolmap.put("R12", "12");
		symbolmap.put("R13", "13");
		symbolmap.put("R14", "14");
		symbolmap.put("R15", "15");
		symbolmap.put("SCREEN", "16384");
		symbolmap.put("KBD", "24576");
		
	}
	
	public String getSymbol(String s) {
		
		if (!symbolmap.containsKey(s)) {
			symbolmap.put(s, getAddress());
		}
		
		return symbolmap.get(s);
	}
	
	public String getComp(String s) {
		
		HashMap<String, String> compmap = new HashMap<String, String>();
	
		compmap.put("0", "0101010");
		compmap.put("1", "0111111");
		compmap.put("-1", "0111010");
		compmap.put("D", "0001100");
		compmap.put("A", "0110000");
		compmap.put("!D", "0001101");
		compmap.put("!A", "0110001");
		compmap.put("-D", "0001111");
		compmap.put("-A", "0110011");
		compmap.put("D+1", "0011111");
		compmap.put("A+1", "0110111");
		compmap.put("D-1", "0001110");
		compmap.put("A-1", "0110010");
		compmap.put("D+A", "0000010");
		compmap.put("D-A", "0010011");
		compmap.put("A-D", "0000111");
		compmap.put("D&A", "0000000");
		compmap.put("D|A", "0010101");
		compmap.put("M", "1110000");
		compmap.put("!M", "1110001");
		compmap.put("-M", "1110011");
		compmap.put("M+1", "1110111");
		compmap.put("M-1", "1110010");
		compmap.put("D+M", "1000010");
		compmap.put("D-M", "1010011");
		compmap.put("M-D", "1000111");
		compmap.put("D&M", "1000000");
		compmap.put("D|M", "1010101");
		
		return compmap.get(s);
	}
	
	public String getDest(String s) {
		
		HashMap<String, String> destmap = new HashMap<String, String>();
		
		destmap.put("null", "000");
		destmap.put("M", "001");
		destmap.put("D", "010");
		destmap.put("MD", "011");
		destmap.put("A", "100");
		destmap.put("AM", "101");
		destmap.put("AD", "110");
		destmap.put("AMD", "111");
		
		return destmap.get(s);
	}
	
	public String getJump(String s) {
		
		HashMap<String, String> jumpmap = new HashMap<String, String>();
		
		jumpmap.put("null", "000");
		jumpmap.put("JGT", "001");
		jumpmap.put("JEQ", "010");
		jumpmap.put("JGE", "011");
		jumpmap.put("JLT", "100");
		jumpmap.put("JNE", "101");
		jumpmap.put("JLE", "110");
		jumpmap.put("JMP", "111");
		
		return jumpmap.get(s);
	}
}
