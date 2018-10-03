package org.sample.repo;

import javax.transaction.Transactional;

import org.sample.domain.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {

}
