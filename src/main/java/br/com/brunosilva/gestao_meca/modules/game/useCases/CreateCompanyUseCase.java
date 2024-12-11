package br.com.brunosilva.gestao_meca.modules.game.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunosilva.gestao_meca.exceptions.UserFoundException;
import br.com.brunosilva.gestao_meca.modules.game.entities.CompanyEntity;
import br.com.brunosilva.gestao_meca.modules.game.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

  @Autowired
  private CompanyRepository companyRepository;

  public CompanyEntity execute(CompanyEntity companyEntity) {

    this.companyRepository
        .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent((company) -> {
          throw new UserFoundException();
        });

    return this.companyRepository.save(companyEntity);
  }
}
