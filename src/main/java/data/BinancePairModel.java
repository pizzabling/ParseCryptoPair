package data;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BinancePairModel {
    private long id;
    private String pairName;
    private BigDecimal sell;
    private BigDecimal buy;
}
