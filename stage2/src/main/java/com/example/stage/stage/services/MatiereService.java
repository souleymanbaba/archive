package com.example.stage.stage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stage.stage.dto.MatiereDTO;
import com.example.stage.stage.entity.Matiere;
import com.example.stage.stage.repostory.MatiereRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatiereService {

    @Autowired
    private MatiereRepository matiereRepository;

    public List<MatiereDTO> getAllMatieres() {
        return matiereRepository.findAll().stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<MatiereDTO> getMatieresBySemestre(String semestre) {
        return matiereRepository.findBySemestre(semestre).stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public MatiereDTO createMatiere(MatiereDTO matiereDTO) {
        Matiere matiere = new Matiere();
        matiere.setNom(matiereDTO.getNom());
        matiere.setSemestre(matiereDTO.getSemestre());
        Matiere savedMatiere = matiereRepository.save(matiere);
        return convertEntityToDTO(savedMatiere);
    }

    private MatiereDTO convertEntityToDTO(Matiere matiere) {
        MatiereDTO matiereDTO = new MatiereDTO();
        matiereDTO.setId(matiere.getId());
        matiereDTO.setNom(matiere.getNom());
        matiereDTO.setSemestre(matiere.getSemestre());
        return matiereDTO;
    }
    public MatiereDTO updateMatiere(Long id, MatiereDTO matiereDTO) {
        Matiere matiere = matiereRepository.findById(id).orElse(null);
        matiere.setNom(matiereDTO.getNom());
        matiere.setSemestre(matiereDTO.getSemestre());
        Matiere updatedMatiere = matiereRepository.save(matiere);
        return convertEntityToDTO(updatedMatiere);
    }
    public void deleteMatiere(Long id) {
        matiereRepository.deleteById(id);
    }
    public MatiereDTO getMatiereById(Long id) {
        Optional<Matiere> matiere = matiereRepository.findById(id);
        return matiere.map(this::convertEntityToDTO).orElse(null);
    }


} 