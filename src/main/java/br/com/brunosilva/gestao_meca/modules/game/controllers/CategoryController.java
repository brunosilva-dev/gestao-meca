package br.com.brunosilva.gestao_meca.modules.game.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunosilva.gestao_meca.modules.game.entities.CategoryEntity;
import br.com.brunosilva.gestao_meca.modules.game.useCases.CreateCategoryUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

  @Autowired
  private CreateCategoryUseCase createCategoryUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody CategoryEntity categoryEntity) {
    try {
      var result = this.createCategoryUseCase.execute(categoryEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
