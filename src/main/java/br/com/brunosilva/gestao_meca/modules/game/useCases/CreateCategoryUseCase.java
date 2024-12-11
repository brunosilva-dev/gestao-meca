package br.com.brunosilva.gestao_meca.modules.game.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunosilva.gestao_meca.exceptions.CategoryFoundException;
import br.com.brunosilva.gestao_meca.modules.game.entities.CategoryEntity;
import br.com.brunosilva.gestao_meca.modules.game.repositories.CategoryRepository;

@Service
public class CreateCategoryUseCase {

  @Autowired
  private CategoryRepository categoryRepository;

  public CategoryEntity execute(CategoryEntity categoryEntity) {

    this.categoryRepository
        .findByNameCategory(categoryEntity.getNameCategory())
        .ifPresent((category) -> {
          throw new CategoryFoundException();
        });

    return this.categoryRepository.save(categoryEntity);
  }
}
