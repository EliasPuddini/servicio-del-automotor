package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.models.dto.BrandDTO;
import com.Certant.servicio.del.automotor.models.dto.ModelDTO;
import com.Certant.servicio.del.automotor.models.entities.Brand;

import java.util.List;

public interface BrandService {
    public List<BrandDTO> getBrands();
    public BrandDTO getBrand(Long id);
    public List<ModelDTO> getModelsByBrandId(Long id);
    public void deleteBrand(Long id);
    public void saveBrand(Brand brand);
}
