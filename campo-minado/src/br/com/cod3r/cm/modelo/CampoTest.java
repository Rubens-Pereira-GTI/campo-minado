package br.com.cod3r.cm.modelo;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampoTest {
        private Campo campo;

    @BeforeEach
    void iniciarCampo(){
        campo = new Campo(3,3);
    }
    @Test
    void testAddVizinhoEsquerda() {
        Campo vizinho = new Campo(3, 2);
        boolean resultado = campo.addVizinho(vizinho);
        assertTrue(resultado);
    }
     @Test
    void testAddVizinhoDireita() {
        Campo vizinho = new Campo(3, 4);
        boolean resultado = campo.addVizinho(vizinho);
        assertTrue(resultado);
    }
     @Test
    void testAddVizinhoCima() {
        Campo vizinho = new Campo(2, 3);
        boolean resultado = campo.addVizinho(vizinho);
        assertTrue(resultado);
    }
     @Test
    void testAddVizinhoBaixo() {
        Campo vizinho = new Campo(4, 3);
        boolean resultado = campo.addVizinho(vizinho);
        assertTrue(resultado);
    }

     @Test
    void testAddVizinhoNoroeste() {
        Campo vizinho = new Campo(2, 2);
        boolean resultado = campo.addVizinho(vizinho);
        assertTrue(resultado);
    }

     @Test
    void testAddVizinhoNordeste() {
        Campo vizinho = new Campo(2, 4);
        boolean resultado = campo.addVizinho(vizinho);
        assertTrue(resultado);
    }
     @Test
    void testAddVizinhoSudeste() {
        Campo vizinho = new Campo(4, 4);
        boolean resultado = campo.addVizinho(vizinho);
        assertTrue(resultado);
    }
     @Test
    void testAddVizinhoSudoeste() {
        Campo vizinho = new Campo(4, 2);
        boolean resultado = campo.addVizinho(vizinho);
        assertTrue(resultado);
    }
     @Test
    void testAddVizinhoFail() {
        Campo vizinho = new Campo(1, 2);
        boolean resultado = campo.addVizinho(vizinho);
        assertFalse(resultado);
    }
}
