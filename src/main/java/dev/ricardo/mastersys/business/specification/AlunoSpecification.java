package dev.ricardo.mastersys.business.specification;

import dev.ricardo.mastersys.infrastrucure.dtos.AlunoFiltroRequest;
import dev.ricardo.mastersys.infrastrucure.entitys.Aluno;
import org.springframework.data.jpa.domain.Specification;


/*
*  Specificao de filtro
* */
public class AlunoSpecification {

   public static Specification<Aluno> comFiltros(AlunoFiltroRequest filtro){
       return Specification
               .where(nomeContem(filtro.nome()))
               .and(emailContem(filtro.email()))
               .and(celularContem(filtro.celular()))
               .and(cidadeContem(filtro.cidade()))
               .and(estadoIgual(filtro.estado()));
   }

    public static Specification<Aluno> nomeContem(String nome){
       return ((root, query, criteriaBuilder) -> {
           if(nome == null || nome.isBlank()){
               return null;
           }

           return criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");

       });
   }

    public static Specification<Aluno> emailContem(String email){
        return ((root, query, criteriaBuilder) -> {
            if(email == null || email.isBlank()){
                return null;
            }

            return criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%" + email.toLowerCase() + "%");

        });
    }

    public static Specification<Aluno> celularContem(String celular){
        return ((root, query, criteriaBuilder) -> {
            if(celular == null || celular.isBlank()){
                return null;
            }

            return criteriaBuilder.like(criteriaBuilder.lower(root.get("celular")), "%" + celular.toLowerCase() + "%");

        });
    }

    public static Specification<Aluno> cidadeContem(String cidade){
        return ((root, query, criteriaBuilder) -> {
            if(cidade == null || cidade.isBlank()){
                return null;
            }

            return criteriaBuilder.like(criteriaBuilder.lower(root.get("cidade")), "%" + cidade.toLowerCase() + "%");

        });
    }


    public static Specification<Aluno> estadoIgual(String estado){
        return ((root, query, criteriaBuilder) -> {
            if(estado == null || estado.isBlank()){
                return null;
            }

            return criteriaBuilder.equal(criteriaBuilder.upper(root.get("estado")), estado.toLowerCase());

        });
    }


}







