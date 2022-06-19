package my.com.tcsens.vehiclemanagement.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "summon")
public class SummonModel {
    @Id
    private long id;

    @Column(name = "vehicle_id")
    private long vehicleId;

    @Column(name = "serial_num")
    private String serialNumber;

    @Column(name = "fine_amt")
    private double fineAmount;

    @Column(name = "location_")
    private String location_;

    @Column(name = "officer_name")
    private String officerName;

}
