package ru.itmatveev.parsecryptopair.data;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FTXPairModel {
    private long id;
    private String pairName;
    private BigDecimal sell;// почём мы можем продать
    private BigDecimal buy;//почём мы можем купить
}
