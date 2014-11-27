package com.moss.rjs.model;

import java.util.Date;

import lombok.Data;

@Data
public class Ticket {
    private Integer no;
    private String subject;
    private Date createDate;
}
