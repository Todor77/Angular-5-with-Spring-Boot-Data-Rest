package de.isys.demo.validator;

import de.isys.demo.Address;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AddressValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return Address.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Address a = (Address) target;
        ValidationUtils.rejectIfEmpty(errors,"address","field.required", "empty address");


        if (a != null && a.getAddress() != null && a.getAddress().length() < 3) {
            errors.reject("empty", "empty");
        }
    }
}
