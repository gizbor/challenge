package com.necar.fingerprint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.necar.fingerprint"})
//@EntityScan("com.necar.fingerprint.beans")
public class FingerPrintApplication {

	public static void main(String[] args) {
		SpringApplication.run(FingerPrintApplication.class, args);
	}
}
