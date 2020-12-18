package com.ukrposhta.converter;

import com.ukrposhta.model.dto.TicketCommentDto;
import com.ukrposhta.model.entity.TicketComment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TicketCommentDtoToEntityConverter implements Converter<TicketCommentDto, TicketComment> {

    @Override
    public TicketComment convert(TicketCommentDto ticketCommentDto) {
        TicketComment comment = new TicketComment();
        comment.setId(ticketCommentDto.getId());
        comment.setDate(ticketCommentDto.getDate());
        comment.setComment(ticketCommentDto.getComment());
        return comment;
    }
}
