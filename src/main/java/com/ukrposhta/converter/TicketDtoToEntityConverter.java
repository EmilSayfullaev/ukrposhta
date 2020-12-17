package com.ukrposhta.converter;

import com.ukrposhta.model.dto.TicketDto;
import com.ukrposhta.model.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TicketDtoToEntityConverter implements Converter<TicketDto, Ticket> {

    @Autowired
    private TicketCommentDtoToEntityConverter commentDtoToEntityConverter;



    @Override
    public Ticket convert(TicketDto dto) {
        Ticket ticket = new Ticket();
        ticket.setDate(dto.getDate());
        ticket.setDescription(dto.getDescription());
        ticket.setStatus(dto.getStatus());
        ticket.setComment(Objects.nonNull(dto.getComment()) ? commentDtoToEntityConverter.convert(dto.getComment()) : null);
        return ticket;
    }
}
