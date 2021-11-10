package annotationsProject.valid;

import annotationsProject.annotations.Max;
import annotationsProject.annotations.Min;

import java.lang.reflect.Field;

public class ValidMinMax {
    public static void checkMinMax(Object minMaxDto) throws IllegalAccessException {
        Field[] fields = minMaxDto.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Min.class) && field.isAnnotationPresent(Max.class)) {
                Min annotationMin = field.getAnnotation(Min.class);
                Max annotationMax = field.getAnnotation(Max.class);
                int discountRate = (int) field.get(minMaxDto);

                if (discountRate <annotationMin.value()){
                    System.out.println("Your number is lower than the minimum discount rate");
                }
                if (discountRate>annotationMax.value()){
                    System.out.println("Your number exceeds the maximum discount rate");
                }
            }
        }
    }
}
