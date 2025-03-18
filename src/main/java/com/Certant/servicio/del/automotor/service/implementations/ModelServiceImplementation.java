package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.models.dto.ModelDTO;
import com.Certant.servicio.del.automotor.models.entities.Brand;
import com.Certant.servicio.del.automotor.models.entities.Model;
import com.Certant.servicio.del.automotor.repositories.BrandRepository;
import com.Certant.servicio.del.automotor.repositories.ModelRepository;
import com.Certant.servicio.del.automotor.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ModelServiceImplementation implements ModelService {

    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<ModelDTO> getModels() {

        List<ModelDTO> modelDTOS = new ArrayList<>();
        modelRepository.findAll().forEach(model -> {
            modelDTOS.add(new ModelDTO(model));
        });

        return modelDTOS;
    }

    @Override
    public ModelDTO getModel(Long id) {
        return new ModelDTO(Objects.requireNonNull(modelRepository.findById(id).orElse(null)));
    }

    @Override
    public void deleteModel(Long id) {

        Model model = modelRepository.findById(id).orElse(null);
        List<Model> models = modelRepository.findAll().stream().filter(model1-> {
            assert model != null;
            return Objects.equals(model1.getBrand().getId(), model.getBrand().getId());
        }).toList();
        if(models.isEmpty()){
            assert model != null;
            brandRepository.deleteById(model.getBrand().getId());
        }
        modelRepository.deleteById(id);
    }

    @Override
    public void saveModel(Model model) {

        if(model.getBrand().getId() == 0){
            brandRepository.save(model.getBrand());
        }else{
            Brand brand = brandRepository.findAll().stream().filter(brand1 -> Objects.equals(brand1.getName(), model.getBrand().getName())).findFirst().orElse(null);
            assert brand != null;
            model.setBrand(brand);
        }

        modelRepository.save(model);
    }
}
