package my.com.tcsens.vehiclemanagement.controller;

import my.com.tcsens.vehiclemanagement.api.SummonApi;
import my.com.tcsens.vehiclemanagement.dto.Summon;
import my.com.tcsens.vehiclemanagement.service.SummonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SummonController implements SummonApi {

    private final SummonService summonService;

    public SummonController(SummonService summonService) {
        this.summonService = summonService;
    }

    @Override
    public ResponseEntity<List<Summon>> getSummonByCriteria(String carPlateNumber) {
        return ResponseEntity.ok(summonService.getSummonByCarPlateNumber(carPlateNumber));
    }
}
