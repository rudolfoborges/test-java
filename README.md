## Teste Java para processo seletivo

### Componentes:

* Campaign - API gestão de Campanhas
* User - API para gestão de Usuários
* Eureka Server - Server para register e discovery de serviços
* questao3 - Solução da questão 3

### Detalhes:

Todos os serviços foram desenvolvindos em Java com Spring Boot, banco de dados MySQL, Rabbit e Docker.

O Rabbit foi utilizado para atender os requisitos de notificação entre APIS e tolerância a falhas. Algumas ferramentas como Nextflix Feign também foram utilizadas para facilitar a comunicação entre os serviços.

Na comunicação entre a API de usuários e campanhas, em caso de indisponibilidade, são realizadas 5 novas tentativas e após esgotar todas as alternativas a mensagem é encaminhada para DLQ onde pode ser monitorada.

### Start do ambiente

Todo ambiente foi configurado utilizando containers docker em um arquivo docker-compose.

Em linux ou mac o start.sh fará o build e do docker-compose up

./start.sh

### Questão 3

./gradlew clean build runApp

### Questão 5
