package org.sample.controller;

import java.util.List;

import org.sample.domain.Ticket;
import org.sample.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping(value = "findAll")
	public ResponseEntity<Object> dashboard() {
		List<Ticket> ticketList = ticketService.findAllTicket();
		return new ResponseEntity<>(ticketList, HttpStatus.OK);
	}

	@GetMapping(value = "getById")
	public ResponseEntity<Object> getTicketDetailsById(@RequestParam("ticketId") Integer ticketId) {
		Ticket ticket = ticketService.findTicketById(ticketId);
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}

	@DeleteMapping(value = "deleteById")
	public ResponseEntity<Object> deleteTicketById(@RequestParam("ticketId") Integer ticketId) {
		ticketService.deleteTicketById(ticketId);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

	@PutMapping(value = "update")
	public ResponseEntity<Object> updateTicketDetails(@RequestBody Ticket ticket) {
		ticketService.updateTicket(ticket);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

}
