package my.com.tcsens.vehiclemanagement.service;

import my.com.tcsens.vehiclemanagement.dto.Summon;
import my.com.tcsens.vehiclemanagement.model.SummonModel;
import my.com.tcsens.vehiclemanagement.repository.SummonRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SummonService {
    private final SummonRepository summonRepository;

    public SummonService(
            SummonRepository summonRepository) {
        this.summonRepository = summonRepository;
    }

    public List<Summon> getSummonByCarPlateNumber(String carPlateNumber) {

        return summonRepository.getSummonByCarPlateNumber(carPlateNumber)
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
