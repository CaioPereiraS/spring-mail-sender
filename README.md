# Spring Email Sending Application

This is a relatively simple Spring application for sending emails. It does not require a database, just accepts a POST request to send emails. Here's a basic guide to setup and usage.

## Configuration

To ensure the application works correctly, you need to configure the following properties in the `application.properties` file:

- `spring.mail.username`: The username of your SMTP email account.
- `spring.mail.password`: The password of your SMTP email account.

These credentials will be used to authenticate and send emails through the configured SMTP server.

## Endpoints

### Send Email 

- **Endpoint:** `/email`
- **Method:** POST
- **Corpo da Requisição / Request Body:**
  ```json
  {
      "ownerRef":"Nome",
      "emailFrom":"emailfrom@gmail.com",
      "emailTo":"emailto@gmail.com",
      "subject":"Teste envio email",
      "text":"Mensagem"
  }


## Functionality

1. A POST request is made to the /email endpoint with the email details.
2. The email is validated in the controller and passed to the service class.
3. The service class uses an email sender to send the email using the configured credentials.

## Custom Exceptions

The application uses custom exceptions to handle potential errors during email sending. If any problems occur, an appropriate exception will be thrown and handled.

## How to Run

1. Clone the repository.
2. Configure the email properties in the application.properties file.
3. Run the Spring application.
4. Make a POST request to the /email endpoint with the email details to be sent.

## Dependencies
- org.springframework.boot:spring-boot-starter-web
- org.projectlombok:lombok
- org.springframework.boot:spring-boot-starter-mail
- org.springframework.boot:spring-boot-starter-validation
