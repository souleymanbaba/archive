package com.example.stage.stage.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stage.stage.entity.Matiere;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
    List<Matiere> findBySemestre(String semestre);
}
