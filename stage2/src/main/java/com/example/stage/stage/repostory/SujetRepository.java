package com.example.stage.stage.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stage.stage.entity.Sujet;

@Repository
public interface SujetRepository extends JpaRepository<Sujet, Long> {
    List<Sujet> findByMatiere_Id(Long matiereId);
}
