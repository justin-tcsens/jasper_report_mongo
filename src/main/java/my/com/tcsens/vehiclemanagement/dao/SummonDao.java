package my.com.tcsens.vehiclemanagement.dao;

import lombok.val;
import my.com.tcsens.vehiclemanagement.model.SummonModel;
import my.com.tcsens.vehiclemanagement.model.VehicleModel;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.util.List;

@Component
public class SummonDao {

    private final DataSource dataSource;
    private final EntityManager entityManager;

    public SummonDao(
        DataSource dataSource,
        EntityManager entityManager) {
        this.dataSource = dataSource;
        this.entityManager = entityManager;
    }

    public List<SummonModel> getSummonByCarPlateNumber(int vehicleId) {
        val jql = " from SummonModel where vehicle_id = " + vehicleId;
        TypedQuery<SummonModel> q = entityManager.createQuery(jql, SummonModel.class);
        return q.getResultList();
    }

}
