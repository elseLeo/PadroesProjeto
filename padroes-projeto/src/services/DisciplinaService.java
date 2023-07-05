package src.services;

import src.entities.CursoEntity;
import src.entities.DisciplinaEntity;
import src.repositories.DisciplinaRepository;

public class DisciplinaService {

    private static DisciplinaService instance;

    private DisciplinaRepository disciplinaRepository;

    private DisciplinaService() {
        this.disciplinaRepository = DisciplinaRepository.getInstance();
    }

    public static DisciplinaService getInstance() {
        if (instance == null) {
            instance = new DisciplinaService();
        }

        return instance;
    }

    public boolean insert(int idDisciplina, String nome, String descricao, CursoEntity curso) {
        DisciplinaEntity disciplina = new DisciplinaEntity();

        disciplina.setIdDisciplina(idDisciplina);
        disciplina.setNome(nome);
        disciplina.setDescricao(descricao);
        disciplina.setCurso(curso);

        return this.disciplinaRepository.insert(disciplina);
    }

    public DisciplinaEntity getByIdDisciplina(int id) {
        return this.disciplinaRepository.getById(id);
    }

    public boolean update(int idDisciplina, String nome, String descricao, CursoEntity curso) {
        DisciplinaEntity disciplina = this.disciplinaRepository.getById(idDisciplina);

        if (disciplina != null) {
            disciplina.setNome(nome);
            disciplina.setDescricao(descricao);
            disciplina.setCurso(curso);

            return this.disciplinaRepository.update(disciplina);
        }

        return false;
    }

    public boolean delete(int id) {
        DisciplinaEntity disciplina = new DisciplinaEntity();

        disciplina.setIdDisciplina(id);

        return this.disciplinaRepository.delete(disciplina);
    }

    public int size() {
        return this.disciplinaRepository.size();
    }

}
