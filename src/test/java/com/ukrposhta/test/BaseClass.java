package com.ukrposhta.test;

import com.ukrposhta.model.dto.TicketCommentDto;
import com.ukrposhta.model.dto.TicketDto;
import com.ukrposhta.model.entity.Ticket;
import com.ukrposhta.model.entity.TicketComment;
import com.ukrposhta.model.entity.TicketStatus;

import java.time.LocalDateTime;

public class BaseClass {

    public Ticket getTicket() {
        Ticket ticket = new Ticket();
        ticket.setDate(LocalDateTime.now());
        ticket.setDescription("description");
        ticket.setStatus(TicketStatus.OPEN);
        ticket.setComment(getComment());
        return ticket;
    }

    public TicketComment getComment() {
        TicketComment comment = new TicketComment();
        comment.setDate(LocalDateTime.now());
        comment.setComment("comment");
        return comment;
    }

    public TicketCommentDto getCommentDto() {
        TicketCommentDto dto = new TicketCommentDto();
        dto.setDate(LocalDateTime.now());
        dto.setComment("comment");
        return dto;
    }

    public TicketDto getTicketDto() {
        TicketDto dto = new TicketDto();
        dto.setDate(LocalDateTime.now());
        dto.setDescription("description");
        dto.setStatus(TicketStatus.OPEN);
        dto.setComment(getCommentDto());
        return dto;
    }
}
