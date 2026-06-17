package dev.ricardo.mastersys.infrastrucure.dtos;

import dev.ricardo.mastersys.infrastrucure.entitys.Aluno;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoRequest(

        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 255, message = "O nome deve conter no máximo 255 caracteres")
        String nome,

        String cpf,

        @Past(message = "A data de nascimento deve ser no passado")
        LocalDate dataNascimento,

        @Size(max = 1, message = "O sexo deve conter no máximo 1 caractere")
        String sexo,

        @Size(max = 20, message = "O telefone deve conter no máximo 20 caracteres")
        String telefone,

        @Size(max = 20, message = "O celular deve conter no máximo 20 caracteres")
        String celular,

        @Email(message = "email inválido")
        @Size(max = 255, message = "O email deve conter no máximo 255 caracteres")
        String email,

        String observacao,

        @Size(max = 255, message = "O endereço deve conter no máximo 255 caracteres")
        String endereco,

        @Size(max=20 , message = "O numero dever conter no máximo 20 caracteres")
        String numero,

        @Size(max = 255, message = "O complemento deve conter no máximo 255 caracteres")
        String complemento,

        @Size(max = 255, message = "O bairro deve conter no máximo 255 caracteres")
        String bairro,

        @Size(max = 255, message = "A cidade deve conter no máximo 255 caracteres")
        String cidade,

        @Size(max = 255 , message = "O estado deve conter no máximo 255 caracteres")
        String estado,

        @Size(max = 20, message = "O cep deve conter no máximo 20 caracteres")
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
