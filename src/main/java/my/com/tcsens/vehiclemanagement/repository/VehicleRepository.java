package my.com.tcsens.vehiclemanagement.repository;

import lombok.val;
import lombok.var;
import my.com.tcsens.vehiclemanagement.dto.VehicleDto;
import my.com.tcsens.vehiclemanagement.model.tables.pojos.Vehicle;
import org.jooq.DSLContext;

import org.jooq.Record;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static my.com.tcsens.vehiclemanagement.model.tables.Vehicle.VEHICLE;


@Repository
public class VehicleRepository {
    public final DSLContext dsl;

    public VehicleRepository (DSLContext dsl) {
        this.dsl = dsl;
    }

    public VehicleDto createVehicle(Vehicle vehicle) {
        val result =  dsl.insertInto(VEHICLE)
                .set(VEHICLE.CARPLATE_NUM, vehicle.getCarplateNum())
                .set(VEHICLE.MAKE, vehicle.getMake())
                .set(VEHICLE.MODEL, vehicle.getModel())
                .set(VEHICLE.CHASSIS_NUM, vehicle.getChassisNum())
                .set(VEHICLE.AXLES_NUM, vehicle.getAxlesNum())
                .set(VEHICLE.TYRE_NUM, vehicle.getTyreNum())
                .set(VEHICLE.ROADTAX_EXPIRY, vehicle.getRoadtaxExpiry())
                .set(VEHICLE.MANUFACTURE_YEAR, vehicle.getManufactureYear())
                .returning().fetchOne().into(Vehicle.class);

        if(Objects.isNull(result)) {
            return null;
        }

        return mapDto(result);
    }

    public List<VehicleDto> getVehicleById(int vehicleId) {
        val result =  dsl.select()
                .from(VEHICLE)
                .where(VEHICLE.ID.eq(vehicleId))
                .fetchInto(Vehicle.class);

        if(Objects.isNull(result)) {
            return null;
        }

        return result.stream().map(this::mapDto).collect(Collectors.toList());
    }

    public List<VehicleDto> getVehicleEnquiry(String manufactureYear, String carPlateNum, int pageSize, int pageNum) {
        var condition = DSL.noCondition();

        if(StringUtils.hasLength(manufactureYear)) {
            condition = condition.and(VEHICLE.MANUFACTURE_YEAR.eq(manufactureYear));
        }

        if(StringUtils.hasLength(carPlateNum)) {
            condition = condition.and(VEHICLE.CARPLATE_NUM.eq(carPlateNum));
        }

        val result =  dsl.select()
                .from(VEHICLE)
                .where(condition)
                .limit(pageSize)
                .offset(pageNum * pageSize)
                .fetchInto(Vehicle.class);

        if(Objects.isNull(result)) {
            return null;
        }

        return result.stream().map(this::mapDto).collect(Collectors.toList());
    }

    private VehicleDto mapDto(Vehicle vehicleProfile) {
        return new VehicleDto()
                .id(vehicleProfile.getId().longValue())
                .carPlatNumber(vehicleProfile.getCarplateNum())
                .carMake(vehicleProfile.getMake())
                .carModel(vehicleProfile.getModel())
                .chassisNumber(vehicleProfile.getChassisNum())
                .axlesCount(vehicleProfile.getAxlesNum())
                .tyreCount(vehicleProfile.getTyreNum())
                .roadTaxExpiryDate(vehicleProfile.getRoadtaxExpiry())
                .manufactureDate(vehicleProfile.getManufactureYear());
    }
}
