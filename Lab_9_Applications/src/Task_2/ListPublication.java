package Task_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ListPublication {
	private static  List<Publication> Publications = new ArrayList<>();

	public  void add(Publication publication) {
		Publications.add(publication);
	}
	
	
	

	
	
	
	
	
//	Phương thức kiểm tra ấn phẩm là tạp chí và có thời gian xuất bản cách đây
//	(2021) 10 năm hay không
	public   boolean checkTime(Publication Publication, int year) {
		if (Publication  instanceof Magazine  && 
			(year -Publication.getYear() == 10)	) {
			  return true;
		}
		return false;
	}
	


//	Phương thức kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không
	public   boolean similer(Publication p1, Publication p2) {
		if (p1.getType().equalsIgnoreCase(p2.getType()) && 
				(p1.getAuthor().equalsIgnoreCase(p2.getAuthor()))) {
			return true;
		}
		return false;
	}


//	Tính tổng tiền của tất các ấn phẩm trong nhà sách
	public  double sum() {
		double result = 0;
		for (Publication publication : Publications) {
			result += publication.getPrice();
		}
		return result;
	}


	
//	Tìm quyển sách tham khảo có chương sách nhiều trang nhất
	public   Publication findMaxChap () {
		if (Publications.isEmpty()) {
			return null;
		}
		
		Publication result  = new ReferenceBook(new ArrayList<Chapter>(List.of(new Chapter(null, 0))));
		for (Publication publication : Publications) {
			if (publication instanceof ReferenceBook &&
					publication.getPageNumOfChap() > result.getPageNumOfChap() ) {
				result = publication;
			}
		}
		return result;
	}
	
	
	
	
//	Tìm xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước
//	hay không?
	public   boolean findNameMagazine( String name) {
		for (Publication publication : Publications) {
			if (publication instanceof Magazine && 
					 publication.getNamemagazine().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	
	
//	Lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước
	public List<Magazine> findListMagazine(int year) {
		List<Magazine> result = new ArrayList<>();
		for (Publication publication : Publications) {
			if (publication instanceof Magazine && publication.getYear() == year) {
				result.add((Magazine) publication);
			}
		}
		
		return result;
	}
	
	
	
//	13)Sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản (sử
//			dụng interface Comparable hoặc Comparator)
	
	public Set<Publication>	increaseSort() {
		Comparator<Publication> comparator	 = new Comparator<Publication>() {
			
			@Override
			public int compare(Publication o1, Publication o2) {
				// TODO Auto-generated method stub
				return o1.getTitle().compareToIgnoreCase(o2.getTitle());
			}
		};
		Set<Publication> result = new TreeSet<>(comparator);
		result.addAll(Publications);
		
		return result;
	}

	
	public void decreaseSort() {
		Publications.sort(new Comparator<Publication>() {

			@Override
			public int compare(Publication o1, Publication o2) {
				// TODO Auto-generated method stub
				return o1.getYear() - o2.getYear();
			}
		});
	}
	
	
	
//	Thống kê số lượng ấn phẩm theo năm xuất bản. Ví dụ 2020: 5, 2021: 10, …
//	năm 2020 có 5 ấn phẩm, năm 2021 có 10 ấn phẩm.
	public Map<Integer, Integer> statistical() {
		Map<Integer, Integer> result = new HashMap<>();
		for (Publication publication : Publications) {
			
			if (result.containsKey(publication.getYear())) {
				result.put(publication.getYear(), result.get(publication.getYear())+1);
			}
			else {
				result.put(publication.getYear(), 1);
			}
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public String toString() {
		return Publications.toString();
	}
















	public static void main(String[] args) {
//		 Chapter
			Chapter chap1 = new Chapter("Chap1 ", 200);
			Chapter chap2 = new Chapter("Chap2 ", 400);
			Chapter chap3 = new Chapter("Chap3 ", 100);
			Chapter chap4 = new Chapter("Chap4 ", 600);
			Chapter chap5 = new Chapter("Chap5 ", 300);
			Chapter chap6 = new Chapter("Chap6 ", 800);
			
			
//			ReferenceBook 
			Publication ReferenceBook1 = new ReferenceBook("ReferenceBook1", 100, 2023, "Nope", 20.2, "Economic",
												new ArrayList<Chapter>(List.of(chap1, chap2, chap3)));
			
			Publication ReferenceBook2 = new ReferenceBook("ReferenceBook2", 400, 2015, "King", 50.2, "Medical",
					new ArrayList<Chapter>(List.of(chap4, chap5, chap6)));
			
//			Magazine
			Publication Magazine1  = new Magazine("Magazine1", 20, 2022, "John", 10.5, "New Star");
			Publication Magazine2 = new Magazine("Magazine2", 15, 2022, "Key", 12.5, "Old Star");
			Publication Magazine3 = new Magazine("Magazine3", 30, 2013, "Smit", 13.5, "Mid Star");
			Publication Magazine4  = new Magazine("Magazine4", 25, 2002, "John", 19.5, "New Star");

			ListPublication listpPublications	= new ListPublication();
			listpPublications.add(ReferenceBook1);
			listpPublications.add(ReferenceBook2);
			listpPublications.add(Magazine1);
			listpPublications.add(Magazine2);
			listpPublications.add(Magazine3);
			listpPublications.add(Magazine4);
		
			
			
//			System.out.println(listpPublications.toString());
//			System.out.println(Magazine4.getType());
//			System.out.println(listpPublications.checkTime(ReferenceBook1,2023));
//			System.out.println(listpPublications.checkTime(Magazine3,2023));
//			System.out.println(listpPublications.similer(Magazine1, Magazine4));
//			System.out.println(listpPublications.sum());
//			System.out.println(listpPublications.findMaxChap());
//			System.out.println(listpPublications.findNameMagazine("New Star"));
//			System.out.println(listpPublications.findListMagazine(2022));
//			System.out.println(listpPublications.increaseSort());
//			listpPublications.decreaseSort();
//			System.out.println(listpPublications.toString());
//			System.out.println(listpPublications.statistical().toString());
			
	}

}
