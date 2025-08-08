package br.com.cod3r.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.cod3r.cm.excecao.ExplosaoException;

public class Campo {
   
    private final int linha;
    private final int coluna;
    private boolean aberto= false;
    private boolean minado= false;
    private boolean marcado = false;
    private List<Campo> vizinhos = new ArrayList<>();

    public Campo(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }


    public boolean addVizinho(Campo vizinho){  
        //Logica para saber se o vizinho é do tipo Cruz ou diagonal 
        System.out.println(linha +"L L " + vizinho.linha );     
        boolean vizinhoLinhaDiferente = linha != vizinho.linha;
        boolean vizinhoColunaDiferente = coluna != vizinho.coluna;
        boolean vizinhoDiagonal = vizinhoColunaDiferente && vizinhoLinhaDiferente;
        
        //se o deltaGeral der 1 é o vizinho do tipo cruz se der 2 é vizinho do tipo diagonal
        int deltaLinha = Math.abs(vizinho.linha - linha);
        int deltaColuna = Math.abs(vizinho.coluna - coluna);
        int deltaGeral = deltaColuna + deltaLinha;
        System.out.println( deltaLinha +" DL e DC "+ deltaColuna);
        if(deltaGeral == 1 && !vizinhoDiagonal){
            vizinhos.add(vizinho);
            return true;
        }else if(deltaGeral == 2 && vizinhoDiagonal){
            vizinhos.add(vizinho);
            return true;
        }else{
            return false;
        }
        //caso caia no ele ele muda para false
         
    }

    //lógica de alternancia de marcação
    void alternarMarcacao(){
        if(!aberto){
            marcado = !marcado;
        } 
    }

    boolean abrir(){
        if(!aberto && !marcado ){
            aberto = true;
            if(minado){
                throw new ExplosaoException();     
            }
            //vamos abrir a vizinhaça até que não esteja mais seguro
            if(vizinhancaSegura()){
                vizinhos.forEach(v -> v.abrir());    
            }
            // se cair no primeiro if é o campo foi aberto então retornamos true
            return true;
        }else{
            return false;
  
        }
    }

    boolean vizinhancaSegura(){
        return vizinhos.stream().noneMatch(vizinho -> vizinho.minado);
    }

    
  
}
