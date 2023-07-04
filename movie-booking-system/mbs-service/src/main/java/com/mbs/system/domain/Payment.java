package com.mbs.system.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Payment {
    private Integer paymentId;
    private BigDecimal amount;
    private LocalDateTime dateTime;
    private Integer couponId;
    private Long transactionId;
    private User user;
}
