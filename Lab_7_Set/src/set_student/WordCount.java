package set_student;

import java.util.Comparator;

public class WordCount implements  Comparable<WordCount>{
	private String word;
	private int count;

	public WordCount(String word, int count) {
		this.word = word;
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + word.hashCode();
		result = prime * result + count;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("called.");
		if (obj == null || obj.getClass() != getClass())
			return false;
		else {
			WordCount c = (WordCount) obj;
			return this.word.equals(c.word);
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	@Override
	public String toString() {
		return this.word + "-" + this.count;
	}

	@Override
	public int compareTo(WordCount o) {
		int result = o.getCount() - this.getCount();
		if (result == 0) {
			return this.getWord().compareToIgnoreCase(o.getWord());
		}
		return result;
	}

	

//	
//
//	@Override
//	public int compare(WordCount o1, WordCount o2) {
//		int result = o2.getCount() - o1.getCount();
//		if (result == 0) {
//			return o1.getWord().compareToIgnoreCase(o2.getWord());
//		}
//		return result;
//	}

	


	
}
