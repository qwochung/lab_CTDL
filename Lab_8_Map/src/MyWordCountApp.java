

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MyWordCountApp  {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private static Map<String, Integer> map = new HashMap<String, Integer>();

	
	
	
	
	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws IOException {
		List<String> list = TextFileUtils.readText(fileName);
		for (String string : list) {
			if (!map.containsKey(string)) {
				map.put(string, 1);
			}
			else {
				map.put(string, map.get(string)+1);
			}
		}
		
	}
	
	
	

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		int count = 0;
		for (String key : map.keySet()) {
			if (map.get(key) ==1) {
				count++;
			}
		}
		return count;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key +" : " + val);
			
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		
//		Comparator<String> comparator = new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				return o2.compareTo(o1);
//			}
//		};
		
		
		Map<String, Integer> treeMap = new TreeMap<>();
		treeMap.putAll(map);
		for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key +" : " + val);
			
		}
		
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return map.toString();
	}
	
	public static void main(String[] args) throws IOException {
		MyWordCountApp myWordCount = new MyWordCountApp();
		myWordCount.loadData();
//		System.out.println(myWordCount.toString());
//		System.out.println(myWordCount.countUnique());
//		myWordCount.printWordCounts();
		
		myWordCount.printWordCountsAlphabet();
	}




}
