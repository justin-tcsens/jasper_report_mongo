package my.com.tcsens.vehiclemanagement.repository;

import my.com.tcsens.vehiclemanagement.model.SummonModel;
import my.com.tcsens.vehiclemanagement.model.VehicleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SummonRepository extends CrudRepository<SummonModel, Integer> {
    @Query(value = "select s.* from summon s " +
            "inner join vehicle v on v.id = s.vehicle_id " +
            "where v.carplate_num = :carplate", nativeQuery = true
    )
    List<SummonModel> getSummonByCarPlateNumber(String carplate);
}
