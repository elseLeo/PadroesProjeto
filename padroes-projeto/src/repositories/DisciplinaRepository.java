package src.repositories;
import java.util.ArrayList;
import java.util.List;

import src.entities.DisciplinaEntity;


public class DisciplinaRepository {

    private static DisciplinaRepository instance;

    private List<DisciplinaEntity> disciplina;

    private DisciplinaRepository() {
        this.disciplina = new ArrayList<DisciplinaEntity>();
    }

    public static DisciplinaRepository getInstance() {
        if (instance == null) {
            instance = new DisciplinaRepository();
        }

        return instance;
    }

    public boolean insert(DisciplinaEntity disciplina) {
        return this.disciplina.add(disciplina);
    }

    public DisciplinaEntity getById(int id) {
        DisciplinaEntity disciplina = new DisciplinaEntity();

        disciplina.setIdDisciplina(id);

        int index = this.disciplina.indexOf(disciplina);

        if (index >= 0) {
            return this.disciplina.get(index);
        }

        return null;
    }

    public boolean update(DisciplinaEntity disciplina) {
        int index = this.disciplina.indexOf(disciplina);

        if (index >= 0) {
            this.disciplina.set(index, disciplina);

            return true;
        }

        return false;
    }

    public boolean delete(DisciplinaEntity disciplina) {
        return this.disciplina.remove(disciplina);
    }

    public int size() {
        return this.disciplina.size();
    }
}
