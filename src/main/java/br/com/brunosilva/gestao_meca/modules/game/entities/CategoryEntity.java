package br.com.brunosilva.gestao_meca.modules.game.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name = "category")
@Data
public class CategoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "O campo não pode ser em branco!")
  private String nameCategory;

  @ManyToMany(mappedBy = "categories")
  private Set<GameEntity> games;
}
