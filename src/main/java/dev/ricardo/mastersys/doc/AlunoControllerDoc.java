package dev.ricardo.mastersys.doc;

import dev.ricardo.mastersys.infrastrucure.dtos.AlunoFiltroRequest;
import dev.ricardo.mastersys.infrastrucure.dtos.AlunoRequest;
import dev.ricardo.mastersys.infrastrucure.dtos.AlunoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.RequestBody;


/*
*   Documentação dos metodos
*   inserir o implements no CONTROLLER correspondente
*
* */

@Tag(
        name = "Alunos",
        description = "Operações para cadastro, consulta , atualização , exclusão " +
                " e filtragem de alunos."
)
public interface AlunoControllerDoc {

    @Operation(
            summary = "Cadatrar aluno",
            description = "Cria um novo aluno no sistema de academia",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Aluno cadastrado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Erro de validação ou regra de negocio",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    )

            }
    )
    AlunoResponse cadastrar(
            @RequestBody @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                           description = "Dados necessários para cadastrar um aluno",
                           required = true,
                           content = @Content(schema = @Schema(implementation = ErrorResponse.class),
                           examples = @ExampleObject(
                                    name = "Aluno valido",
                                   value = """
                                           {
                                              "nome":"amanda ",
                                               "cpf":"44898726888",
                                               "dataNascimento": "1995-08-15",
                                               "sexo": "M",
                                               "telefone":"45654488",
                                               "celular": "11985956128",
                                               "email": "amanda@email.com",
                                               "observacao":"apartamento 58",
                                               "endereco": "Rua das Flores",
                                               "numero": "200",
                                               "complemento": "bloco 08",
                                               "bairro": "Santa Rosa",
                                               "cidade": "São Paulo",
                                               "estado": "São Paulo",
                                               "cep": "08988520"
                                           }
                                           """
                           ))
            )
            AlunoRequest request
    );


    @Operation(
            summary = "Listar alunos",
            description = "Lista alunos de forma paginada, permitindo filtros opcionais por " +
                    " nome, email, celular, cidade e estado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "lista de alunos retornada com sucesso.")
            }

    )
    Page<AlunoResponse> listar(
            @Parameter(description = "Filtros opcionais para busca de alunos")
            AlunoFiltroRequest filtro,

            @Parameter(description = "Informações de paginação e ordenação")
            Pageable pageable
    );



    @Operation(
            summary = "Buscar aluno por ID",
            description = "Retorna os dados resumidos de um aluno especifico",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
                    @ApiResponse(responseCode = "400", description = "Aluno não encontrado",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            }

    )
    AlunoResponse buscarPorId(
            @Parameter(description = "ID do aluno", example = "2", required = true)
            Long id);







}

































