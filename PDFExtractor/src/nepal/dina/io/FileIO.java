package nepal.dina.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class FileIO {

	public static void writeInFile(String fileName, HashSet<String> words)
			throws IOException {

		FileWriter fstream = new FileWriter(fileName);
		BufferedWriter out = new BufferedWriter(fstream);

		String pom = null;
		for (String s : words) {
			pom = new String(s.trim());
			out.write(pom + "\n");
		}

		out.close();
	}
	
	public static void writeInFile(String fileName, String translations)
			throws IOException {

		FileWriter fstream = new FileWriter(fileName);
		BufferedWriter out = new BufferedWriter(fstream);
		
		out.write(translations);
		
		out.close();
	}
	
	public static void appendFile(String fileName, String translations)
			throws IOException {

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
	    out.println(translations);
	    out.close();
	}

	public static HashSet<String> readFromFile(String fileName)
			throws IOException {

		FileReader fstream = new FileReader(fileName);
		BufferedReader out = new BufferedReader(fstream);

		HashSet<String> words = new HashSet<String>();

		String pom = out.readLine();
		while (pom != null) {
			words.add(pom);
			pom = out.readLine();
		}

		out.close();

		return words;
	}

}
