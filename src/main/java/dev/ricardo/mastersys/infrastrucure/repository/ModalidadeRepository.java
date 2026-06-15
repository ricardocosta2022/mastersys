package dev.ricardo.mastersys.infrastrucure.repository;

import dev.ricardo.mastersys.infrastrucure.entitys.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModalidadeRepository extends JpaRepository<Modalidade, Long> {
}
