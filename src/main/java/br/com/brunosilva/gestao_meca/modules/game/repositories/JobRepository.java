package br.com.brunosilva.gestao_meca.modules.game.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brunosilva.gestao_meca.modules.game.entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

}
