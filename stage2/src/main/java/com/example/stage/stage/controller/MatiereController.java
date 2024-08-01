package com.example.stage.stage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.stage.stage.dto.MatiereDTO;
import com.example.stage.stage.services.MatiereService;

import java.util.List;


@RestController
@RequestMapping("/matieres")
public class MatiereController {
    @Autowired
    private MatiereService matiereService;

    @GetMapping
    public List<MatiereDTO> getAllMatieres() {
        return matiereService.getAllMatieres();
    }

    @GetMapping("/semestre/{semestre}")
    public List<MatiereDTO> getMatieresBySemestre(@PathVariable String semestre) {
        return matiereService.getMatieresBySemestre(semestre);
    }

    @GetMapping("/{id}")
    public MatiereDTO getMatiereById(@PathVariable Long id) {
        return matiereService.getMatiereById(id);
    }

    @PostMapping
    public MatiereDTO createMatiere(@RequestBody MatiereDTO matiereDTO) {
        return matiereService.createMatiere(matiereDTO);
    }
    @PutMapping("/{id}")
    public MatiereDTO updateMatiere(@PathVariable Long id, @RequestBody MatiereDTO matiereDTO) {
        return matiereService.updateMatiere(id, matiereDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMatiere(@PathVariable Long id) {
        matiereService.deleteMatiere(id);
    }
}