package br.com.brunosilva.gestao_meca.exceptions.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {

  private String message;
  private String field;
}
