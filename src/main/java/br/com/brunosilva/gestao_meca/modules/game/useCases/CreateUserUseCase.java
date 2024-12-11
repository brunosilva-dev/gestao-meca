package br.com.brunosilva.gestao_meca.modules.game.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunosilva.gestao_meca.exceptions.UserFoundException;
import br.com.brunosilva.gestao_meca.modules.game.entities.UserEntity;
import br.com.brunosilva.gestao_meca.modules.game.repositories.UserRepository;

@Service
public class CreateUserUseCase {

  @Autowired
  private UserRepository userRepository;

  public UserEntity execute(UserEntity userEntity) {
    this.userRepository.findByUsernameOrEmail(userEntity.getUsername(), userEntity.getEmail())
        .ifPresent((user) -> {
          throw new UserFoundException();
        });
    ;

    return this.userRepository.save(userEntity);
  }
}
