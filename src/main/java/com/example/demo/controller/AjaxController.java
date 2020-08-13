package com.example.demo.controller;

import com.example.demo.domain.Emploie;
import com.example.demo.repository.EmploieRepository;
import com.example.demo.vo.EmploieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ajax")
public class AjaxController {

    @Autowired
    private EmploieRepository emploieRepository;

    @PostMapping("/saveEmploie")
    public ResponseEntity<String> saveEmploie(@RequestBody List<EmploieVO> emploieList) {

        emploieRepository.saveAll(emploieList);

        return ResponseEntity.ok("l'emploie a été enregistrer");
    }

}
