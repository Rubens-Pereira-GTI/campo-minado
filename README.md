## Campo Minado
Esse projeto, é um projeto de aprendizado, feito pela cod3r. 
Tem como objeto por em pratica tudo que já foi aprendido até então e também mostrar como organizar um projeto, estrutura de pastas, nomes dos pacotes e boas práticas.
Também veremos um pouco sobre testes de software utilizando junit 

## Entendendo a estrutura dos pacotes
excecao - utilizaramos as exceptions para quando o usuario cair em uma bomba ser lançado a exceçao

modelo- teremos algumas lógicas do jogo

visão - a parte que o usuário interage. Esse projeto não terá uma GUI, talvez eu faça uma mais para frente por minha conta em risco com o proposito de aperfeiçoar esse projeto. 

## Algoritimo

### Entendendo a lógica da vizinhança. 
Cada caixa tera sua posição setada com linha e coluna, tendo isso em vista precisamos pegar a diferença entre as posições, subtraindo coluna com coluna e linha com luna. E para ser vizinho temos dois cenários, cruz e diagonal

cruz: a soma das diferenças tem que ser de 1 
diagonal: a soma das diferenças tem que ser de 2 
 

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
