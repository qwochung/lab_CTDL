package Task_2;

import java.util.List;

public class ReferenceBook extends Publication {
	private String type; // type is a field. ex : economic field, medical....
	private List<Chapter> chapter;
	
	public ReferenceBook(String title, int pageNum, int year, String author, double price, String type,
			List<Chapter> chapter) {
		super(title, pageNum, year, author, price);
		this.type = type;
		this.chapter = chapter;
	}

	

	



	public ReferenceBook(List<Chapter> chapter) {
		this.chapter = chapter;
	}







	@Override
	public String toString() {
		return "\n"+"ReferenceBook [type=" + type + ", chapter=" + chapter.toString() + ", title=" + getTitle() + ", pageNum=" + getPageNum()
				+ ", year=" + getYear()+ ", author=" + getAuthor() + ", price=" + getPrice() + "]";
	}







	@Override
	public int getPageNumOfChap() {
		int result = 0;
		for (Chapter chapter2 : chapter) {
			if (chapter2.getPageNum() > result ) {
				result = chapter2.getPageNum();
		}	
		}
		return result;
	}







	@Override
	public String getNamemagazine() {
		// TODO Auto-generated method stub
		return null;
	}


	

	
	
	


	
}
