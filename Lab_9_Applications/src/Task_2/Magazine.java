package Task_2;

public class Magazine extends Publication {
	private String name;

	public Magazine(String title, int pageNum, int year, String author, double price, String name) {
		super(title, pageNum, year, author, price);
		this.name = name;
	}

	
	
	
	
	@Override
	public String toString() {
		return "/n Magazine [name=" + name + ", getYear()=" + getYear() + ", getAuthor()=" + getAuthor() + ", getPrice()="
				+ getPrice() + ", getPageNum()=" + getPageNum() + ", getTitle()=" + getTitle() +"]";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}





	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}





	@Override
	public int getPageNumOfChap() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNamemagazine() {
		// TODO Auto-generated method stub
		return getName();
	}

	
}
