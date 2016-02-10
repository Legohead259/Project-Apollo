package util;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Writer {
	String path;
	boolean append = false;
	PrintWriter printer;
	
	public Writer(String filePath) {
		path = filePath;
		
		try {
			init();
			
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Writer(String filePath, boolean append) {
		path = filePath; this.append = append; 
		
		try {
			init();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void init() throws IOException{
		FileWriter writer = new FileWriter(path, append);
		printer = new PrintWriter(writer);
	}
	
	public void write(String text) {
		printer.printf("%s", text); 
	}
	
	public void write(double value) {
		printer.printf("%s", value); 
	}
	
	public void writeNewLine() {
		printer.printf("%n");
	}
	
	public void stop() {
		printer.close();
	}

	public void writeSkipLine(int i) {
		for (int x = 0; x < i; x++) {
			writeNewLine();
		}
	}
}
