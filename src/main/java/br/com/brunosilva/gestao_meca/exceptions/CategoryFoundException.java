package br.com.brunosilva.gestao_meca.exceptions;

public class CategoryFoundException extends RuntimeException {

  public CategoryFoundException() {
    super("Categoria já existe!");
  }
}
