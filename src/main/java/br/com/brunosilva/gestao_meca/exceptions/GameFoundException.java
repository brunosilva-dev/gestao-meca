package br.com.brunosilva.gestao_meca.exceptions;

public class GameFoundException extends RuntimeException {
  public GameFoundException() {
    super("Jogo já existe!");
  }
}
