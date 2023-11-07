package set_student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
//	 public static final String fileName = "src/data/hamlet.txt";
	public static final String fileName = "src/data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	
	
	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> result = new ArrayList<>();
		
		for (String string : new TreeSet<>(words)) {
			WordCount wordCount = new WordCount(string,  subCountWord(string));
			result.add(wordCount);
		}
		return result;
	}

	
	
	
	
	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> result = new HashSet<>();
		for (String string : new TreeSet<>(words)) {
			if (subCountWord(string) == 1) {
				result.add(string);
			}
		}
		return result;
	}

	
	
	
	
	
	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> result = new HashSet<>();
		for (String string : new TreeSet<>(words)) {
			if (subCountWord(string) == 2) {
				result.add(string);
			}
		}
		return result;
	}

	
	
	
	
	
	
	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		Set<WordCount> result =new TreeSet<WordCount>();
		
//		add
		for (String string : new TreeSet<>(words)) {
			WordCount wordCount = new WordCount(string,  subCountWord(string));
			
			result.add(wordCount);
		}
		return result;
		
		
	}

	
	
	
	
	
	
	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount> result = new TreeSet<WordCount>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
//				return String.compare(o1.getWord(), o2.getWord());
				return o1.compareTo( o2);
			}
		});
//		result.addAll(getWordCounts());
		for (WordCount wordCount : getWordCounts()) {
			result.add(wordCount);
		}
		
		
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		Set<String> result = new HashSet<>(words);
		
		Iterator<String> iterator = result.iterator();
		while (iterator.hasNext()) {
			String word = iterator.next();
			if (word.charAt(0) == pattern.charAt(0)) {
				iterator.remove();
			}
			
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	public int subCountWord(String string) {
		int result = 0;
		for (String string2 : words) {
			if (string.equalsIgnoreCase(string2)) {
				result++;
			}
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		
		
		
		MyWordCount myWordCount = new MyWordCount();
		System.out.println("Test getWordCounts:");
		System.out.println(myWordCount.getWordCounts());
		
		
		System.out.println("Test getUniqueWords: ");
		System.out.println(myWordCount.getUniqueWords());

		
		System.out.println("Test getDistinctWords:");
		System.out.println(myWordCount.getDistinctWords());
		
		
		System.out.println("Test printWordCounts:");
		System.out.println(myWordCount.printWordCounts());
		
		
		System.out.println("Test exportWordCountsByOccurence:");
		System.out.println(myWordCount.exportWordCountsByOccurence());
		
		
		System.out.println("Test filterWords:");
		System.out.println(myWordCount.filterWords("D"));
		
		
		
		
		
		
		
	}








}
