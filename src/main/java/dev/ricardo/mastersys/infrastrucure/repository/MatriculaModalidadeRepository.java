package dev.ricardo.mastersys.infrastrucure.repository;

import dev.ricardo.mastersys.infrastrucure.entitys.MatriculaModalidade;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaModalidadeRepository extends JpaRepository<MatriculaModalidade, Long> {
}
