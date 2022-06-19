package my.com.tcsens.vehiclemanagement.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import my.com.tcsens.vehiclemanagement.model.VehicleModel;
import my.com.tcsens.vehiclemanagement.util.CommonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private CommonUtil commonUtil;
//
//    @Test
//    public void givenVehicle_whenCreateVehicle_thenStatus200() throws Exception {
//        val carPlateNumber = commonUtil.getRandomNumber(9999999, 7);
//        val chassisNumber = commonUtil.getRandomNumber(1000000000, 19);
//
//        val response = mvc.perform(post("/vehicle")
//                        .content(getObjectAsString(createVehicle(carPlateNumber, chassisNumber)))
//                        .contentType(MediaType.APPLICATION_JSON))
//
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andReturn().getResponse().getContentAsString();
//
//        val vehicle = mapResultToObject(response);
//        assertThat(vehicle.getCarPlatNumber()).isEqualTo(carPlateNumber);
//        assertThat(vehicle.getChassisNumber()).isEqualTo(chassisNumber);
//    }
//
//    @Test
//    public void givenVehicle_whenGetVehicleById_thenStatus200() throws Exception {
//        val carPlateNumber = commonUtil.getRandomNumber(9999999, 7);
//        val chassisNumber = commonUtil.getRandomNumber(1000000000, 19);
//
//        val response = mvc.perform(post("/vehicle")
//                        .content(getObjectAsString(createVehicle(carPlateNumber, chassisNumber)))
//                        .contentType(MediaType.APPLICATION_JSON))
//
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andReturn().getResponse().getContentAsString();
//        val vehicle = mapResultToObject(response);
//
//        assertThat(vehicle).isNotNull();
//        assertThat(vehicle.getId()).isNotNull();
//
//        val getVehicleResponse = mvc.perform(get("/vehicle/" + vehicle.getId())
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andReturn().getResponse().getContentAsString();
//
//        val vehicleById = mapResultToObject(response);
//        assertThat(vehicleById.getId()).isEqualTo(vehicleById.getId());
//    }
//
//    private VehicleModel createVehicle(String carPlateNumber, String chassisNumber) {
//        return new VehicleModel()
//                .carPlatNumber(carPlateNumber)
//                .carMake("NISSAN")
//                .carModel("ALMERA")
//                .chassisNumber(chassisNumber)
//                .axlesCount(2)
//                .tyreCount(4)
//                .roadTaxExpiryDate("2023-05-21")
//                .manufactureDate("2009");
//
//    }
//
//    private String getObjectAsString(VehicleModel vehicleProfile) throws JsonProcessingException {
//        val objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(vehicleProfile);
//    }
//
//
//    private VehicleModel mapResultToObject(String jsonResult) throws JsonProcessingException {
//        val objectMapper = new ObjectMapper();
//        return objectMapper.readValue(jsonResult, VehicleModel.class);
//    }
}
