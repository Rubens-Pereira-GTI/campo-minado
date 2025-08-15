package teste.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cod3r.cm.excecao.ExplosaoException;
import br.com.cod3r.cm.modelo.Campo;

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

    @Test
    void testeToString(){
        assertEquals("?", campo.toString());
        campo.alternarMarcacao();
        assertEquals("x", campo.toString());
        campo.alternarMarcacao();
        assertEquals("?", campo.toString());

        campo.abrir();
        assertEquals("", campo.toString());

        Campo campo22 = new Campo(2, 2);
        Campo campo32 = new Campo(3, 2);
        Campo campo42 = new Campo(4, 2);
        campo.addVizinho(campo22);
        campo.addVizinho(campo32);
        campo.addVizinho(campo42);
         
        campo22.minar();
        assertEquals("1", campo.toString());

        campo32.minar();
        assertEquals("2", campo.toString());

        campo42.minar();
        assertEquals("3", campo.toString());
        
    }

    @Test
    void testeToStringComMinado(){
        campo.minar();
        
        assertThrows(ExplosaoException.class, () -> campo.abrir());  
        
        assertEquals("*", campo.toString());

    }

    @Test
    void testarMinasVizinhasComBomba(){
        Campo campo22 = new Campo(2, 2);
        Campo campo32 = new Campo(3, 2);
        Campo campo42 = new Campo(4, 2);
        
        Campo campo23 = new Campo(2, 3);
        Campo campo43 = new Campo(4, 3);

        campo.addVizinho(campo22);
        campo.addVizinho(campo32);
        campo.addVizinho(campo42);
        campo.addVizinho(campo23);
        campo.addVizinho(campo43);
        
        campo22.minar();
        assertEquals(1, campo.minasNaVizinhaca());

        campo32.minar();
        assertEquals(2, campo.minasNaVizinhaca());

        campo42.minar();
        assertEquals(3, campo.minasNaVizinhaca());

        campo23.minar();
        assertEquals(4, campo.minasNaVizinhaca());

        campo43.minar();
        assertEquals(5, campo.minasNaVizinhaca());

    }

    @Test
    void testReset(){
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
        
        campo.reiniciar();
        assertFalse(campo.isMarcado());

        campo.abrir();
        assertTrue(campo.isAberto());
        
        campo.reiniciar();
        assertFalse(campo.isAberto());

        campo.minar();
        assertTrue(campo.isMinado());

        campo.reiniciar();
        assertFalse(campo.isMinado());        
        
    }

    @Test
    void testeObjetivoAlcancado(){

        Campo campo22 = new Campo(2, 2);
        Campo campo32 = new Campo(3, 2);
        Campo campo42 = new Campo(4, 2);
        
        Campo campo23 = new Campo(2, 3);
        Campo campo43 = new Campo(4, 3);

        campo.addVizinho(campo22);
        campo.addVizinho(campo32);
        campo.addVizinho(campo42);
        campo.addVizinho(campo23);
        campo.addVizinho(campo43);

        campo22.minar();
        campo32.minar();

        campo22.alternarMarcacao();
        //campo32.alternarMarcacao();

        campo.abrir();
        assertEquals("2", campo.toString());

        assertTrue(campo22.objetivoAlcancado());

        assertFalse(campo32.objetivoAlcancado());

        campo32.alternarMarcacao();
        assertTrue(campo32.objetivoAlcancado());


    }


}
