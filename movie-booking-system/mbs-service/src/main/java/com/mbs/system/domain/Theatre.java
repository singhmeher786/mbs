package com.mbs.system.domain;



import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
public class Theatre {
    int theatreId;
    String address;
    City city;
    List<Screen> screen = new ArrayList<>();
}
