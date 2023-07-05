package src.entities;

public class DisciplinaEntity {

    private int idDisciplina;
    private String nome;
    private String descricao;
    private CursoEntity curso;

    @Override
    public boolean equals(Object obj) {
        return this.idDisciplina == ((DisciplinaEntity)obj).getIdDisciplina();
    }

    @Override
    public String toString() {
        return new StringBuilder("ID Disciplina: ").append(this.idDisciplina).append(", nome: ").append(this.nome)
                .append(", Descrição: ").append(this.descricao).append(", Curso: ").append(this.curso.getNome()).toString();
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }


    public void setCurso(CursoEntity curso) {
        this.curso = curso;
    }

    public CursoEntity getCurso() {
        return this.curso;
    }

}