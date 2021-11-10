package annotationsProject.valid;

import annotationsProject.annotations.Length;

import java.lang.reflect.Field;

public class ValidLength {
    public static void checkLength(Object lengthDto ) throws IllegalAccessException {

        Field[] fields = lengthDto.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Length.class)) {
                Length annotation = field.getAnnotation(Length.class);
                String name=(String) field.get(lengthDto);
                if (name.length()<annotation.min()||name.length()>annotation.max()){
                   String msg="Wrong name " +" greater or less than the specified range "+
                            "("+annotation.min()+","+annotation.max()+")";
                    System.out.println(msg);
                }
            }
        }

    }
}
