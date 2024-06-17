Este repositório traz a solução em projeto para o cadastro de dados de um cliente dentro de uma estrutura empresarial, de forma que outras aplicações internas da empresa possam cadastrar, consultar, atualizar e deletar de forma simples e eficiente os dados necessários para o cliente.

Sua estrutura baseia-se em uma arquitetura modernizada com serviços da AWS e a tecnologia utilizada foi java 17 com framework springboot, criando assim uma API Rest para as funcionalidades e   disponibilizada em uma instância EC2:

![Dados Cadastrais](https://github.com/rafael3423/dados-cadastrais/assets/67655762/6f477666-dc96-4893-a9a9-8026b65e0de7)

 

 

Os métodos utilizados para o gerenciamento dos dados cadastrais são respectivamente as funções de um CRUD:

**POST em /v1/dados-cadastrais/cadastrar**: Utilziado para cadastro do cliente através de um input de informações.

**PUT em /v1/dados-cadastrais/atualizar/**: Utilziado para atualização de dados do cliente.

**GET em /v1/dados-cadastrais/consultar/{id_cliente)**: Utilizado para consultar dados do cliente previamente cadastrado/atualizado.

**DELETE em /v1/dados-cadastrais/deletar/{id_cliente)**: Utilizado para exclusão de todos os dados do cliente previamente cadastrado/atualizado.

 

Para execução em ambiente local (desenvolvedor), a aplicação entra em execução no host local na pora 9090 e a conexão com o banco de dados foi utilizado a imagem localstack do Docker, sendo necessário que esta imagem possua o serviço **DynanoDB** disponibilizado no host **http://localhost:4566**
