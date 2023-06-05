package com.translation;

import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class CheckTranslation  {
	static Map<String, String> french_dict =new HashMap<>();
	static Map<String, Long> word_frequency =new HashMap<>();
	private static final long MEGABYTE = 1024L * 1024L;
	
	public static void main(String[] args) throws IOException{	
		
		double start = System.currentTimeMillis();
		String line;
		try   
		{    
			BufferedReader br = new BufferedReader(
					new FileReader("C:\\Users\\MEENA\\french_dictionary.csv"));  
			while ((line = br.readLine()) != null)     
			{  
				String[] dict = line.split(",");    // use comma as separator  
				french_dict.put(dict[0],dict[1]);  
			}  
			br.close();
		}   
		catch (IOException e)   
		{  
			e.printStackTrace();  
		}  
		
		File fw = new File("C:\\Users\\MEENA\\find_words.txt");
		try (BufferedReader find_word = new BufferedReader(new FileReader(fw))) {
			String word;
			while ((word = find_word.readLine()) != null)
			{  
				word = word.trim();
				matchNdReplace(word, french_dict.get(word));
			}
		}
		catch (IOException e)   
		{  
			e.printStackTrace();  
		}  
		//create and write to frequency.csv file
		createCSV(word_frequency, french_dict);
		
		Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Run the garbage collector
		// Calculate the used memory
		long memory = runtime.totalMemory() - runtime.freeMemory();
		//Performance Time
		double end = System.currentTimeMillis();
		double millitime = end - start ;		
		performance(memory, millitime);
		
	}
	private static void performance(long memory, double millitime) throws IOException {
		
		int minutes = (int)(millitime/1000)/ 60;
		float seconds = (float) ((millitime/1000f)% 60f);
		File p = new File("D:\\performance.txt");
		try (FileWriter fileWriter = new FileWriter(p)) {
			fileWriter.write("Time to process: "+minutes+" minutes  "+seconds+" seconds\n");
			fileWriter.write("Memory : "+bytesToMegabytes(memory)+" MB");
		}		
	}
	
	public static float bytesToMegabytes(long bytes) {
        return (float)bytes / MEGABYTE;
    }

	private static void createCSV(Map<String, Long> word_frequency2, Map<String, String> french_dict) throws IOException {
		
		File csvFile = new File("D:\\frequency.csv");
		try (FileWriter fileWriter = new FileWriter(csvFile)) {
			fileWriter.write("English word, French word, Frequency\n\n");
			for (Entry<String, String> entry : french_dict.entrySet()) {
			      StringBuilder line = new StringBuilder();
			      line.append(entry.getKey()).append(", ").append(entry.getValue())
			      .append(", ").append(word_frequency2.get(entry.getKey())).append("\n");
			      fileWriter.write(line.toString());
			    }
		}
		
	}

	private static void matchNdReplace(String search, String replace) throws IOException {
		Pattern pattern = Pattern.compile(search, Pattern.CASE_INSENSITIVE);
		File inFile = new File("C:\\Users\\MEENA\\t8.shakespeare.txt");
		File outFile = new File("D:\\t8.shakespeare.translated.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inFile));
        if (!outFile.exists()) {
            outFile.createNewFile();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFile, StandardCharsets.UTF_8));

        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {            	
            	Matcher matcher = pattern.matcher(line);
            	long c = matcher.results().count();
            	if(word_frequency.containsKey(search)) {
            		word_frequency.put(search, word_frequency.get(search)+c); 
            	}else {
            		word_frequency.put(search, c);  
            	}            	     		
            	String newline = matcher.replaceAll(replace);
            	bufferedWriter.write(newline);
            	bufferedWriter.newLine();
            }
        } finally {
            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();
        }
		
	}	
}
