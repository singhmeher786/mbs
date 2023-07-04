package com.mbs.system.domain;

import lombok.*;

@Data
public class City{
    private Long cityId;
    private String name;
    private String state;
    private String zipCode;
    private java.util.List<Theatre> theatreList;
}
