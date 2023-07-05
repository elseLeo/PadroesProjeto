package src.repositories;

import java.util.ArrayList;
import java.util.List;

import src.entities.CursoEntity;

public class CursoRepository {

    private static CursoRepository instance;

    private List<CursoEntity> cursos;

    private CursoRepository() {
        this.cursos = new ArrayList<CursoEntity>();
    }

    public static CursoRepository getInstance() {
        if (instance == null) {
            instance = new CursoRepository();
        }

        return instance;
    }

    public boolean insert(CursoEntity curso) {
        return this.cursos.add(curso);
    }

    public CursoEntity getByID(int id) {
        CursoEntity curso = new CursoEntity();

        curso.setId(id);

        int index = this.cursos.indexOf(curso);

        if (index >= 0) {
            return this.cursos.get(index);
        }

        return null;
    }

    public boolean update(CursoEntity curso) {
        int index = this.cursos.indexOf(curso);

        if (index >= 0) {
            this.cursos.set(index, curso);

            return true;
        }

        return false;
    }

    public boolean delete(CursoEntity curso) {
        return this.cursos.remove(curso);
    }

}
