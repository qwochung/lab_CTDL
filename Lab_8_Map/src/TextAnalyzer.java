

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int pos = 0;
		while (true) {
			line = reader.readLine();
			if (line == null)
				break;
			
			StringTokenizer tokens = new StringTokenizer(line, " ");
			while (tokens.hasMoreTokens()) {
				String token = tokens.nextToken();
				if (!tokens.hasMoreTokens()) {
					add(token, -pos++);
					
				}
				else {
					add(token, pos++);
				}
				
				
				
			}
		}
		reader.close();
		}
	
	
	
	
	
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		
		if (map.containsKey(word)) {
			map.get(word).add(position);
		}
		else {
			map.put(word, new ArrayList<>(List.of(position)) );
		}
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		Map<String, ArrayList<Integer>> treeMap = new TreeMap<>(map);
		for (Map.Entry<String, ArrayList<Integer>> entry : treeMap.entrySet()) {
			String key = entry.getKey();
			ArrayList<Integer> val = entry.getValue();
			System.out.println(key + " : " + val.toString());
			
		}
		
		
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		Comparator<Integer> comparator =  new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Math.abs(o1) - Math.abs(o2);
			}
		};
		Map<Integer , String > result=  new TreeMap<>(comparator);
		
		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			String key = entry.getKey();
			ArrayList<Integer> val = entry.getValue();
			for (Integer integer : val) {
				result.put(integer, key);
			}
		}
		
		
		for (Map.Entry<Integer, String> entry : result.entrySet()) {
			Integer key = entry.getKey();
			String val = entry.getValue();
			if (key < 0 ) {
				System.out.println(val );
			}
			else {
				System.out.print(val + " ");
			}
		}
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		String result = "";
		int len = 0;
		for (Map.Entry<String,  ArrayList<Integer>> entry : map.entrySet()) {
			String key = entry.getKey();
			ArrayList<Integer> val = entry.getValue();
			if (val.size() > len) {
				len = val.size();
				result = key;
			}
		}
		return result;
	}

	
	public static void main(String[] args) throws IOException {
		String fileName = "data/fit.txt";
		TextAnalyzer  textAnalyzer = new TextAnalyzer();
		textAnalyzer.load(fileName);
		System.out.println(textAnalyzer.map);
		textAnalyzer.displayWords();
		textAnalyzer.displayText();
		textAnalyzer.add("Dai", 13);
		textAnalyzer.add("Viet", 18);
		textAnalyzer.add("Viet", 20);
		System.out.println(textAnalyzer.map);
		System.out.println(textAnalyzer.mostFrequentWord());
		
	}
}
