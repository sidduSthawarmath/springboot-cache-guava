package org.sample.util;

import org.sample.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitailDataDump {

	@Autowired
	private TicketService ticketService;

	
	@Bean
	public boolean loadDataIntoDB() {
		boolean isAnyError = false;
		try {
			ticketService.dataDump();
		} catch (Exception e) {
			isAnyError = true;
		}
		return isAnyError;
	}

}
