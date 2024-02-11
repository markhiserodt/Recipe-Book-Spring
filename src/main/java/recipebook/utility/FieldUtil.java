package recipebook.utility;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.lang.reflect.Field;
import java.util.List;

public class FieldUtil {
    public static void filterFields(Object object, List<String> fields) {
        try {
            Class<?> clazz = object.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonIgnore.class)) {
                    continue;
                }
                if (field.getType().equals(String.class) || field.getType().isPrimitive()) {
                    System.out.println(field.getName());
                    if (!fields.contains(field.getName())) {
                        if (field.getName().equals("id") || field.getName().equals("name") || field.getName().equals("foodGroup")) {
                            field.set(object, null);
                        }
                    }
                } else {
                    filterFields(field.get(object), fields);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
