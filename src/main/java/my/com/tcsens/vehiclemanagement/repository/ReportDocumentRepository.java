package my.com.tcsens.vehiclemanagement.repository;

import my.com.tcsens.vehiclemanagement.entity.ReportDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportDocumentRepository extends MongoRepository<ReportDocument, String> {
}
