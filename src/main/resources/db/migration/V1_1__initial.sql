-- DROP SCHEMA IF EXISTS ukrposhta CASCADE;
CREATE SCHEMA IF NOT EXISTS ukrposhta;
COMMENT ON SCHEMA ukrposhta IS 'Ukrposhta test data schema';

-- DROP SEQUENCE IF EXISTS ukrposhta.tickets_entity_id_pk CASCADE;
CREATE SEQUENCE IF NOT EXISTS ukrposhta.tickets_entity_id_pk
INCREMENT BY 1
MINVALUE 0
MAXVALUE 2147483647
START WITH 1
CACHE 1
NO CYCLE;
COMMENT ON SEQUENCE ukrposhta.tickets_entity_id_pk IS 'A primary key autogeneration sequence';

-- DROP TABLE IF EXISTS ukrposhta.tickets CASCADE;
CREATE TABLE IF NOT EXISTS ukrposhta.tickets
(
  ticket_id BIGINT NOT NULL DEFAULT NEXTVAL('ukrposhta.tickets_entity_id_pk'),
  ticket_date TIMESTAMP ,
  description VARCHAR(100),
  status VARCHAR(10),
  created TIMESTAMP with time zone NOT NULL DEFAULT LOCALTIMESTAMP,
  created_by BIGINT NOT NULL,
  modified TIMESTAMP with time zone,
  modified_by BIGINT,
  PRIMARY KEY (ticket_id)
);

-- DROP SEQUENCE IF EXISTS ukrposhta.comments_entity_id_pk CASCADE;
CREATE SEQUENCE IF NOT EXISTS ukrposhta.comments_entity_id_pk
INCREMENT BY 1
MINVALUE 0
MAXVALUE 2147483647
START WITH 1
CACHE 1
NO CYCLE;
COMMENT ON SEQUENCE ukrposhta.comments_entity_id_pk IS 'A primary key autogeneration sequence';

-- DROP TABLE IF EXISTS ukrposhta.comments CASCADE;
CREATE TABLE IF NOT EXISTS ukrposhta.comments
(
  comment_id BIGINT NOT NULL DEFAULT NEXTVAL('ukrposhta.comments_entity_id_pk'),
  comment_date TIMESTAMP ,
  comment VARCHAR(100),
  created TIMESTAMP with time zone NOT NULL DEFAULT LOCALTIMESTAMP,
  created_by BIGINT NOT NULL,
  modified TIMESTAMP with time zone,
  modified_by BIGINT,
  PRIMARY KEY (comment_id)
);

-- DROP TABLE IF EXISTS ukrposhta.ticket_comment CASCADE;
CREATE TABLE IF NOT EXISTS ukrposhta.ticket_comment
(
  ticket_id BIGINT,
  comment_id BIGINT,
  FOREIGN KEY (ticket_id) REFERENCES ukrposhta.tickets(ticket_id),
  FOREIGN KEY (comment_id) REFERENCES ukrposhta.comments(comment_id)
);

