# Gestão de Tarefas - Aplicação JSF

## Tecnologias usadas
- Java 17
- Jakarta EE / JSF
- Hibernate / JPA
- H2 Database (em memória para testes)
- Maven
- Tomcat 10

## Funcionalidades implementadas
- Criar, listar, concluir e remover tarefas.
- Persistência de tarefas com JPA.
- Enumerações para Prioridade e Situação.
- Interface web usando JSF.

## Itens implementados conforme orientação
- a) ✅ Aplicação Java Web com JSF
- b) ⚠️ Persistência em banco (H2 usado, PostgreSQL configurável)
- c) ✅ Uso de JPA
- d) ❌ Testes unitários
- e) ❌ Publicação em cloud


## Como rodar localmente
1. Instalar Java 17 e Maven.

2. Configurar Tomcat 10.

3. Clonar este repositório:  
   ```bash
   git clone https://github.com/poliana-dev/gestao-tarefas.git
   ```
4. Entrar na pasta do projeto: `cd gestao-tarefas`

5. Build e deploy no Tomcat:  `mvn clean package`  
   Copiar o `.war` gerado para a pasta `webapps` do Tomcat.
   > Utilizei o IDE Intellij, portanto ainda desconheço como executar o projeto a partir daqui no VSCode 

6. Acessar no navegador:  
   `http://localhost:8080/gestao-tarefas/index.xhtml`

## Observações
- O projeto usa H2 em memória para facilitar testes locais.
- Para usar PostgreSQL, alterar `persistence.xml` e adicionar driver no Maven.

## Reflexão
Este foi meu primeiro projeto usando JSF e persistência com JPA. 
Aprendi muito sobre a estrutura de um projeto Java Web, configuração do Tomcat, Maven e bancos de dados. 
- Preciso estudar mais, para ter clareza sobre quais dependencias se aplicam melhor para as necessidades do projeto.
- Me aprofundar mais em Java Web



