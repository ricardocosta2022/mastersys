package dev.ricardo.mastersys.infrastrucure.entitys;

import jakarta.persistence.*;
import org.hibernate.annotations.Audited;

@Entity
@Table(name = "graduacoes")
public class Graduacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Relacionamento com Modalidade
    // Uma modalidade pode ter várias graduações, mas uma graduação pertence a uma modalidade
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "modalidade_id")
    private Modalidade modalidade;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
}
