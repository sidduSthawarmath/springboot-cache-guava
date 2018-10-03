package org.sample.service;

import java.util.Date;
import java.util.List;

import org.sample.domain.Ticket;
import org.sample.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	
	public void dataDump() {
		ticketRepository.save(new Ticket("Siddu", new Date(), "Bangalore"));
		ticketRepository.save(new Ticket("Shivu", new Date(), "Gulbarga"));
		ticketRepository.save(new Ticket("Sharnu", new Date(), "Raichur"));
		ticketRepository.save(new Ticket("Manoj", new Date(), "Gulbarga"));
	}

	public List<Ticket> findAllTicket() {
		List<Ticket> ticketList = (List<Ticket>) ticketRepository.findAll();
		return ticketList;
	}

	
	//Stores into cache
	@Cacheable(value = "ticketsCache", key = "#ticketId", unless="#result==null")
	public Ticket findTicketById(Integer ticketId) {
		System.out.println("findTicketById method called");
		Ticket ticket = ticketRepository.findOne(ticketId);
		return ticket;
	}

	//Delete from cache
	@CacheEvict(value = "ticketsCache", key = "#ticketId")
	public void deleteTicketById(Integer ticketId) {
		System.out.println("deleteTicketById method called");
		ticketRepository.delete(ticketId);
	}
	
	
	//Update the cache(Method returned value will be updated in cache)
	@CachePut(value = "ticketsCache",key = "#ticket.ticketId")
	public Ticket updateTicket(Ticket ticket) {
		System.out.println("updateTicket method called");
		return ticketRepository.save(ticket);
	}
}
