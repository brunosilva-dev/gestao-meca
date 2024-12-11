package br.com.brunosilva.gestao_meca.exceptions;

public class UserFoundException extends RuntimeException {

  public UserFoundException() {
    super("Usuário já existe");
  }
}
