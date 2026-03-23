package com.gal.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gal.model.DriverVehicleMapping;
import com.gal.services.DriverVehicleMappingService;

import java.util.List;

@RestController
@RequestMapping("/mapping")
public class DriverVehicleMappingController {

    private final DriverVehicleMappingService service;


    public DriverVehicleMappingController(DriverVehicleMappingService service) {
        this.service = service;
    }
      

    // ✅ Create mapping
    @PostMapping
    public DriverVehicleMapping createMapping(@RequestBody DriverVehicleMapping mapping) {
        return service.save(mapping);
    }

    // ✅ Get all mappings
    @GetMapping
    public List<DriverVehicleMapping> getAllMappings() {
        return service.getAll();
    }

    // ✅ Get mapping by ID
    @GetMapping("/{id}")
    public DriverVehicleMapping getMappingById(@PathVariable int id) {
        return service.getById(id);
    }

    // ✅ Update mapping
    @PutMapping("/{id}")
    public DriverVehicleMapping updateMapping(@PathVariable int id,
                                              @RequestBody DriverVehicleMapping mapping) {
        return service.update(id, mapping);
    }

    // ✅ Delete mapping
    @DeleteMapping("/{id}")
    public String deleteMapping(@PathVariable int id) {
        service.delete(id);
        return "Mapping deleted successfully";
    }
}