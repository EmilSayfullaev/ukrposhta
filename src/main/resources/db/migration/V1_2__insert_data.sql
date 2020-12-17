INSERT INTO ukrposhta.tickets(ticket_id, ticket_date, description, status, created, created_by, modified, modified_by )
VALUES ('1', LOCALTIMESTAMP, 'description', 'OPEN', LOCALTIMESTAMP, '111', LOCALTIMESTAMP, '222');

INSERT INTO ukrposhta.comments(comment_id, comment_date, comment, created, created_by, modified, modified_by )
VALUES ('1', LOCALTIMESTAMP, 'description', LOCALTIMESTAMP, '111', LOCALTIMESTAMP, '222');

INSERT INTO ukrposhta.ticket_comment(ticket_id, comment_id) VALUES ('1', '1');