package com.ukrposhta.converter;

import com.ukrposhta.model.dto.TicketDto;
import com.ukrposhta.model.entity.Ticket;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TicketToDtoConverter implements Converter<Ticket, TicketDto> {

    private final TicketCommentToDtoConverter commentToDtoConverter;

    public TicketToDtoConverter(TicketCommentToDtoConverter commentToDtoConverter) {
        this.commentToDtoConverter = commentToDtoConverter;
    }

    @Override
    public TicketDto convert(Ticket ticket) {
        final TicketDto dto = new TicketDto();
        dto.setId(ticket.getId());
        dto.setDate(ticket.getDate());
        dto.setDescription(ticket.getDescription());
        dto.setStatus(ticket.getStatus());
        dto.setComment(Objects.nonNull(ticket.getComment()) ? commentToDtoConverter.convert(ticket.getComment()) : null);
        return dto;
    }
}
