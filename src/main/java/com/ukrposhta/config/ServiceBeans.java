package com.ukrposhta.config;

import com.ukrposhta.converter.TicketDtoToEntityConverter;
import com.ukrposhta.converter.TicketToDtoConverter;
import com.ukrposhta.repository.TicketRepository;
import com.ukrposhta.service.TicketService;
import com.ukrposhta.service.TicketServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBeans {

    @Bean
    public TicketService ticketService(final TicketRepository ticketRepository,
                                       final TicketToDtoConverter ticketToDtoConverter,
                                       final TicketDtoToEntityConverter ticketDtoToEntityConverter) {

        return new TicketServiceImpl(ticketRepository, ticketToDtoConverter, ticketDtoToEntityConverter);
    }
}
