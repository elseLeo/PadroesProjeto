package src.entities;

import src.services.DisciplinaService;

import java.util.ArrayList;
import java.util.List;

public class CursoEntity {

    private int id;
    private String nome;
    private String descricao;
    private List<AlunoEntity> alunos;
    private List<DisciplinaEntity> disciplinas;

    public CursoEntity() {
        this.alunos = new ArrayList<AlunoEntity>();
        this.disciplinas = new ArrayList<DisciplinaEntity>();
    }


    @Override
    public boolean equals(Object obj) {
        return this.id == ((CursoEntity) obj).getId();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("ID: ").append(this.id)
                .append("\nNome: ").append(this.nome)
                .append("\nDescrição: ").append(this.descricao);

        if (this.alunos.size() > 0) {
            result.append("\n--------------Alunos--------------");

            this.alunos.forEach(aluno -> {
                result.append("\nMatrícula: ").append(aluno.getMatricula())
                        .append("\nNome: ").append(aluno.getNome())
                        .append("\nAtivo: ").append(aluno.isAtivo() == true ? "Sim" : "Não");
            });
        }

        return result.toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public boolean insertAluno(AlunoEntity aluno) {
        return this.alunos.add(aluno);
    }

    public boolean deleteAluno(AlunoEntity aluno) {
        return this.alunos.remove(aluno);
    }
    public boolean insertDisciplina(DisciplinaEntity disciplina){
        return this.disciplinas.add(disciplina);
    }
    public boolean deleteDisciplina(DisciplinaEntity disciplina){
        return  this.disciplinas.remove(disciplina);
    }

    public int getAlunosSize() {
        return this.alunos.size();
    }

}
