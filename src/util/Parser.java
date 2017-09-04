package util;

import java.util.ArrayList;

public class Parser {
	
	ArrayList<String> parsedLines = new ArrayList<String>();
	
	Code code = new Code();
	
	String line = "";
	
	public ArrayList<String> replaceSymbol(ArrayList<String> list) {
		
		ArrayList<String> addressReplace = new ArrayList<String>();
		
		addressReplace.clear();
		
		code.fillSymbolMap();
		
		for (String l: list) {
			char j = l.charAt(1);
			if (l.startsWith("@") && Character.isLetter(j)) {
				String rline = l.substring(l.indexOf('@') + 1);
				String address = code.getSymbol(rline);
				addressReplace.add("@" + address);
				
			} else {
				addressReplace.add(l);
			}
		}
		
		return addressReplace;
		
	
	}
	public ArrayList<String> parsefile(ArrayList<String> list) {
		
		ArrayList<String> listToParse = replaceSymbol(list);
		
		parsedLines.clear();
		
		for (String l: listToParse) {
			if (l.startsWith("@")) {
					String line = l.substring(l.indexOf('@') + 1);
					String binary = Integer.toBinaryString(Integer.parseInt(line));
					
					while (binary.length() < 16) {
						binary = "0" + binary;
					}
					
					parsedLines.add(binary);
				
			}
			
			if (l.contains("=")) {
				
				String dest = l.substring(0, l.indexOf("="));
				
				String comp = l.substring(l.indexOf("=")+1);
				
				parsedLines.add("111" + code.getComp(comp) + code.getDest(dest) + code.getJump("null"));
				
			}
			
			if (l.contains(";")) {
				
				String comp = l.substring(0, l.indexOf(";"));
				
				String jump = l.substring(l.indexOf(";")+1);
				
				parsedLines.add("111" + code.getComp(comp) + code.getDest("null") + code.getJump(jump));
				
			}
		}
		
		return parsedLines;
	}
}
