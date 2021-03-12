package com.ukrposhta.service;

import com.ukrposhta.converter.TicketDtoToEntityConverter;
import com.ukrposhta.converter.TicketToDtoConverter;
import com.ukrposhta.model.dto.TicketDto;
import com.ukrposhta.model.entity.Ticket;
import com.ukrposhta.repository.TicketRepository;
import com.ukrposhta.test.BaseClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TicketServiceTest extends BaseClass {

    private TicketRepository ticketRepository;

    private TicketToDtoConverter ticketToDtoConverter;

    private TicketDtoToEntityConverter ticketDtoToEntityConverter;

    private TicketServiceImpl ticketService;

    private final Long TICKET_ID =  10L;

    @BeforeEach
    public void setup() {
        ticketRepository = mock(TicketRepository.class);
        ticketToDtoConverter = mock(TicketToDtoConverter.class);
        ticketDtoToEntityConverter = mock(TicketDtoToEntityConverter.class);
        ticketService = new TicketServiceImpl(ticketRepository, ticketToDtoConverter, ticketDtoToEntityConverter);
    }

    @Test
    public void findById() {
        Ticket ticket = getTicket();

        TicketDto dto = getTicketDto();

        doReturn(Optional.of(ticket)).when(ticketRepository).findById(TICKET_ID);

        doReturn(dto).when(ticketToDtoConverter).convert(any(Ticket.class));

        TicketDto result = ticketService.findById(TICKET_ID);

        verify(ticketRepository).findById(TICKET_ID);

        verify(ticketToDtoConverter).convert(ticket);

        assertEquals(result, dto);
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
    }

    @Test
    void delete() {
    }

}