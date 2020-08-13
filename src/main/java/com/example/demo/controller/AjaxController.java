package com.example.demo.controller;

import com.example.demo.domain.Emploie;
import com.example.demo.repository.EmploieRepository;
import com.example.demo.repository.GroupeRepository;
import com.example.demo.repository.SalleRepository;
import com.example.demo.vo.EmploieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ajax")
public class AjaxController {

    @Autowired
    private EmploieRepository emploieRepository;

    @Autowired
    private GroupeRepository groupeRepository;

    @Autowired
    private SalleRepository salleRepository;

    @GetMapping("/getEmploie/{groupeId}")
    public List<Emploie> getEmploie(@PathVariable Long groupeId) {
        return groupeRepository.findById(groupeId).get().getEmploieListe();
    }

    @PostMapping("/saveEmploie")
    public ResponseEntity<String> saveEmploie(@RequestBody EmploieVO emploieVO) {

        if (emploieVO.getDateDebut().after(emploieVO.getDateFin()) || emploieVO.getDateDebut().equals(emploieVO.getDateFin())) {
            return new ResponseEntity<>("date debut doit etre inferieur a date fin", HttpStatus.BAD_REQUEST);
        }

        int rowsA = emploieRepository.checkExistEmploieA(emploieVO.getSalleId(), emploieVO.getDateDebut());
        int rowsB = emploieRepository.checkExistEmploieB(emploieVO.getSalleId(), emploieVO.getDateFin());
        if (rowsA > 0 || rowsB > 0) {
            return new ResponseEntity<>("emploie deja exist", HttpStatus.BAD_REQUEST);
        }

        Emploie emploie = new Emploie();
        emploie.setDateDebut(emploieVO.getDateDebut());
        emploie.setDateFin(emploieVO.getDateFin());
        emploie.setGroupe(groupeRepository.findById(emploieVO.getGroupeId()).get());
        emploie.setSalle(salleRepository.findById(emploieVO.getSalleId()).get());

        emploieRepository.saveAndFlush(emploie);

        return new ResponseEntity<>("", HttpStatus.OK);

    }

}
