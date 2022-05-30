package ru.itmatveev.parsecryptopair.data;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExmoPairModel {
    private long id;
    private String pairName;
    private String editName;//удаляем символ "_" для адекватного сравнения пар между биржами
    private BigDecimal sell;// почём мы можем продать
    private BigDecimal buy;//почём мы можем купить
}
