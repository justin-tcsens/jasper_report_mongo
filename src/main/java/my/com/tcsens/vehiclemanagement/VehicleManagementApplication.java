package my.com.tcsens.vehiclemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class VehicleManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleManagementApplication.class, args);
	}

}
