package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.models.dto.ModelDTO;
import com.Certant.servicio.del.automotor.models.entities.Model;
import com.Certant.servicio.del.automotor.repositories.ModelRepository;
import com.Certant.servicio.del.automotor.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ModelServiceImplementation implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

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
        modelRepository.deleteById(id);
    }

    @Override
    public void saveModel(Model model) {
        modelRepository.save(model);
    }
}
