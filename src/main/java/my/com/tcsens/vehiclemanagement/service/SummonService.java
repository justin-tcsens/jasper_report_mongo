package my.com.tcsens.vehiclemanagement.service;

import lombok.val;
import lombok.var;
import my.com.tcsens.vehiclemanagement.dto.SummonDto;

import my.com.tcsens.vehiclemanagement.entity.ReportDocument;
import my.com.tcsens.vehiclemanagement.model.SummonSummary;
import my.com.tcsens.vehiclemanagement.repository.ReportDocumentRepository;
import my.com.tcsens.vehiclemanagement.repository.SummonRepository;
import org.apache.commons.io.FileUtils;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SummonService {
    private final SummonRepository summonRepository;
    private final ReportService reportService;
    private final ReportDocumentRepository reportDocumentRepository;

    public SummonService(
            SummonRepository summonRepository,
            ReportService reportService,
            ReportDocumentRepository reportDocumentRepository) {
        this.summonRepository = summonRepository;
        this.reportService = reportService;
        this.reportDocumentRepository = reportDocumentRepository;
    }

    public List<SummonDto> getSummonByCarPlateNumber(String carPlateNumber) {
        return summonRepository.getSummonsByVehicleNumber(carPlateNumber)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public Resource getSummonSummaryReport(String carPlateNumber) {
        try {
            val summonSummary = getSummonSummary(carPlateNumber);
            val report = reportService.generateReport(summonSummary);
            storeDocument(report);
            return new InputStreamResource(new FileInputStream(report));
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //TODO: Implement logic to store document in mongoDB
    private void storeDocument(File file) {
        try {
            val document = new ReportDocument()
                    .setId(file.getName())
                    .setUploadTime(LocalDateTime.now())
                    .setDocument(new Binary(BsonBinarySubType.BINARY, FileUtils.readFileToByteArray(file)));
            val reportId = reportDocumentRepository.insert(document).getId();
            System.out.println("Report save successfully with Id: " + reportId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private List<SummonSummary> getSummonSummary(String carPlateNumber) {
        //TODO: Implement logic to retrieval summon information
        val summonDetail = summonRepository.getSummonSummary(carPlateNumber);
        return summonDetail;
    }
}
