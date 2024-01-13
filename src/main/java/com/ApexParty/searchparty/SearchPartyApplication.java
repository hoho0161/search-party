package com.ApexParty.searchparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SearchPartyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchPartyApplication.class, args);
	}

}
