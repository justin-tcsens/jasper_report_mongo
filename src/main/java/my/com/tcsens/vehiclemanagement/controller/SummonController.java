package my.com.tcsens.vehiclemanagement.controller;

import my.com.tcsens.vehiclemanagement.api.SummonApi;
import my.com.tcsens.vehiclemanagement.dto.SummonDto;
import my.com.tcsens.vehiclemanagement.service.SummonService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<SummonDto>> getSummonByCriteria(String carPlateNumber) {
        return ResponseEntity.ok(summonService.getSummonByCarPlateNumber(carPlateNumber));
    }

    @Override
    public ResponseEntity<org.springframework.core.io.Resource> getSummonSummaryByCriteria(String carPlateNumber) {
        return ResponseEntity.ok(summonService.getSummonSummaryReport(carPlateNumber));
    }
}
