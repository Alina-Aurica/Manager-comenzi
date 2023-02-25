package start;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ReflectionExample {
	public static ArrayList<Object> values;

	public static ArrayList<String> retrieveProperties(Object object) {
		values = new ArrayList<Object>();
		ArrayList<String> fields = new ArrayList<String>();
		for (Field field : object.getClass().getDeclaredFields()) {
			fields.add(field.getName());
			field.setAccessible(true); 
			Object value;
			try {
				value = field.get(object);
				values.add(value);
				//System.out.println(field.getName() + "=" + value);

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return fields;
	}
}



