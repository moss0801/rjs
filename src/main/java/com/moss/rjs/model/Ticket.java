package com.moss.rjs.model;

import java.util.Date;

import lombok.Data;

@Data
public class Ticket {
    private Integer no;
    private Boolean important;
    private Boolean hasNote;
    private Boolean isReInquiry;
    private String subject;
    private Integer serviceNo;
    private Integer inquiryTypeNo;
    private Integer channelNo;
    private Date createDate;
    private Date solveDate;
    private String assignee;
}
