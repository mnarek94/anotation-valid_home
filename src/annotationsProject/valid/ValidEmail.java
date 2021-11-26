package annotationsProject.valid;

import annotationsProject.annotations.Email;
import annotationsProject.dto.CustomerDto;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class ValidEmail {
    private static final String REGEX = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";

    public static void checkEmail(CustomerDto emailDto) throws IllegalAccessException {

        Field[] fields = emailDto.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Email.class)) {
                String email = (String) field.get(emailDto);
                Pattern compile = Pattern.compile(REGEX);
                if (!compile.matcher(email).matches()){
                    System.out.println("Invalid Email ");
                }
            }
        }
    }
}
