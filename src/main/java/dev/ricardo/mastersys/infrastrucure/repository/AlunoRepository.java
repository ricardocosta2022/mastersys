package dev.ricardo.mastersys.infrastrucure.repository;

import dev.ricardo.mastersys.infrastrucure.entitys.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlunoRepository extends JpaRepository<Aluno, Long>, JpaSpecificationExecutor<Aluno> {

    Aluno findByCpf(String cpf);

}
