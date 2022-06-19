package my.com.tcsens.vehiclemanagement.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import my.com.tcsens.vehiclemanagement.model.SummonSummary;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import net.sf.jasperreports.engine.JasperCompileManager;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
public class ReportService {
    private static final String REPORT_PATH = "/report/CarSummonReport_v3.jrxml";

    public File generateReport(SummonSummary summonSummary) throws Exception {
        try {
            val pdfTemp = File.createTempFile(UUID.randomUUID().toString(), ".pdf");
            if(!Objects.isNull(summonSummary)) {
                JasperExportManager.exportReportToPdfStream(compileJasperTemplate(mapBusinessModel(summonSummary)), new FileOutputStream(pdfTemp));
            }
            return pdfTemp;
        } catch(Exception e) {
            e.printStackTrace();
            throw new  Exception("Failed to generate report...");
        }
    }

    //TODO: Modify business model mapping here
    private Map<String, Object> mapBusinessModel(SummonSummary summonSummary) {
        return new ObjectMapper().convertValue(summonSummary, Map.class);
    }

    private JasperPrint compileJasperTemplate(Map<String, Object> map) throws Exception {
        try {
            val dummyList = Collections.singletonList(new Object());
            val jasperReport = JasperCompileManager.compileReport(getClass().getResource(REPORT_PATH).openStream());
            return JasperFillManager.fillReport(jasperReport, map, new JRBeanCollectionDataSource(dummyList));
        } catch (Exception e) {
            throw new  Exception("Failed to generate report... ");
        }
    }

}
