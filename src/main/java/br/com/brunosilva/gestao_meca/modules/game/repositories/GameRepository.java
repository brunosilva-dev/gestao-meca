package br.com.brunosilva.gestao_meca.modules.game.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brunosilva.gestao_meca.modules.game.entities.GameEntity;

public interface GameRepository extends JpaRepository<GameEntity, Long> {
  Optional<GameEntity> findByTitle(String title);
}
