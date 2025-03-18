package com.Certant.servicio.del.automotor.controllers;

import com.Certant.servicio.del.automotor.models.dto.BrandDTO;
import com.Certant.servicio.del.automotor.models.dto.ModelDTO;
import com.Certant.servicio.del.automotor.models.dto.VehicleTypeDTO;
import com.Certant.servicio.del.automotor.models.entities.Brand;
import com.Certant.servicio.del.automotor.models.entities.Model;
import com.Certant.servicio.del.automotor.models.entities.VehicleType;
import com.Certant.servicio.del.automotor.service.BrandService;
import com.Certant.servicio.del.automotor.service.ModelService;
import com.Certant.servicio.del.automotor.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicleThings")
public class VehicleThingsController {

    @Autowired
    private VehicleTypeService vehicleTypeService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ModelService modelService;

    @GetMapping("/vehicleTypes")
    public ResponseEntity<List<VehicleTypeDTO>> getAllVehicleTypes(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(vehicleTypeService.getAll());
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @GetMapping("/vehicleTypes/{vehicleTypeID}")
    public ResponseEntity<VehicleTypeDTO> getVehicleType(@PathVariable("vehicleTypeID") Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(vehicleTypeService.getByID(id));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @DeleteMapping("/vehicleTypes")
    public ResponseEntity<String> deleteVehicleType(@RequestBody Long id){
        try {
            vehicleTypeService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(" Se ha eliminado el tipo de vehiculo. ");
        } catch(Exception exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(" No se ha podido eliminar el tipo de vehiculo. ");
        }
    }

    @PostMapping("/vehicleTypes")
    public ResponseEntity<String> postVehicleType(@RequestBody VehicleType vehicleType){
        try {
            vehicleTypeService.save(vehicleType);
            return ResponseEntity.status(HttpStatus.OK).body(" Se ha eliminado el tipo de vehiculo");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(" No se ha podido guardar el tipo de vehiculo. ");
        }
    }
    //Brands
    @GetMapping("/brands")
    public ResponseEntity<List<BrandDTO>> getAllBrands(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(brandService.getBrands());
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/brands/{brandId}")
    public ResponseEntity<BrandDTO> getBrand(@PathVariable("brandID") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(brandService.getBrand(id));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/brands")
    public ResponseEntity<String> deleteBrand(@RequestBody Long id){
        try {
            brandService.deleteBrand(id);
            return ResponseEntity.status(HttpStatus.OK).body(" Se ha eliminado la marca. ");
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" No se ha podido eliminar la marca. ");
        }
    }


    @PostMapping("/brands")
    public ResponseEntity<String> postBrand(@RequestBody Brand brand){
        try {
            brandService.saveBrand(brand);
            return ResponseEntity.status(HttpStatus.OK).body(" Se ha guardado la marca. ");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" No se ha podido guardar la marca. ");
        }
    }
    //Models
    @GetMapping("/brands/{brandId}/models")
    public ResponseEntity<List<ModelDTO>> getModelsByBrand(@PathVariable("brandId") Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(brandService.getModelsByBrandId(id));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/models")
    public ResponseEntity<List<ModelDTO>> getAllModels(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(modelService.getModels());
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/models/{modelId}")
    public ResponseEntity<ModelDTO> getModel(@PathVariable("modelId") Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(modelService.getModel(id));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/models/{modelId}")
    public ResponseEntity<String> deleteModel(@PathVariable("modelId") Long id){
        try {
            modelService.deleteModel(id);
            return ResponseEntity.status(HttpStatus.OK).body(" Se ha eliminado el modelo. ");
        }catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" No se ha podido eliminar el modelo. ");
        }
    }

    @PostMapping("/models")
    public ResponseEntity<String> saveModel(@RequestBody Model model){
        try {
            modelService.saveModel(model);
            return ResponseEntity.status(HttpStatus.OK).body(" Se ha guardado el modelo. ");
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" No se ha eliminado el modelo. ");
        }
    }
}
