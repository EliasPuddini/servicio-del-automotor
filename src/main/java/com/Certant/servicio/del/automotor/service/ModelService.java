package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.models.dto.ModelDTO;
import com.Certant.servicio.del.automotor.models.entities.Model;

import java.util.List;

public interface ModelService {
    public List<ModelDTO> getModels();
    public ModelDTO getModel(Long id);
    public void deleteModel(Long id);
    public void saveModel(Model model);
}
