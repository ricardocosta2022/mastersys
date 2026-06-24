package dev.ricardo.mastersys.controllers;


import dev.ricardo.mastersys.business.services.AlunoService;
import dev.ricardo.mastersys.doc.AlunoControllerDoc;
import dev.ricardo.mastersys.infrastrucure.dtos.AlunoFiltroRequest;
import dev.ricardo.mastersys.infrastrucure.dtos.AlunoRequest;
import dev.ricardo.mastersys.infrastrucure.dtos.AlunoResponse;
import dev.ricardo.mastersys.infrastrucure.entitys.Aluno;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController implements AlunoControllerDoc {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoResponse cadastrar(@RequestBody @Valid AlunoRequest request){
        return alunoService.cadastrar(request);
    }

    @GetMapping("/listar")
    public Page<AlunoResponse> listar(AlunoFiltroRequest alunoFiltroRequest , Pageable pageable){
        return alunoService.listar(alunoFiltroRequest, pageable);
    }

    @GetMapping("/{id}")
    public AlunoResponse buscarPorId(@PathVariable Long id){
        return alunoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AlunoResponse atualizar(@PathVariable @Valid Long id, @RequestBody AlunoRequest request) {
        return alunoService.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        alunoService.excluir(id);
    }






}
