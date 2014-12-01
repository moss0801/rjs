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
        for (int i = 1; i < 100; i++) {
            Ticket ticket = new Ticket();
            ticket.setNo(1000000+i);
            ticket.setImportant(1 == i % 2 ? true : false);
            ticket.setHasNote(1 == i % 2 ? true : false);
            ticket.setIsReInquiry(1 == i % 2 ? true : false);
            ticket.setSubject("Subject Subject " + i);
            ticket.setCreateDate(new Date());
            ticket.setSolveDate(new Date());
            ticket.setServiceNo(i*10);
            ticket.setInquiryTypeNo(i*100);
            ticket.setChannelNo(i*1000);
            ticket.setAssignee("Assignee " + i);
            ticketList.add(ticket);
        }
    }
    
    @RequestMapping(value="", method=RequestMethod.GET)
    public List<Ticket> getTicketList() throws InterruptedException {
        return ticketList;
    }
    
}
