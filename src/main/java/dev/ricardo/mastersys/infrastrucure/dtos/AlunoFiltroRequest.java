package dev.ricardo.mastersys.infrastrucure.dtos;

public record AlunoFiltroRequest(

        String nome,
        String email,
        String celular,
        String cidade,
        String estado
) {


}
