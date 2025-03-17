package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.models.dto.BrandDTO;
import com.Certant.servicio.del.automotor.models.dto.ModelDTO;
import com.Certant.servicio.del.automotor.models.entities.Brand;
import com.Certant.servicio.del.automotor.repositories.BrandRepository;
import com.Certant.servicio.del.automotor.repositories.ModelRepository;
import com.Certant.servicio.del.automotor.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BrandServiceImplementation implements BrandService {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ModelRepository modelRepository;

    @Override
    public List<BrandDTO> getBrands() {

        List<BrandDTO> brandDTOS = new ArrayList<>();
        brandRepository.findAll().forEach(brand -> {
            brandDTOS.add(new BrandDTO(brand));
        });

        return brandDTOS;
    }

    @Override
    public BrandDTO getBrand(Long id) {
        return new BrandDTO(Objects.requireNonNull(brandRepository.findById(id).orElse(null)));
    }
    @Override
    public List<ModelDTO> getModelsByBrandId(Long id){
        List<ModelDTO> modelDTOS = new ArrayList<>();
        modelRepository.findAll().forEach(model -> {
            if(model.getBrand().getId()==id){
                modelDTOS.add(new ModelDTO(model));
            }
        });
        return modelDTOS;
    }

    @Override
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public void saveBrand(Brand brand) {
        brandRepository.save(brand);
    }
}
