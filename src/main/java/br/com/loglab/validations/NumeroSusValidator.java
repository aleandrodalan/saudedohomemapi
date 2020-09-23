package br.com.loglab.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumeroSusValidator implements ConstraintValidator<NumeroSus, String> {
	
	private static int somaPonderada(String s) {
		char[] cs = s.toCharArray();
		int soma = 0;
		
		for (int i = 0; i < cs.length; i++) {
			soma += Character.digit(cs[i], 10) * (15 - i);
		}
		
		return soma;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value != null) {
			if (value.matches("[1-2]\\d{10}00[0-1]\\d") || value.matches("[7-9]\\d{14}")) {
				return somaPonderada(value) % 11 == 0;
			}
		}
		
		return false;
	}
}