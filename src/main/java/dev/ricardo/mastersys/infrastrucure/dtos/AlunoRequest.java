package dev.ricardo.mastersys.infrastrucure.dtos;

import dev.ricardo.mastersys.infrastrucure.entitys.Aluno;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AlunoRequest(
        String nome,
        String cpf,
        LocalDate dataNascimento,
        String sexo,
        String telefone,
        String celular,
        String email,
        String observacao,
        String endereco,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {

   public Aluno toEntity() {
        Aluno aluno = new Aluno();
        preecher(aluno);
        return aluno;
    }

    public void preecher(Aluno aluno) {
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setDataNascimento(dataNascimento);
        aluno.setSexo(sexo);
        aluno.setTelefone(telefone);
        aluno.setCelular(celular);
        aluno.setEmail(email);
        aluno.setObservacao(observacao);
        aluno.setEndereco(endereco);
        aluno.setNumero(numero);
        aluno.setComplemento(complemento);
        aluno.setBairro(bairro);
        aluno.setCidade(cidade);
        aluno.setEstado(estado);
        aluno.setCep(cep);
    }

}
