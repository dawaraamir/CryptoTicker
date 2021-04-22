package com.dawar.CryptoTicker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class CryptoTickerApplication {
	private static final Logger log = LoggerFactory.getLogger(CryptoTickerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CryptoTickerApplication.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Scheduled(fixedRate = 5000)
	public void newTicker() {
		RestTemplate restTemplate = new RestTemplate();
		Info[] info = restTemplate.getForObject("https://api.n.exchange/en/api/v1/price/BTCLTC/latest/?format=json&market_code=nex", Info[].class);
		log.info(info[0].toString());
	}
}
