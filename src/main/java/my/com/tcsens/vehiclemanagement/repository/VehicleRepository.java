package my.com.tcsens.vehiclemanagement.repository;

import my.com.tcsens.vehiclemanagement.model.VehicleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<VehicleModel, Integer> {
    @Query(value = "select * from vehicle where carplate_num = :carplate", nativeQuery = true)
    List<VehicleModel> getVehicleByCarPlateNumber(String carplate);
}
