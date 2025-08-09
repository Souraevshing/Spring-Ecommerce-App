package com.ecomm.ecommerce.validation;

import com.ecomm.ecommerce.dto.UserRoles;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserRoleValidator implements ConstraintValidator<ValidUser, UserRoles> {

    @Override
    public void initialize(ValidUser constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRoles value, ConstraintValidatorContext context) {
        return value == UserRoles.ADMIN || value == UserRoles.CUSTOMER;
    }

}
