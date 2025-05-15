package com.calendar.application;

import com.calendar.application.usecases.DatesCase;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ApplicationApplication {

	public static void main(String[] args) {
		int año = 2024;
		Date sundayFlowers = DatesCase.getstartSemanaSanta(año);
		System.out.println("domingo de ramos "  + sundayFlowers);

		Date sundayPascua = DatesCase.addDays(sundayFlowers, 7);
		System.out.println("pascua " + sundayPascua);

		Date epifania = DatesCase.NextMonday( new Date(año - 1900, 0, 6));
		System.out.println("reyes magos " + epifania);

		Date corpusChrist = DatesCase.NextMonday(DatesCase.addDays(sundayPascua, 61));
		System.out.println("corpus christi " + corpusChrist);


		Date jesushearth = DatesCase.NextMonday(DatesCase.addDays(sundayPascua, 68));
		System.out.println("corazon jesus " + jesushearth);
	}

}
