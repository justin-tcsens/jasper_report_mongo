package my.com.tcsens.vehiclemanagement.service;

import lombok.val;
import lombok.var;
import my.com.tcsens.vehiclemanagement.dto.SummonDto;

import my.com.tcsens.vehiclemanagement.repository.SummonRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SummonService {
    private final SummonRepository summonRepository;

    public SummonService(SummonRepository summonRepository) {
        this.summonRepository = summonRepository;
    }

    public List<SummonDto> getSummonByCarPlateNumber(String carPlateNumber) {
//
//        val record = summonRepository.getSummonsByVehicleNumber(carPlateNumber);
//        var result = new ArrayList<Summon>();
//
//        if(record != null) {
//            for(my.com.tcsens.vehiclemanagement.models.tables.pojos.Summon summon: record) {
//                result.add(mapDTO(summon));
//            }
//        }
//        return result ;

        return summonRepository.getSummonsByVehicleNumber(carPlateNumber)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
