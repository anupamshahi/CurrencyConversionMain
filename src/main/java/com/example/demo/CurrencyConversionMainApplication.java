package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
@EnableFeignClients
public class CurrencyConversionMainApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(CurrencyConversionMainApplication.class);
	
	@Autowired
	private CurrencyFeignClient currencyClient;
	
	@RequestMapping("/convertCurrency")
	public double home(String countryCode,Double amount) {
		logger.info("into main class "+ countryCode + " "+amount);
		double value = currencyClient.clientResponse(countryCode, amount);
		return value;
	}

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionMainApplication.class, args);
	}

}
