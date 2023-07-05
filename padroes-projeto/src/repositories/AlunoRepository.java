package src.repositories;
import java.util.ArrayList;
import java.util.List;

import src.entities.AlunoEntity;

public class AlunoRepository {

    private static AlunoRepository instance;

    private List<AlunoEntity> alunos;

    private AlunoRepository() {
        this.alunos = new ArrayList<AlunoEntity>();
    }

    public static AlunoRepository getInstance() {
        if (instance == null) {
            instance = new AlunoRepository();
        }

        return instance;
    }

    public boolean insert(AlunoEntity aluno) {
        return this.alunos.add(aluno);
    }

    public AlunoEntity getByMatricula(int matricula) {
        AlunoEntity aluno = new AlunoEntity();

        aluno.setMatricula(matricula);

        int index = this.alunos.indexOf(aluno);

        if (index >= 0) {
            return this.alunos.get(index);
        }

        return null;
    }

    public boolean update(AlunoEntity aluno) {
        int index = this.alunos.indexOf(aluno);

        if (index >= 0) {
            this.alunos.set(index, aluno);

            return true;
        }

        return false;
    }

    public boolean delete(AlunoEntity aluno) {
        return this.alunos.remove(aluno);
    }

    public int size() {
        return this.alunos.size();
    }
}
