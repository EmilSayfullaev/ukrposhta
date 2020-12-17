package com.ukrposhta.converter;

import com.ukrposhta.model.dto.TicketCommentDto;
import com.ukrposhta.model.entity.TicketComment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TicketCommentToDtoConverter implements Converter<TicketComment, TicketCommentDto> {

    @Override
    public TicketCommentDto convert(TicketComment ticketComment) {
        TicketCommentDto dto = new TicketCommentDto();
        dto.setId(ticketComment.getId());
        dto.setComment(ticketComment.getComment());
        dto.setDate(ticketComment.getDate());
        return dto;
    }
}
