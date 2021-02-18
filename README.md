# E-Commerce JSP and Servlet
Projeto de e-commerce com JSP, Servlet para a disciplina de Tópicos Java para Web (TJW).

Instruções:

*Banco de dados:*
- Crie um database chamado "lojinha";
- Tenha um usuário chamado "admin" e com a senha "123" no seu serviço do banco de dados;
- Após o download do projeto, import o arquivo "lojinha.sql" para o banco de dados "lojinha".

*Tomcat:*
- Utilizei o Tomcat v8.5;
- Caso queira utilizar esta versão, este é o link da página do instalador: https://tomcat.apache.org/download-80.cgi;
- Instale o novo server no eclipse, clicando na opção "New Server" ("Novo servidor");
- Selecione a pasta em que os arquivos do Tomcat baixado estão localizados;
- Finalize a instalação do "New Server".

*Projeto:*
- Importe o projeto como um Maven project;
- Execute um Maven -> Update Project, para baixar as dependências;
- Execute um "maven clean";
- Execute um "maven install";
- Adicione o web module do projeto no Tomcat;
- Execute o Tomcat (no meu caso, ele roda na porta 8080);
- A url definida para teste: "localhost:8080/lojinha".

*Usuários:*
- Login: jonathan   Senha: 123    Administrador?: Sim
- Login: lucas      Senha: 123    Administrador?: Não
