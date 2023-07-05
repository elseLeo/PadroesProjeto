package src.services;

import src.entities.CursoEntity;
import src.repositories.CursoRepository;

public class CursoService {

    private static CursoService instance;

    private CursoRepository cursoRepository;

    private CursoService() {
        this.cursoRepository = CursoRepository.getInstance();
    }

    public static CursoService getInstance() {
        if (instance == null) {
            instance = new CursoService();
        }

        return instance;
    }

    public boolean insert(int id, String nome, String descricao) {
        CursoEntity curso = new CursoEntity();

        curso.setId(id);
        curso.setNome(nome);
        curso.setDescricao(descricao);

        return this.cursoRepository.insert(curso);
    }

    public CursoEntity getByID(int id) {
        return this.cursoRepository.getByID(id);
    }

    public boolean update(int id, String nome, String descricao) {
        CursoEntity curso = this.getByID(id);

        if (curso != null) {
            curso.setNome(nome);
            curso.setDescricao(descricao);

            return this.cursoRepository.update(curso);
        }

        return false;
    }

    public boolean delete(int id) {
        CursoEntity curso = new CursoEntity();

        curso.setId(id);

        return this.cursoRepository.delete(curso);
    }

}
