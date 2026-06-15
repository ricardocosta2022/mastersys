package dev.ricardo.mastersys.infrastrucure.repository;

import dev.ricardo.mastersys.infrastrucure.entitys.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
