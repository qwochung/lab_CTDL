package Task_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	String name, address;
	List<Course> courses;
	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}
	
	
//	Phương thức public Course getMaxPracticalCourse() trả về course thực
//	hành có nhiều sinh viên đăng ký học nhất.
	 public Course getMaxPracticalCourse() {
		 if (courses.size() == 0) {
			return null;
		 	}
		 Course result = courses.get(0);
		 for (Course course : courses) {
			if (course.isPractice() && (course.size()>= result.size())) {
				result = course;
			}
		}
		 
		 return result;
	 }

	 
	 
//	 Phương thức public Map<Integer, List<Student>> groupStudentsByYear()
//	 để thống kê danh sách sinh viên theo năm vào học, với key là năm vào học và
//	 value là các sinh viên tương ứng.

	 public Map<Integer, List<Student>> groupStudentsByYear(){
		 Map<Integer, List<Student>> result = new HashMap<>();
		 Set<Student> students = getListStudents();
		 
		 for (Student student : students) {
			if (!result.containsKey(student.getYear())) {
				result.put(student.getYear(), new ArrayList<Student>(List.of(student)));
			}
			
			else {
				 result.get(student.getYear()).add(student);
			}
		}
		 
		 
		 return result;
	 }
	 
	 
	 
	 
	 
//	 Phương thức public Set<Course> filterCourses(String type) trả về các
//	 course theo loại cho trước (type). Các course được sắp xếp giảm dần theo số
//	 lượng sinh viên đăng ký học.
	 
	 public Set<Course> filterCourses(String type){
		 Comparator<Course> comparator = new Comparator<Course>() {
			
			@Override
			public int compare(Course o1, Course o2) {
				// TODO Auto-generated method stub
				return o1.size() - o2.size();
			}
		};
		 
		 Set<Course> result = new TreeSet<>(comparator);
		 for (Course course : courses) {
			 if (course.getType().equals(type)) {
				 result.add(course);
				
			}
		 }
	

		 
		 return result;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
//	Vì 1 sv có thể đk nhiều khóa học nên cần 1 danh sách sv ko trùng lặp
	 public Set<Student>getListStudents() {
		 Set<Student> result = new HashSet<Student>();
		for (Course course : courses) {
			result.addAll(course.students);
		}
		 return result;
	
	}



	@Override
	public String toString() {
		return "Faculty [name=" + name + ", address=" + address + ", courses=" + courses.toString() + "]" ;
	}



	public static void main(String[] args) {
//		 Student
		 Student st1 = new Student("1", "A", 2022);
		 Student st2 = new Student("2", "B", 2022);
		 Student st3 = new Student("3", "C", 2022);
		 Student st4 = new Student("4", "F", 2022);
		 Student st5 = new Student("5", "D", 2021);
		 Student st6 = new Student("6", "E", 2021);
		 Student st7 = new Student("7", "Q", 2020);
		 
		
		 
//		 Course 
		 
		 Course course2 = new Course("c2", "TRR", "Li thuyet", new ArrayList<Student>(List.of(st7, st6, st3 ,st5)), "NVD");
		 Course course3 = new Course("c3", "GTNM", "Thuc hanh", new ArrayList<Student>(List.of(st1, st2, st3)), "NVD");
		 Course course1 = new Course("c1", "CTDL", "Thuc hanh", new ArrayList<Student>(List.of(st1, st2, st3, st4, st5)), "NVD");
		 
//		 Faculty
		 Faculty faculty = new Faculty("CNTT", "NLU", new ArrayList<Course>(List.of(course1, course2, course3)));
		 
		 
		 System.out.println(faculty.toString());
		 
		 System.out.println(faculty.getMaxPracticalCourse());
		 
		 System.out.println(faculty.getListStudents().toString());
		 System.out.println(faculty.groupStudentsByYear().toString());
		 System.out.println(faculty.filterCourses("Thuc hanh").toString());
		 
	}
}
