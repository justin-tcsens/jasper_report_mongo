package my.com.tcsens.vehiclemanagement.service;

import lombok.val;
import my.com.tcsens.vehiclemanagement.dao.SummonDao;
import my.com.tcsens.vehiclemanagement.dao.VehicleDao;
import my.com.tcsens.vehiclemanagement.dto.Summon;
import my.com.tcsens.vehiclemanagement.dto.Vehicle;
import my.com.tcsens.vehiclemanagement.model.SummonModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SummonService {
    private final SummonDao summonDao;
    private final VehicleService vehicleService;

    public SummonService(
            SummonDao summonDao,
            VehicleService vehicleService) {
        this.summonDao = summonDao;
        this.vehicleService = vehicleService;
    }

    public List<Summon> getSummonByCarPlateNumber(String carPlateNumber) {
        val vehicle = vehicleService.getVehicles(carPlateNumber).stream().findFirst().orElse(new Vehicle().id(0L));

        return summonDao.getSummonByCarPlateNumber(vehicle.getId().intValue())
                .stream()
                .filter(Objects::nonNull)
                .map(this::mapDTO)
                .collect(Collectors.toList());
    }

    private Summon mapDTO(SummonModel summonProfile) {
        return new Summon().id(summonProfile.getId())
                .serialNum(summonProfile.getSerialNumber())
                .fineAmount(BigDecimal.valueOf(summonProfile.getFineAmount()))
                .location(summonProfile.getLocation_())
                .officerName(summonProfile.getOfficerName());
    }
}
