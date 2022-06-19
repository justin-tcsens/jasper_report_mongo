package my.com.tcsens.vehiclemanagement.repository;


import lombok.val;
import lombok.var;
import my.com.tcsens.vehiclemanagement.dto.SummonDto;
import my.com.tcsens.vehiclemanagement.model.SummonDetail;
import my.com.tcsens.vehiclemanagement.model.SummonSummary;
import my.com.tcsens.vehiclemanagement.model.tables.pojos.Summon;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static my.com.tcsens.vehiclemanagement.model.tables.Summon.SUMMON;
import static my.com.tcsens.vehiclemanagement.model.tables.Vehicle.VEHICLE;


@Repository
public class SummonRepository {
    private final DSLContext dsl;

    public SummonRepository (DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<SummonDto> getSummonsByVehicleNumber(String carPlateNumber) {
        val result =  dsl.select(SUMMON.asterisk()).from(SUMMON)
                .innerJoin(VEHICLE).on(VEHICLE.ID.eq(SUMMON.VEHICLE_ID))
                .where(VEHICLE.CARPLATE_NUM.eq(carPlateNumber))
                .fetchInto(Summon.class);

        if(Objects.isNull(result)) {
            return null;
        }

        return result.stream().map(this::mapDTO).collect(Collectors.toList());
    }

    public List<SummonDetail> getSummonSummary(String carplateNumber) {

        var condition = DSL.noCondition();

        if(StringUtils.hasLength(carplateNumber)) {
            condition = VEHICLE.CARPLATE_NUM.eq(carplateNumber);
        }

        val result = dsl.select(
                VEHICLE.CARPLATE_NUM.as("carPlateNum"),
                VEHICLE.MAKE.as("brand"),
                VEHICLE.MODEL.as("model"),
                SUMMON.FINE_AMT.as("fineAmount"),
                SUMMON.SERIAL_NUM.as("serialNumber"))
                .from(SUMMON)
                .innerJoin(VEHICLE).on(VEHICLE.ID.eq(SUMMON.VEHICLE_ID))
                .where(condition)
                .fetchInto(SummonDetail.class);

        if(Objects.isNull(result)) {
            return null;
        }
        return result;
    }

    private SummonDto mapDTO(Summon summonProfile) {
        return new SummonDto().id(summonProfile.getId().longValue())
                .serialNum(summonProfile.getSerialNum())
                .fineAmount(BigDecimal.valueOf(summonProfile.getFineAmt()))
                .location(summonProfile.getLocation_())
                .officerName(summonProfile.getOfficerName());
    }
}
