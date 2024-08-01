package com.example.stage.stage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.stage.stage.dto.SujetDTO;
import com.example.stage.stage.services.SujetService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sujets")
public class SujetController {

    @Autowired
    private SujetService sujetService;

    @GetMapping
    public List<SujetDTO> getAllSujets() {
        return sujetService.getAllSujets();
    }

    @GetMapping("/{id}")
    public Optional<SujetDTO> getSujetById(@PathVariable Long id) {
        return sujetService.getSujetById(id);
    }

    @PostMapping
    public SujetDTO saveSujet(@RequestBody SujetDTO sujetDTO) {
        return sujetService.saveSujet(sujetDTO);
    }

    @GetMapping("/matiere/{matiereId}")
    public ResponseEntity<List<SujetDTO>> getSujetsByMatiereId(@PathVariable Long matiereId) {
        List<SujetDTO> sujets = sujetService.getSujetsByMatiereId(matiereId);
        return ResponseEntity.ok(sujets);
    }

    @DeleteMapping("/{id}")
    public void deleteSujet(@PathVariable Long id) {
        sujetService.deleteSujet(id);
    }

    @PostMapping("/createSujet")
    public ResponseEntity<SujetDTO> createSujet(@RequestBody SujetDTO sujetDTO) {
        SujetDTO createdSujet = sujetService.saveSujet(sujetDTO);
        return ResponseEntity.ok(createdSujet);
    }
    @PutMapping("/ModifierSujet/{id}")
    public ResponseEntity<SujetDTO> updateSujet(@PathVariable Long id, @RequestBody SujetDTO sujetDTO) {
        SujetDTO updatedSujet = sujetService.updateSujet(id, sujetDTO);
        return ResponseEntity.ok(updatedSujet);
    }
}