package com.example.demo.controller;

import com.example.demo.model.Kommune;
import com.example.demo.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class KommuneController {

    @Autowired
    KommuneRepository kommuneRepository;

    //    ==================================================== GET Kommune ============================================

    //    ====== SELECT ALL Kommune =====
    @GetMapping("/select/kommune")
    public List<Kommune> getKommune() {
        List<Kommune> kommuneList = kommuneRepository.findAll();

        return kommuneList;
    }
}
