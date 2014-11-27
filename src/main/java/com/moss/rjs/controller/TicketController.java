package com.moss.rjs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moss.rjs.model.Ticket;

@RequestMapping("api/ticket")
@RestController
public class TicketController {
    
    private List<Ticket> ticketList = new ArrayList<Ticket>();
    
    public TicketController() {
        for (int i = 1; i < 10; i++) {
            Ticket ticket = new Ticket();
            ticket.setNo(i);
            ticket.setSubject("Subject " + i);
            ticket.setCreateDate(new Date());
            ticketList.add(ticket);
        }
    }
    
    @RequestMapping(value="", method=RequestMethod.GET)
    public List<Ticket> getTicketList() {
        return ticketList;
    }
    
}
