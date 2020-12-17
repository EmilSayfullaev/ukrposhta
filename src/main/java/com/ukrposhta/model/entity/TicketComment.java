package com.ukrposhta.model.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "ukrposhta",name = "comments")
public class TicketComment extends AuditableEntity {

	@Id
	@GeneratedValue(generator = "comment_entity_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(schema = "ukrposhta", catalog = "sequences", name = "comment_entity_seq",
			sequenceName = "comments_entity_id_pk", allocationSize = 1)
	@Column(name = "comment_id")
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			schema = "ukrposhta",
			name = "ticket_comment",
			joinColumns =
			@JoinColumn(name = "comment_id"),
			inverseJoinColumns =
			@JoinColumn(name = "ticket_id", nullable = false, unique = true)
	)
	private Ticket ticket;

	@Column(name = "comment_date")
	private LocalDateTime date;

	@Column
	private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
