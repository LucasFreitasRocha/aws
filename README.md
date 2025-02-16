# aws 

Este repositório tem como objetivo aprender sobre a nuvem AWS e explorar todos os seus recursos. No momento, possui apenas a conexão com o bucket S3, mas será expandido com o tempo.

#  LocalStack

junto com o estudo da aws , estou utilizando a ferramenta [localstack](https://www.localstack.cloud/) para simular o ambiente aws de maneira local

falo mais sobre isso nesse post no [medium](https://medium.com/@devrocha/localstack-alternativa-local-da-aws-para-estudo-08e1c175c2cc)



## Para o recurso REST, foi adicionado o Swagger  para facilitar a interação.

   O  [Swagger](https://swagger.io/) é um conjunto de ferramentas para projetar, documentar e testar APIs REST de forma interativa.
     Ele facilita a comunicação entre desenvolvedores e consumidores da API, permitindo que usuários explorem
     os endpoints, enviem requisições e vejam respostas diretamente em uma interface amigável.
    Ele usa o OpenAPI Specification (OAS) para descrever a API de maneira padronizada, ajudando na automação da documentação e na integração com outras ferramentas.
    Com o Swagger, você pode:
    ✅ Visualizar todos os endpoints da API e seus detalhes (métodos, parâmetros, respostas).
    ✅ Testar requisições diretamente pelo navegador.
    ✅ Gerar documentação automática e sempre atualizada.


## endpoints no momento
![image](https://github.com/user-attachments/assets/4c8459b5-8144-4eb6-b82b-62d55b57048e)

### File MultipartFile

    GET /v1/file - faz download do arquivo
    POST /v1/file - faz upload do arquivo

### File base 64

    GET /v1/file/base64 - retorna o arquivo em base64, fiz outro get justamente por cotnrato de response ser diferente

### consult
  
    GET /v1/consult - faz as consultas das keys
  
  
