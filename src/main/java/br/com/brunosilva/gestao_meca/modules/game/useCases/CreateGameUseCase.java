package br.com.brunosilva.gestao_meca.modules.game.useCases;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunosilva.gestao_meca.exceptions.GameFoundException;
import br.com.brunosilva.gestao_meca.modules.game.controllers.GameController;
import br.com.brunosilva.gestao_meca.modules.game.entities.GameEntity;
import br.com.brunosilva.gestao_meca.modules.game.repositories.GameRepository;

@Service
public class CreateGameUseCase {

  private static final Logger logger = LoggerFactory.getLogger(GameController.class);

  @Autowired
  private GameRepository gameRepository;

  public List<GameEntity> execute(List<GameEntity> gameEntities) {
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
