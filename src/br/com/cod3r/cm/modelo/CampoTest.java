package br.com.cod3r.cm.modelo;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cod3r.cm.excecao.ExplosaoException;

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
    @Test
    void testeValorPadraoAtributoMarcado(){
        assertFalse(campo.isMarcado());        
        
    }
    @Test
    void testeAltenarMarcacao(){
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());        
        
    }
    @Test
    void testeAltenarMarcacaoDuasChamadas(){
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());        
        
    }
    @Test
    void testeAbrirNaoMinadoNaoMarcado(){
        assertTrue(campo.abrir());        
    }
    @Test
    void testeAbrirNaoMinadoMarcado(){
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }
    @Test
    void testeAbrirMinadoMarcado(){
        campo.minar();
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }
    @Test
    void testeAbrirMinadoNaoMarcado(){
        campo.minar();
        assertThrows(ExplosaoException.class, () -> {
            campo.abrir();
        });
    }
    @Test
    void testeAbrirComVizinhos1(){
        Campo campo22 = new Campo(2, 2);
        Campo campo11 = new Campo(1, 1);

        campo.addVizinho(campo22);
        campo22.addVizinho(campo11);

        campo.abrir();
        assertTrue(campo22.isAberto() && campo11.isAberto());

    }
    @Test
    void testeAbrirComVizinhos2(){
        Campo campo11 = new Campo(1, 1);
        Campo campo22 = new Campo(2, 2);
        Campo campo12 = new Campo(1, 2);
        
        campo12.minar();

        campo.addVizinho(campo22);
        campo22.addVizinho(campo11);
        campo22.addVizinho(campo12);

        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isFechado());

    }

}
