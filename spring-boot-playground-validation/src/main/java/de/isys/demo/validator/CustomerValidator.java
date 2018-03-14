package de.isys.demo.validator;

import de.isys.demo.Address;
import de.isys.demo.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {

    private final AddressValidator addressValidator;

    public CustomerValidator(AddressValidator addressValidator) {

        if(addressValidator == null){
            throw new IllegalArgumentException("The supplied[Validator] is required and must not be null");
        }
        if(!addressValidator.supports(Address.class)){
            throw new IllegalArgumentException("The supplied [Validator] must support the validation of [Adress] instances.");
        }

        this.addressValidator = addressValidator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors,"firstName","field.required", "DEFUALT MESSAGE");
        ValidationUtils.rejectIfEmpty(errors,"lastName","field.required", "DEF");
        Customer customer = (Customer) target;

        try{
            errors.pushNestedPath("address");
            ValidationUtils.invokeValidator(this.addressValidator,customer.getAddress(),errors);
        }
        finally{
            errors.popNestedPath();
        }
    }
}
