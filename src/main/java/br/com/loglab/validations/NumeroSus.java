package br.com.loglab.validations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = NumeroSusValidator.class)
public @interface NumeroSus {

	String message() default "Número do cartão SUS inválido.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String value() default "";
}