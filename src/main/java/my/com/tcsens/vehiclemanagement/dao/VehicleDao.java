package my.com.tcsens.vehiclemanagement.dao;

import lombok.val;
import my.com.tcsens.vehiclemanagement.dto.Vehicle;
import my.com.tcsens.vehiclemanagement.model.VehicleModel;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.util.List;

@Component
public class VehicleDao {

    private final DataSource dataSource;
    private final EntityManager entityManager;

    public VehicleDao(
        DataSource dataSource,
        EntityManager entityManager) {
        this.dataSource = dataSource;
        this.entityManager = entityManager;
    }

    public List<VehicleModel> getVehicleByCarPlateNumber(String carplateNumber) {
        val jql = " from VehicleModel where carplate_num = '" + carplateNumber + "'";
        TypedQuery<VehicleModel> q = entityManager.createQuery(jql, VehicleModel.class);
        return q.getResultList();
    }

}
