package com.example.demo;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="CurrencyMaster")
@RibbonClient(name="CurrencyMaster")
public interface CurrencyFeignClient {
	
	@GetMapping("/convertCurrency")
	double clientResponse(@RequestParam(name = "countryCode") String countryCode, @RequestParam(name = "amount") double amount);

}
