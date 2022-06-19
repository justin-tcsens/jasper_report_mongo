package my.com.tcsens.vehiclemanagement.service;


import lombok.val;
import my.com.tcsens.vehiclemanagement.dto.VehicleDto;
import my.com.tcsens.vehiclemanagement.model.tables.pojos.Vehicle;
import my.com.tcsens.vehiclemanagement.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleDto createVehicle(VehicleDto vehicleProfile) {
        val vehicle = mapEntity(vehicleProfile);
        return vehicleRepository.createVehicle(vehicle);
    }

    public VehicleDto getVehicleById(int vehicleId) {
        return vehicleRepository.getVehicleById(vehicleId)
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No record found!"));
    }

    public List<VehicleDto> getVehicles(String manufactureDate, String carPlateNum, int pageNo, int pageSize) {
        return vehicleRepository.getVehicleEnquiry(manufactureDate, carPlateNum, pageSize, pageNo)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Vehicle mapEntity(VehicleDto vehicle) {
        return new my.com.tcsens.vehiclemanagement.model.tables.pojos.Vehicle()
                .setCarplateNum(vehicle.getCarPlatNumber())
                .setMake(vehicle.getCarMake())
                .setModel(vehicle.getCarModel())
                .setChassisNum(vehicle.getChassisNumber())
                .setAxlesNum(vehicle.getAxlesCount())
                .setTyreNum(vehicle.getTyreCount())
                .setRoadtaxExpiry(vehicle.getRoadTaxExpiryDate())
                .setManufactureYear(vehicle.getManufactureDate());
    }
}
