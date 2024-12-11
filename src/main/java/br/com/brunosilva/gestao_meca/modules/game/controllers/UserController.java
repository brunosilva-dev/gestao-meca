package br.com.brunosilva.gestao_meca.modules.game.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunosilva.gestao_meca.modules.game.entities.UserEntity;
import br.com.brunosilva.gestao_meca.modules.game.useCases.CreateUserUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

  // @Autowired
  // private UserRepository userRepository;

  @Autowired
  private CreateUserUseCase createUserUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody UserEntity userEntity) {
    // this.userRepository.findByUsernameOrEmail(userEntity.getUsername(),
    // userEntity.getEmail())
    // .ifPresent((user) -> {
    // throw new UserFoundException();
    // });
    // ;

    // return this.userRepository.save(userEntity);
    
    try {
      var result = this.createUserUseCase.execute(userEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
