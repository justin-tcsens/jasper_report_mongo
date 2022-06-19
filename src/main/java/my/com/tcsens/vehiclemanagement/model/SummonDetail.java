package my.com.tcsens.vehiclemanagement.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class SummonDetail {
    private String carPlateNum;
    private String brand;
    private String model;
    private String serialNumber;
    private BigDecimal fineAmount;
}
