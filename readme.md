## User API
Esta API destina-se a gerenciar o  cadastro de clientes em um ecommerce.

Primeira parte - API de Usuarios

    Desenvolvimeento dos endpoints referentes aos usuarios.

### 1 - Servico Controller
- Serviço que permite a criação de métodos que serão chamados via Web utilizando o protocolo HTTP.

### 2 - UserDTO
- Objeto java - sera utilizada como o retorno dos métodos da camada Controller.



Segunda parte - conexão com banco de dados

    Conexão com banco de dados.

Terceira parte - camada model

    Criação do model do microserviço user.

Quarta parte - camada repository

    Responsável pelas consultas no BD.

Quinta parte - camada service

    É onde ficam as regras de negócio da aplicação.
    Chamam a classe da camada de repository.

Sexta parte - camada controller

    Chamara a classe da camada de serviço.
    removendo postconstructor que cria uma listagem em memoria.
