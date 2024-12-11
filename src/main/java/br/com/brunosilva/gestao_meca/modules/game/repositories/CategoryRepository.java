package br.com.brunosilva.gestao_meca.modules.game.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brunosilva.gestao_meca.modules.game.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
  Optional<CategoryEntity> findByNameCategory(String nameCategory);
}
