package my.com.tcsens.vehiclemanagement.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class SummonSummary {
    private String carPlateNum;
    private String brand;
    private String model;
    private int totalSummon;
    private BigDecimal totalAmount;
}
