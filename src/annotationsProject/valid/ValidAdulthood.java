package annotationsProject.valid;

import annotationsProject.annotations.Adulthood;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class ValidAdulthood {
    public static void checkAdulthood(Object adulthoodDto) throws IllegalAccessException {
        Field[] fields = adulthoodDto.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Adulthood.class)) {

                LocalDate localDate = (LocalDate) field.get(adulthoodDto);
                if (!isBefore(localDate)) {
                    System.out.println("Your age is small 18");
                }
            }

        }
    }

    private static boolean isBefore(LocalDate date) {

        if (LocalDate.now().getYear() - date.getYear() == 18) {


            if (LocalDate.now().getMonthValue() - date.getMonthValue() > 0) {


                if (LocalDate.now().getDayOfMonth() - date.getDayOfMonth() > 0) {
                    return true;
                }
            }
        } else if (LocalDate.now().getYear() - date.getYear() > 18) {
            return true;
        }
        return false;
    }

}
