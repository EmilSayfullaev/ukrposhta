package com.ukrposhta.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ukrposhta.config.MvcLayerEmbeddedDataSourceTestConfig;
import com.ukrposhta.converter.TicketToDtoConverter;
import com.ukrposhta.model.dto.TicketDto;
import com.ukrposhta.model.entity.Ticket;
import com.ukrposhta.repository.TicketRepository;
import com.ukrposhta.service.TicketServiceImpl;
import com.ukrposhta.test.BaseClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {MvcLayerEmbeddedDataSourceTestConfig.class})
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class TicketControllerIntegrationTest extends BaseClass {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mvc;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketToDtoConverter ticketToDtoConverter;

    @MockBean
    TicketServiceImpl ticketService;

    private final String path = "/api/tickets";

    @Test
    void findOne() throws Exception {

        mvc.perform(get(path + "/" + 10L)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.description", is("description")))
                .andExpect(jsonPath("$.id", is(10)))
                .andExpect(jsonPath("$.status", is("OPEN")))
                .andExpect(jsonPath("$.comment", notNullValue()))
                .andExpect(jsonPath("$.comment.comment", is("comment")));
    }

    @Test
    void findAll() throws Exception {
        mvc.perform(get(path))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.[0].description", is("description")))
                .andExpect(jsonPath("$.[0].id", is(10)))
                .andExpect(jsonPath("$.[0].status", is("OPEN")));
    }

    @Test
    void create() throws Exception {
        TicketDto dto = getTicketDto();

        mvc.perform(post(path + "/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE).
                        content(objectMapper.writeValueAsBytes(dto)))
                .andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        Ticket ticket = ticketRepository.findById(10L).orElse(null);
        assert ticket != null;
        TicketDto dto = ticketToDtoConverter.convert(ticket);
        assert dto != null;
        dto.setDescription("updated");

        mvc.perform(put(path + "/" + ticket.getId())
                .contentType(MediaType.APPLICATION_JSON_VALUE).
                        content(objectMapper.writeValueAsBytes(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.description", is("updated")))
                .andExpect(jsonPath("$.id", is(10)))
                .andExpect(jsonPath("$.status", is("OPEN")))
                .andExpect(jsonPath("$.comment", notNullValue()))
                .andExpect(jsonPath("$.comment.comment", is("comment")));
    }

    @Test
    void deleteTicket() throws Exception {

        mvc.perform(delete(URI.create(path + "/" + 10L)))
                .andExpect(status().isNoContent());
    }
}