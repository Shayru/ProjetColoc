package com.sup.projetColoc.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="dessins")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dessin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Integer width;
    @Getter
    @Setter
    private Integer height;
    @Getter
    @Setter
    private String description;

}
