package my.com.tcsens.vehiclemanagement.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "vehicle")
public class VehicleModel {
    @Id
    private int id;

    @Column(name = "carplate_num")
    private String carplatNumber;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "chassis_num")
    private String chassisNumber;

    @Column(name = "axles_num")
    private int axlesNumber;

    @Column(name = "tyre_num")
    private int tyreNumber;

    @Column(name = "roadtax_expiry")
    private String roadtaxExpiryDate;

    @Column(name = "manufacture_year")
    private String manufactureYear;

    @Column(name = "image_name")
    private String imageName;
}
