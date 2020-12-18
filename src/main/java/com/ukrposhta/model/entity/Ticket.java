package com.ukrposhta.model.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "ukrposhta", name = "tickets")
public class Ticket extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "ticket_entity_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "ukrposhta", catalog = "sequences", name = "ticket_entity_seq",
            sequenceName = "tickets_entity_id_pk", allocationSize = 1)
    @Column(name = "ticket_id")
    private Long id;

    @Column(name = "ticket_date")
    private LocalDateTime date;

    @Column
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            schema = "ukrposhta",
            name = "ticket_comment",
            joinColumns =
                    @JoinColumn(name = "ticket_id"),
            inverseJoinColumns =
                    @JoinColumn(name = "comment_id", nullable = false, unique = true)
    )
    private TicketComment comment;

    @Column
    @Enumerated(EnumType.STRING)
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

    public TicketComment getComment() {
        return comment;
    }

    public void setComment(TicketComment comment) {
        this.comment = comment;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
