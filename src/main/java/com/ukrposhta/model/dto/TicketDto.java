package com.ukrposhta.model.dto;

import com.ukrposhta.model.entity.TicketStatus;

import java.time.LocalDateTime;

public class TicketDto {

    private Long id;
    private LocalDateTime date;
    private String description;
    private TicketCommentDto comment;
    private TicketStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketCommentDto getComment() {
        return comment;
    }

    public void setComment(TicketCommentDto comment) {
        this.comment = comment;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

}
