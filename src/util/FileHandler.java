package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileHandler {
	
	Charset charset = Charset.forName("US-ASCII");
	
	public ArrayList<String> readFile(Path path) {
		
		ArrayList<String> lines = new ArrayList<String>();
		
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
		    String line = null;
			
		    while ((line = reader.readLine()) != null) {
		    	line = line.trim();
		    	if (line.startsWith("/") || line.isEmpty() || line.startsWith("("))  
		    		continue;
		    	
		    	
		    	lines.add(line);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		return lines;
	}
	
	public ArrayList<String> readFileAll(Path p1) {
		
		ArrayList<String> alllines = new ArrayList<String>();
		
		try (BufferedReader reader = Files.newBufferedReader(p1, charset)) {
		    String line = null;
			
		    while ((line = reader.readLine()) != null) {
		    	
		    	line = line.trim();
		    	alllines.add(line);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		return alllines;
	}
	
	public String deleteFile(Path path) {
	
		try {
			Files.delete(path);
			
		} catch (NoSuchFileException x) {
			System.err.format("%s: no such" + " file or directory%n", path);
		} catch (IOException y) {
			// File permission problems are caught here.
			System.err.println(y);
		}
		return null;
	}
	
	public String saveFile(Path path, ArrayList<String> list) {
		
		try {
			if(Files.exists(path)) {
			Files.delete(path);
			}
			
		} catch (NoSuchFileException x) {
			System.err.format("%s: no such" + " file or directory%n", path);
		} catch (IOException y) {
			// File permission problems are caught here.
			System.err.println(y);
		}
		
		try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
			
			for (String l: list) {
				writer.write(l + '\n');
			}
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		
		return null;
		
	}

}
