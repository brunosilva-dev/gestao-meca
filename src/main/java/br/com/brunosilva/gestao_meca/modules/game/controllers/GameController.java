package br.com.brunosilva.gestao_meca.modules.game.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunosilva.gestao_meca.exceptions.GameFoundException;
import br.com.brunosilva.gestao_meca.modules.game.entities.GameEntity;
import br.com.brunosilva.gestao_meca.modules.game.repositories.GameRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/game")
public class GameController {

  private static final Logger logger = LoggerFactory.getLogger(GameController.class);

  @Autowired
  private GameRepository gameRepository;

  /*
   * Método POST simples
   * O POST abaixo vai enviar um objeto por vez
   */
  // @PostMapping("/")
  // public GameEntity create(@RequestBody GameEntity gameEntity) {
  // logger.info("Recebendo jogo para criar: {}", gameEntity);
  // this.gameRepository.findByTitle(gameEntity.getTitle())
  // .ifPresent((game) -> {
  // throw new GameFoundException();
  // });
  // ;

  // GameEntity savedGame = this.gameRepository.save(gameEntity);
  // logger.info("Jogo salvo com sucesso: {}", savedGame);

  // return savedGame;
  // }

  /**
   * Método POST complexo
   * Esse método POST abaixo foi transformado para que envie uma lista de objeto,
   * onde
   * 
   */
  @PostMapping("/")
  public List<GameEntity> create(@Valid @RequestBody List<GameEntity> gameEntities) {
    logger.info("Recebendo jogo para criar: {}", gameEntities);
    System.out.println("Recebido: " + gameEntities);
    gameEntities.forEach(gameEntity -> {
      this.gameRepository.findByTitle(gameEntity.getTitle())
          .ifPresent((game) -> {
            throw new GameFoundException();
          });
      this.gameRepository.save(gameEntity);
    });
    return gameEntities;
  }

}
