package com.example.demo.repository;

import com.example.demo.domain.Emploie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface EmploieRepository extends JpaRepository<Emploie, Long> {

    @Query("select count(e) from Emploie e where e.salle.id = ?1 And e.dateDebut <= ?2 AND e.dateFin > ?2 ")
    int checkExistEmploieA(Long salleId, Date debut);

    @Query("select count(e) from Emploie e where e.salle.id = ?1 And e.dateDebut < ?2 AND e.dateFin >= ?2 ")
    int checkExistEmploieB(Long salleId, Date debut);

}
