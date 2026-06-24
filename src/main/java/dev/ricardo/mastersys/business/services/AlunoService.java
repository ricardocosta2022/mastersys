package dev.ricardo.mastersys.business.services;

import dev.ricardo.mastersys.business.specification.AlunoSpecification;
import dev.ricardo.mastersys.exceptions.RegraNegocioException;
import dev.ricardo.mastersys.infrastrucure.dtos.AlunoFiltroRequest;
import dev.ricardo.mastersys.infrastrucure.dtos.AlunoRequest;
import dev.ricardo.mastersys.infrastrucure.dtos.AlunoResponse;
import dev.ricardo.mastersys.infrastrucure.entitys.Aluno;
import dev.ricardo.mastersys.infrastrucure.repository.AlunoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoResponse cadastrar(AlunoRequest request){
        if(request != null){
            var aluno = alunoRepository.findByCpf(request.cpf() );
            if(aluno != null){
                throw new RegraNegocioException("Aluno já cadastrado com esse CPF");
            }
        }

        Aluno aluno = request.toEntity();
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoSalvo);

    }

    public Page<AlunoResponse> listar(AlunoFiltroRequest alunoFiltroRequest, Pageable pageable){
        return alunoRepository.findAll(AlunoSpecification.comFiltros(alunoFiltroRequest),pageable)
                .map(AlunoResponse::fromEntity);
    }

    public AlunoResponse buscarPorId(Long id){
        Aluno aluno = buscarEntityPorId(id);
        return AlunoResponse.fromEntity(aluno);
    }

    public AlunoResponse atualizar(Long id, AlunoRequest request) {
        Aluno aluno = buscarEntityPorId(id);

        request.preecher(aluno);
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoAtualizado);

    }

    public void excluir(Long id) {
        Aluno aluno = buscarEntityPorId(id);
        alunoRepository.delete(aluno);
    }


    private Aluno buscarEntityPorId(Long id){
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Aluno não encontrado com o ID: " + id));
    }




}
