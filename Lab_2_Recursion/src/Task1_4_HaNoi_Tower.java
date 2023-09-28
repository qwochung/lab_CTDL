
public class Task1_4_HaNoi_Tower {
	public static void moveTower(int disk, String src, String dest, String sub) {
		
		if (disk == 1) {
			System.out.println("Di chuyển đĩa " +disk+" từ " + src +" sang " +dest);
		}
		
		else {
			moveTower(disk -1, src, sub, dest);
			System.out.println("Di chuyển đĩa " +disk+" từ " + src +" sang " + dest);
			moveTower( disk -1, sub , dest, src);
		}
		
	}
	
	public static void main(String[] args) {
		moveTower(3, "A", "C", "B");
	}

}
