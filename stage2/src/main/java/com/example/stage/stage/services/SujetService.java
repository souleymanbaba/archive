package com.example.stage.stage.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stage.stage.dto.MatiereDTO;
import com.example.stage.stage.dto.SujetDTO;
import com.example.stage.stage.entity.Matiere;
import com.example.stage.stage.entity.Sujet;
import com.example.stage.stage.repostory.SujetRepository;

@Service
public class SujetService {

    @Autowired
    private SujetRepository sujetRepository;

    public List<SujetDTO> getAllSujets() {
        List<Sujet> sujets = sujetRepository.findAll();

        return sujets.stream().map(sujet -> sujet.getDto()).collect(Collectors.toList());

    }

    public Optional<SujetDTO> getSujetById(Long id) {
        return sujetRepository.findById(id).map(this::convertToDto);
    }

    public SujetDTO saveSujet(SujetDTO sujetDTO) {
        Sujet sujet = convertToEntity(sujetDTO);
        return convertToDto(sujetRepository.save(sujet));
    }
    public SujetDTO updateSujet(Long id, SujetDTO sujetDTO) {
        Optional<Sujet> sujetOptional = sujetRepository.findById(id);
        if (sujetOptional.isPresent()) {
            Sujet sujet = sujetOptional.get();
            sujet.setMatiere(convertToEntityMatiere(sujetDTO.getMatiere()));
            sujet.setAnnee(sujetDTO.getAnnee());
            sujet.setSujet(sujetDTO.getSujet());
//            sujet.setType(Sujet.Type.valueOf(sujetDTO.getType()));
            return convertToDto(sujetRepository.save(sujet));
        } else {
            throw new RuntimeException("Sujet not found");
        }
    }
    public void deleteSujet(Long id) {
        sujetRepository.deleteById(id);
    }

    private SujetDTO convertToDto(Sujet sujet) {
        SujetDTO dto = new SujetDTO();
        dto.setId(sujet.getId());
        dto.setIdMatiere(sujet.getMatiere().getId());
        dto.setMatiere(convertToDtoMatiere(sujet.getMatiere()));
        dto.setAnnee(sujet.getAnnee());
        dto.setSujet(sujet.getSujet());
//        dto.setType(sujet.getType().name());
        return dto;
    }

    public List<SujetDTO> getSujetsByMatiereId(Long matiereId) {
        List<Sujet> sujets = sujetRepository.findByMatiere_Id(matiereId);
        return   sujets.stream().map(sujet -> sujet.getDto()).collect(Collectors.toList());
    }

    private Sujet convertToEntity(SujetDTO dto) {
        Sujet sujet = new Sujet();
        sujet.setId(dto.getId());
        Matiere matiere = new Matiere();
        matiere.setId(dto.getIdMatiere());
        sujet.setMatiere(matiere);
        sujet.setAnnee(dto.getAnnee());
        sujet.setSujet(dto.getSujet());
//        sujet.setType(Sujet.Type.valueOf(dto.getType()));
        return sujet;
    }

    private MatiereDTO convertToDtoMatiere(Matiere matiere) {
        MatiereDTO dto = new MatiereDTO();
        dto.setId(matiere.getId());
        dto.setNom(matiere.getNom());
        dto.setSemestre(matiere.getSemestre());
        return dto;
    }

    private Matiere convertToEntityMatiere(MatiereDTO dto) {
        Matiere matiere = new Matiere();
        matiere.setId(dto.getId());
        matiere.setNom(dto.getNom());
        matiere.setSemestre(dto.getSemestre());
        return matiere;
    }
}