package src.services;

import src.entities.AlunoEntity;
import src.entities.CursoEntity;
import src.repositories.AlunoRepository;

public class AlunoService {

    private static AlunoService instance;

    private AlunoRepository alunoRepository;

    private AlunoService() {
        this.alunoRepository = AlunoRepository.getInstance();
    }

    public static AlunoService getInstance() {
        if (instance == null) {
            instance = new AlunoService();
        }

        return instance;
    }

    public boolean insert(int matricula, String nome, boolean ativo, CursoEntity curso) {
        AlunoEntity aluno = new AlunoEntity();

        aluno.setMatricula(matricula);
        aluno.setNome(nome);
        aluno.setAtivo(ativo);
        aluno.setCurso(curso);

        return this.alunoRepository.insert(aluno);
    }

    public AlunoEntity getByMatricula(int matricula) {
        return this.alunoRepository.getByMatricula(matricula);
    }

    public boolean update(int matricula, String nome, boolean ativo, CursoEntity curso) {
        AlunoEntity aluno = this.getByMatricula(matricula);

        if (aluno != null) {
            aluno.setNome(nome);
            aluno.setAtivo(ativo);
            aluno.setCurso(curso);

            return this.alunoRepository.update(aluno);
        }

        return false;
    }

    public boolean delete(int matricula) {
        AlunoEntity aluno = new AlunoEntity();

        aluno.setMatricula(matricula);

        return this.alunoRepository.delete(aluno);
    }

    public int size() {
        return this.alunoRepository.size();
    }

}
