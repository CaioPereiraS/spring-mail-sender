# Aplicação de Envio de E-mails com Spring / Spring Email Sending Application

Esta é uma aplicação Spring relativamente simples para enviar e-mails. Não requer um banco de dados, apenas aceita uma requisição POST para enviar e-mails. Aqui está um guia básico de configuração e uso.
---
This is a relatively simple Spring application for sending emails. It does not require a database, just accepts a POST request to send emails. Here's a basic guide to setup and usage.


## Configuração / Configuration

Para que a aplicação funcione corretamente, é necessário configurar as seguintes propriedades no arquivo `application.properties`:

- `spring.mail.username`: O nome de usuário da sua conta de e-mail SMTP.
- `spring.mail.password`: A senha da sua conta de e-mail SMTP.

Essas credenciais serão usadas para autenticar e enviar e-mails através do servidor SMTP configurado.

---
To ensure the application works correctly, you need to configure the following properties in the `application.properties` file:

- `spring.mail.username`: The username of your SMTP email account.
- `spring.mail.password`: The password of your SMTP email account.

These credentials will be used to authenticate and send emails through the configured SMTP server.


## Endpoints

### Enviar E-mail / Send Email 

- **Endpoint:** `/email`
- **Método / Method:** POST
- **Corpo da Requisição / Request Body:**
  ```json
  {
      "ownerRef":"Nome",
      "emailFrom":"emailfrom@gmail.com",
      "emailTo":"emailto@gmail.com",
      "subject":"Teste envio email",
      "text":"Mensagem"
  }


## Funcionamento / Functionality

1. Uma requisição POST é feita para o endpoint `/email` com os detalhes do e-mail.
2. O e-mail é validado no controlador e passado para a classe de serviço.
3. A classe de serviço utiliza um e-mail sender para enviar o e-mail utilizando as credenciais configuradas.

---
1. A POST request is made to the /email endpoint with the email details.
2. The email is validated in the controller and passed to the service class.
3. The service class uses an email sender to send the email using the configured credentials.

## Exceções Personalizadas / Custom Exceptions

A aplicação utiliza exceções personalizadas para lidar com possíveis erros durante o envio de e-mails. Caso ocorra algum problema, uma exceção apropriada será lançada e tratada.

---

The application uses custom exceptions to handle potential errors during email sending. If any problems occur, an appropriate exception will be thrown and handled.

## Como Executar / How to Run

1. Clone o repositório.
2. Configure as propriedades do e-mail no arquivo `application.properties`.
3. Execute a aplicação Spring.
4. Faça uma requisição POST para o endpoint `/email` com os detalhes do e-mail a ser enviado.

---
1. Clone the repository.
2. Configure the email properties in the application.properties file.
3. Run the Spring application.
4. Make a POST request to the /email endpoint with the email details to be sent.

## Dependências / Dependencies
- org.springframework.boot:spring-boot-starter-web
- org.projectlombok:lombok
- org.springframework.boot:spring-boot-starter-mail
- org.springframework.boot:spring-boot-starter-validation
