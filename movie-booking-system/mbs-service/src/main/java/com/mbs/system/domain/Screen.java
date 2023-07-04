package com.mbs.system.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class Screen {

    private int screenId;
    private String name;
    private List<ScreenSeat> seats = new ArrayList<>();
    private Theatre theatre;
    private Show show;

}
