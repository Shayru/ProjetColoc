package com.sup.projetColoc.controller;

import com.sup.projetColoc.model.Dessin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DessinControllerTest {
    @Autowired
    private DessinController dessinController;

    @DisplayName("DessinController: Modifier un dessin avec id inexistant")
    @Test
    public void testModifyWithWrongId(){
        assertEquals(dessinController.modifyDessin(
                new Dessin(
                        -1,
                        "dessin1",
                        1000,
                        900,
                        "definition d'un exemple de dessin")),
                ResponseEntity.notFound().build()
        );
    }
}
