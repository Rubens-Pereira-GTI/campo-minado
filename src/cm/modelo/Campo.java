package cm.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import cm.excecao.*;

// esse o codigo personalizado por mim. 
public class Campo {
   
    // Temos aqui todas as variáveis de instância
    private final int linha;
    private final int coluna;
    private boolean aberto= false;
    private boolean minado= false;
    private boolean marcado = false;
    private List<Campo> listaCamposVizinhos = new ArrayList<>();

    // Temos o construtor que será iniciado com dois atributos 
    public Campo(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }

    // esse método é responsável por dizer quais os listaCamposVizinhos do bloco
    public boolean addVizinho(Campo campo){         
        /*
        A lógica é ter um delta, um valor que repsenta a distância onde um delta de 
        1 e 2 represanta que são vizinhos e para obtermos esse delta 
        subtraimos coluna - coluna e linha - linha de dois campos.        
        */
        int deltaLinha = Math.abs(linha - campo.linha);
        int deltaColuna = Math.abs(coluna - campo.coluna);
        int deltaGeral = deltaColuna + deltaLinha;

        //aqui estamos verificando e adicionado se são vizinhos
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
        //se o campo está fechado e não marcado, abre o campo
        if((isFechado()) && (marcado == false)){
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


    boolean isFechado(){
        return !aberto;
    }

   
  
}
