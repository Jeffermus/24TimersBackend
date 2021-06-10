package com.example.demo.controller;

import com.example.demo.model.Kommune;
import com.example.demo.model.Sogn;
import com.example.demo.repository.SognRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class SognController {

    @Autowired
    SognRepository sognRepository;

    //    ==================================================== GET SOGN ============================================

    //    ====== SELECT ALL Kommune =====
    @GetMapping("/select/sogn")
    public List<Sogn> getSogne() {
        List<Sogn> sognList = sognRepository.findAll();

        return sognList;
    }

    //    ====== SELECT ONE SOGN WITH ID =====
    @GetMapping("/select/one/sogn/{id}")
    public Sogn getOneSognWId(@PathVariable int id) {
        Sogn sogn = sognRepository.findById(id);

        return sogn;
    }

    //    ==================================================== Insert SOGN ===========================================

    @PostMapping(value="/insert/sogn", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Sogn insertSogn(@RequestBody Sogn sogn){

        return sognRepository.save(sogn);

    }
//        ==================================================== Update SOGN ===========================================


    @PutMapping(value = "/edit/sogn", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Sogn updateSogn(@RequestBody Sogn sogn){
        System.out.println("Sogn==="+sogn.getId());
        Sogn oneSogn = sognRepository.findById(sogn.getId());
        oneSogn.setSognekode(sogn.getSognekode());
        oneSogn.setSognenavn(sogn.getSognenavn());
        oneSogn.setId(sogn.getId());
        System.out.println("ONE SOGN ==="+oneSogn.getSognenavn());

        return sognRepository.save(oneSogn);
    }

    //    ==================================================== DELETE SOGN =============================================

    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/sogn/{id}")
    public void deleteSogn(@PathVariable int id){
        System.out.println(id);
        try {
            sognRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("FEJL i DELETE =" + ex.getMessage());
        }
    }
}
