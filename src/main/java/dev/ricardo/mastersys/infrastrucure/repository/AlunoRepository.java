package dev.ricardo.mastersys.infrastrucure.repository;

import dev.ricardo.mastersys.infrastrucure.entitys.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
