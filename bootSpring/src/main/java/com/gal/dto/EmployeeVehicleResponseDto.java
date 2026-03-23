package com.gal.dto;
import lombok.Data;
import java.time.LocalDate;

@Data
public class EmployeeVehicleResponseDto {

    private Long id;
    private String employeeName;
    private String busNumber;
    private LocalDate assignedAt;
    private String driverName;
    private String driverPhoneNumber;

    public EmployeeVehicleResponseDto(EmployeeVehicle employeeVehicle)
    {
        this.id = employeeVehicle.getId();
        this.employeeName = employeeVehicle.getEmployee().getName();
        this.busNumber = employeeVehicle.getVehicle().getNumber();
        this.assignedAt = employeeVehicle.getAssignedAt();
        this.driverName = employeeVehicle.getDriver().getName();
        this.driverPhoneNumber = employeeVehicle.getDriver().getPhone();
    }
}
