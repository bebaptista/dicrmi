# dicrmi

 O programa foi dividido em dois pacotes principais, sendo um base br.com.puc.dicrmi 

#### Client

 Possui apenas duas classes java. Sendo **DicionarioClient.java** com o main do cliente, e 
**DicionarioGrafico.java** que define os componentes gráficos feitos com o Java Swing.

#### Server

 Pacote que engloba todo o universo do lado do servidor, a classe **DicionarioServer.java**
possui o main que inicia o servidor, expondo os objetos aos RMI

- ##### Model

 Pacote com as classes modelos do projeto, no caso, a classe **Verbete.java**

- ##### Remote

 Pacote que armazena objetos que são expostos pelo RMI. Sendo interfaces remotas e
implementações concretas. Sendo as implementações separadas em um sub pacote denominado
impl. 

- #### Service

 Pacote que reune todos as entidades da camada de serviço do sistema
 
 ## Instruções
 
 A aplicação é dependente da biblioteca [Jackson Databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind). 
 
 O Apache Maven foi utilizado para fazer o gerenciamento das dependências do projeto.

 **É necessário executar o *rmiregistry* no diretório do código compilado para executar a aplicação.**
