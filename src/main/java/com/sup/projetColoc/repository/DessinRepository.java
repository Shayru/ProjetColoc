package com.sup.projetColoc.repository;

import com.sup.projetColoc.model.Dessin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DessinRepository extends CrudRepository<Dessin,Integer> {
    List<Dessin> findByName(String name);
    List<Dessin> findAll();
}
