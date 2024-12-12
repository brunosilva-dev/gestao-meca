package br.com.brunosilva.gestao_meca.modules.game.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunosilva.gestao_meca.modules.game.entities.JobEntity;
import br.com.brunosilva.gestao_meca.modules.game.repositories.JobRepository;

@Service
public class CreateJobUseCase {

  @Autowired
  private JobRepository jobRepository;

  public JobEntity execute(JobEntity jobEntity) {
    return this.jobRepository.save(jobEntity);
  }

}
