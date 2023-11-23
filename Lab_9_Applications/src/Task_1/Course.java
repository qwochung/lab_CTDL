package Task_1;

import java.util.List;

public class Course {
	String id, title, type, lecturer;
	List<Student> students;
	public Course(String id, String title, String type,  List<Student> students,String lecturer) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.lecturer = lecturer;
		this.students = students;
	}
	@Override
	public String toString() {
		return "  \nCourse [id=" + id + ", title=" + title + ", type=" + type + ", lecturer=" + lecturer + ", students="
				+ students.toString() + "]";
	}
	public boolean isPractice() {
		// TODO Auto-generated method stub
		return type.equalsIgnoreCase("thuc hanh");
	}
	public int size() {
		// TODO Auto-generated method stub
		return students.size();
	}
	public String getType() {
		return type;
	}
	
	
	
	
	
	
	
	
	

}
