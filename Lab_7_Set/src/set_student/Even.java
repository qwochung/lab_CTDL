package set_student;

import java.util.function.Predicate;

public class Even<T> implements Predicate<T> {

	
	
	@Override
	public boolean test(T t) {
		if (t instanceof Integer) {
            Integer i = (Integer) t;
            return i % 2 == 0;
            
            
        } else if (t instanceof String) {
            String string = (String) t;
            return string.length() > 5;
	}
		return false;}
	
	
}