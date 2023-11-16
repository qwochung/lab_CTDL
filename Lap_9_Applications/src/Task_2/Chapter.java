package Task_2;

public class Chapter {
	private String name;
	private int pageNum;
	public Chapter(String name, int pageNum) {
		super();
		this.name = name;
		this.pageNum = pageNum;
	}
	@Override
	public String toString() {
		return "\n"+"Chapter [name=" + name + ", pageNum=" + pageNum + "]";
	}
	/**
	 * @return the pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}
	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	

}
