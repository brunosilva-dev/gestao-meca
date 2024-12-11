package br.com.brunosilva.gestao_meca;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestaoMecaApplication {

	private static final Logger logger = LoggerFactory.getLogger(GestaoMecaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GestaoMecaApplication.class, args);

		// Obtendo a data e hora atual
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String formattedDateTime = now.format(formatter);

		// Obtendo o usuário que restartou a aplicação
		String user = System.getProperty("user.name");

		// Log da mensagem
		String logMessage = String.format("Aplicação reiniciada em %s por %s", formattedDateTime, user);
		logger.info(logMessage);

		System.out.println("### Ambiente Gestão Meca no AR!!! ###");
	}

}
