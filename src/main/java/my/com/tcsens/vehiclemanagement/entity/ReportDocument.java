package my.com.tcsens.vehiclemanagement.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@Document(collection = "supporting_documents")
public class ReportDocument {
    @Id
    private String id;
    @Field("upload_time")
    private LocalDateTime uploadTime;
    @Field("document")
    private Binary document;
}
