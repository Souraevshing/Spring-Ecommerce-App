package com.ecomm.ecommerce.validation;

import com.ecomm.ecommerce.entity.UserEntity;
import com.ecomm.ecommerce.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepository userRepository;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if(email == null) {
            return true;
        }

        List<UserEntity> existingUser = userRepository.findByEmail(email);
        return existingUser.isEmpty();
    }

}
