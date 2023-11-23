package Task_2;

import java.util.ArrayList;
import java.util.List;

public abstract class  Publication {
	private String  title;
	private int pageNum	, year ;
	private String author;
	private double price;
	public Publication(String title, int pageNum, int year, String author, double price) {
		super();
		this.title = title;
		this.pageNum = pageNum;
		this.year = year;
		this.author = author;
		this.price = price;
	}
	
	
	
	
	public Publication() {
		super();
	}



	public int getYear() {
		return year;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}


	public int getPageNum() {
		return pageNum;
	}



	public String getTitle() {
		return title;
	}

	
	
public abstract  int getPageNumOfChap() ;

public abstract  String getNamemagazine() ;
	
	
//Phương thức xác định loại của ấn phẩm (Tạp chí hay Sách tham khảo) 
public  String getType () {		
	if (this instanceof ReferenceBook) {
		return "ReferenceBook";
	}
	if (this instanceof Magazine) {
		return "Magazine";
	}
	else {
		return "No type";
	}
	
};




	

	

	
	

	



	
	
	
	
	
	
	
	
	


	











	
}
