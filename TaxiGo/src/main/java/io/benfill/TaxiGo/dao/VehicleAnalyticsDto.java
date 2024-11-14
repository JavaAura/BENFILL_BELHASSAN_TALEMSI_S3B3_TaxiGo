package io.benfill.TaxiGo.dao;

import io.benfill.TaxiGo.model.enums.Status;
import io.benfill.TaxiGo.model.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleAnalyticsDto {
    private Map<VehicleType, Double> averageMileageByType;
    private Map<VehicleType, Double> utilizationRateByType;
    private Map<Status, Long> fleetStatusCount;
}
