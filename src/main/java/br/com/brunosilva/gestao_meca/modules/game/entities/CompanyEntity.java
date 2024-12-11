package br.com.brunosilva.gestao_meca.modules.game.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity(name = "company")
@Data
public class CompanyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Size(min = 5, max = 20, message = "O nome de usuário deve ter entre 5 e 20 caracteres.")
  @Pattern(regexp = "^[a-zA-Z0-9_.-]+$", message = "O nome de usuário só pode conter letras, números, pontos, traços e underscores.")
  private String username;

  @Email(message = "O campo deve conter um e-mail válido!")
  private String email;

  @Size(min = 10, max = 30, message = "A senha deve ter entre 10 e 30 caracteres.")
  @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{10,30}$", message = "A senha deve ter entre 10 e 30 caracteres, incluir ao menos uma letra maiúscula, uma minúscula, um número e um caractere especial.")
  private String password;

  private String website;
  private String name;
  private String description;

  @CreationTimestamp
  private LocalDateTime createdAt;

}
