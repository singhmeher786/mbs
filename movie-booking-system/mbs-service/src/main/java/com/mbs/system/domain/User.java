package com.mbs.system.domain;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String name;
    private String password;
    private String email;
    private java.util.List<Booking> bookingList;

}
