package com.ukrposhta.service;

import com.ukrposhta.model.dto.TicketDto;

import java.util.List;

public interface TicketService {
    TicketDto findById(Long id);

    TicketDto create(TicketDto ticket);

    TicketDto update(TicketDto ticket);

    List<TicketDto> findAll();

    void delete(Long id);
}
