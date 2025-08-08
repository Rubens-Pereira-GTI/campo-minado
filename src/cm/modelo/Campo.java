package cm.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cm.modelo.excecao.*;

// esse o codigo personalizado por mim. 
public class Campo {
   
    private final int linha;
    private final int coluna;
    private boolean aberto= false;
    private boolean minado= false;
    private boolean marcado = false;
    private List<Campo> listaCamposVizinhos = new ArrayList<>();

    public Campo(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }

    // esse método é responsável por dizer quais os listaCamposVizinhos do bloco
    public boolean addVizinho(Campo campo){               
        int deltaLinha = Math.abs(linha - campo.linha);
        int deltaColuna = Math.abs(coluna - campo.coluna);
        int deltaGeral = deltaColuna + deltaLinha;

        if(deltaGeral == 1 || deltaGeral == 2){
            listaCamposVizinhos.add(campo);
            return true;
        }else{
            return false;
        }
    }

    //essa é uma maneira bem fácil de alternar algo
    void alternarMarcacao(){
        marcado = !marcado;
    }

    //abre o campo e os campos vizinhos ou diz se está minado
    boolean abrir(){
        //checa se o campo está aberto ou feixado, se estiver feixado ele abre o campo
        if((aberto ==false) && (marcado == false)){
            aberto = true;

            //verificar se o campo tem bomba e lançar uma exceção caso tenha
            if(minado){
                throw new ExplosaoException();
            }

            //nota: como estamos quebrando o fluxo não precisamos utilizar o elseif
            //se a vizinhaça for segura abra toda a vizinhança
            if(vizinhancaSegura()){
                listaCamposVizinhos.stream().forEach(cv -> cv.abrir());
            }

        }

            
            
           
            
        
        return false;
    }

    //analisa se a vizinhaça está segura, se ela toda estiver segura teremos um true
    boolean vizinhancaSegura(){   
        //se não houver algum minado o resultado será true o que indica que a vizinhaça está segura.     
        return listaCamposVizinhos.stream().noneMatch(cv -> cv.minado);
    }



   
  
}
