package br.com.brunosilva.gestao_meca.modules.game.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brunosilva.gestao_meca.modules.game.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
  Optional<UserEntity> findByUsernameOrEmail(String username, String email);
}
