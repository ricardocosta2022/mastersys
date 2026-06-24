package dev.ricardo.mastersys.controllers;

import dev.ricardo.mastersys.infrastrucure.projection.AlunosPorCidadeProjection;
import dev.ricardo.mastersys.infrastrucure.projection.FaturamentoMensalProjection;
import dev.ricardo.mastersys.infrastrucure.projection.FaturasEmAbertoProjection;
import dev.ricardo.mastersys.infrastrucure.repository.RelatorioAcademiaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioAcademiaController {

    private final RelatorioAcademiaRepository relatorioAcademiaRepository;

    public RelatorioAcademiaController(RelatorioAcademiaRepository relatorioAcademiaRepository) {
        this.relatorioAcademiaRepository = relatorioAcademiaRepository;
    }

    @GetMapping("/faturamento-mensal")
    public List<FaturamentoMensalProjection> faturamentoMensal(){
        return relatorioAcademiaRepository.obterFaturamentoMensal();
    }

    @GetMapping("/alunos-por-cidade")
    public List<AlunosPorCidadeProjection> alunosPorCidade(){
        return relatorioAcademiaRepository.obterAlunosPorCidade();
    }

    @GetMapping("/faturamento-aberto")
    public List<FaturasEmAbertoProjection> faturamentoEmAberto(){
        return relatorioAcademiaRepository.obterFaturasEmAberto();
    }



}
