package com.ukrposhta.controller;

import com.ukrposhta.model.dto.TicketDto;
import com.ukrposhta.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TicketDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.findById(id));
    }

    @GetMapping
    public List<TicketDto> findAll() {

        return ticketService.findAll();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<TicketDto> create(@RequestBody TicketDto dto) {

        return ResponseEntity.ok(ticketService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDto> update(@PathVariable("id") long id, @RequestBody TicketDto dto) {

        return ResponseEntity.ok(ticketService.update(dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") long id) {
        ticketService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
