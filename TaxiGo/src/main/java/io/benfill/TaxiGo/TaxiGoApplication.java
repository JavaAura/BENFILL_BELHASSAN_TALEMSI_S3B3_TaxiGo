package io.benfill.TaxiGo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.benfill.TaxiGo")
public class TaxiGoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxiGoApplication.class, args);
	}

}
