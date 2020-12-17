package com.ukrposhta.service;

import com.ukrposhta.converter.TicketDtoToEntityConverter;
import com.ukrposhta.converter.TicketToDtoConverter;
import com.ukrposhta.model.dto.TicketDto;
import com.ukrposhta.model.entity.Ticket;
import com.ukrposhta.repository.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketToDtoConverter ticketToDtoConverter;
    private final TicketDtoToEntityConverter ticketDtoToEntityConverter;

    public TicketServiceImpl(TicketRepository ticketRepository, TicketToDtoConverter ticketToDtoConverter, TicketDtoToEntityConverter ticketDtoToEntityConverter) {
        this.ticketRepository = ticketRepository;
        this.ticketToDtoConverter = ticketToDtoConverter;
        this.ticketDtoToEntityConverter = ticketDtoToEntityConverter;
    }


    @Override
    public TicketDto findById(Long id) {
        Ticket entity = ticketRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ticketToDtoConverter.convert(entity);
    }

    @Override
    public TicketDto create(TicketDto dto) {
        Ticket entity = ticketDtoToEntityConverter.convert(dto);
        Ticket ticket = ticketRepository.save(entity);
        return ticketToDtoConverter.convert(ticket);
    }

    @Override
    public TicketDto update(TicketDto dto) {
        ticketRepository.findById(dto.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return create(dto);
    }

    @Override
    public List<TicketDto> findAll() {
        return ticketRepository.findAll().stream()
                .map(ticketToDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Ticket byId = ticketRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        ticketRepository.delete(byId);
    }
}
