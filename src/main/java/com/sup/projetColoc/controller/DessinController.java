package com.sup.projetColoc.controller;

import com.sup.projetColoc.model.Dessin;
import com.sup.projetColoc.repository.DessinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DessinController {
    private static Logger log;

    static {
        log = LoggerFactory.getLogger("DessinsController");
    }
    @Autowired
    private DessinRepository dessinRepository;

    @PostMapping(value = "dessin/new", consumes = "application/json")
    public ResponseEntity<Dessin> createDessin(@RequestBody Dessin dessin){
        log.info(String.format("add new dessin : %1$s", dessin));
        dessinRepository.save(dessin);
        return ResponseEntity.accepted().build();
    }

    @PutMapping(value = "dessin/modify", consumes = "application/json")
    public ResponseEntity<Dessin> modifyDessin(@RequestBody Dessin dessin){
        log.info(String.format("modify dessin : %1$s", dessin));
        if(dessin.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        Optional<Dessin> dessinOptional = dessinRepository.findById(dessin.getId());
        if(dessinOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        dessinRepository.save(dessin);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "dessins")
    public List<Dessin> getList(){
        log.info("list all dessins");
        return dessinRepository.findAll();
    }

    @GetMapping(value = "dessin")
    public ResponseEntity<Dessin> getById(@RequestParam Integer id){
        log.info(String.format("get dessin by id : %1$s", id));
        Optional<Dessin> dessin = dessinRepository.findById(id);
        if(dessin.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dessin.get());
    }

    @GetMapping
    @RequestMapping("dessin/{name}")
    public List<Dessin> getAllByName(@PathVariable String name){
        log.info(String.format("get dessin by name : %1$s", name));
        return dessinRepository.findByName(name);
    }
}
