package com.shop.common;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Period {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    //불변객체로 생성


    public Period(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }
}
