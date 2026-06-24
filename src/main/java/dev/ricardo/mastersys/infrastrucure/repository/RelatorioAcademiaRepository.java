package dev.ricardo.mastersys.infrastrucure.repository;

import dev.ricardo.mastersys.infrastrucure.entitys.FaturaMatricula;
import dev.ricardo.mastersys.infrastrucure.projection.AlunosPorCidadeProjection;
import dev.ricardo.mastersys.infrastrucure.projection.FaturamentoMensalProjection;
import dev.ricardo.mastersys.infrastrucure.projection.FaturasEmAbertoProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface RelatorioAcademiaRepository extends Repository<FaturaMatricula, Long> {

    @Query(
            value = """
              SELECT TO_CHAR(f.data_vencimento, 'YYYY-MM') AS mes,
                     SUM(f.valor) AS total
              FROM faturas_matriculas f
              WHERE f.status = 'PAGA'
              GROUP BY TO_CHAR(f.data_vencimento, 'YYYY-MM')
              ORDER BY mes                                  
              """,
            nativeQuery = true
    )
    List<FaturamentoMensalProjection> obterFaturamentoMensal();


    @Query(
            value = """
                 SELECT cidade AS cidade,
                        COUNT(*) AS quantidade  
                 FROM alunos a
                 WHERE a.cidade IS NOT NULL
                 GROUP BY a.cidade
                 ORDER BY quantidade desc
                  """,
            nativeQuery = true
    )
   List<AlunosPorCidadeProjection> obterAlunosPorCidade();


    @Query(
            value = """
                 SELECT
                        a.id AS matricula,
                        a.nome AS alunoNome,
                        f.data_vencimento as dataVencimento,
                        f.valor
                 FROM faturas_matriculas f
                 JOIN matriculas m ON m.id = f.matricula_id
                 JOIN alunos a ON a.id = m.aluno_id
                 WHERE f.status = 'ABERTA'
                 ORDER BY f.data_vencimento desc
                  """,
            nativeQuery = true
    )
    List<FaturasEmAbertoProjection> obterFaturasEmAberto();


}
