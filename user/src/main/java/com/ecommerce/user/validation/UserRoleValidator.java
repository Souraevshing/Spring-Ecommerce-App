package com.ecommerce.user.validation;

import com.ecommerce.user.dto.UserRoles;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserRoleValidator implements ConstraintValidator<ValidUserRole, UserRoles> {

    @Override
    public void initialize(ValidUserRole constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRoles value, ConstraintValidatorContext context) {
        return value == UserRoles.ADMIN || value == UserRoles.CUSTOMER;
    }

}
