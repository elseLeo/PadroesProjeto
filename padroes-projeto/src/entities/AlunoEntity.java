package src.entities;

public class AlunoEntity {

    private int matricula;
    private String nome;
    private boolean ativo;
    private CursoEntity curso;

    @Override
    public boolean equals(Object obj) {
        return this.getMatricula() == ((AlunoEntity) obj).getMatricula();
    }

    @Override
    public String toString() {
        return new StringBuilder("Matrícula: ").append(this.matricula).append(", nome: ").append(this.nome)
                .append(", ativo: ").append(this.ativo == true ? "Sim" : "Não").append(", curso: ")
                .append(this.curso.getNome())
                .toString();
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setCurso(CursoEntity curso) {
        this.curso = curso;
    }

    public CursoEntity getCurso() {
        return this.curso;
    }

}
