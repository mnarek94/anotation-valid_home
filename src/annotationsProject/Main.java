package annotationsProject;

import annotationsProject.dto.CustomerDto;
import annotationsProject.valid.ValidAdulthood;
import annotationsProject.valid.ValidEmail;
import annotationsProject.valid.ValidLength;
import annotationsProject.valid.ValidMinMax;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Narek");
        customerDto.setEmail("mnarek@gmail.com");
        customerDto.setBirthDay(LocalDate.of(1994, 9, 11));
        customerDto.setDiscountRate(-1);
        ValidLength.checkLength(customerDto);
        ValidEmail.checkEmail(customerDto);
        ValidAdulthood.checkAdulthood(customerDto);
        ValidMinMax.checkMinMax(customerDto);


    }


}
