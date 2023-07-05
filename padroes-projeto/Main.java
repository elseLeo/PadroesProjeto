import java.util.Scanner;

import src.entities.AlunoEntity;
import src.entities.CursoEntity;
import src.services.AlunoService;
import src.services.CursoService;
import src.entities.DisciplinaEntity;
import src.services.DisciplinaService;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static AlunoService alunoService = AlunoService.getInstance();
    private static CursoService cursoService = CursoService.getInstance();
    private static DisciplinaService disciplinaService = DisciplinaService.getInstance();

    public static int readInt() {
        boolean valorInvalido = true;
        int result = 0;

        do {
            try {
                result = Integer.parseInt(scanner.nextLine());

                valorInvalido = false;
            } catch (Exception ex) {
                System.out.println("Valor inválido");
            }
        } while (valorInvalido == true);

        return result;
    }

    public static boolean readAtivo() {
        boolean valorInvalido = true;
        boolean result = false;
        String leitura;

        do {
            leitura = scanner.nextLine();

            if ("S".equals(leitura) || "N".equals(leitura)) {
                result = "S".equals(leitura) ? true : false;

                valorInvalido = false;
            } else {
                System.out.println("Valor inválido, favor informar somente \"S\" ou \"N\"");
            }
        } while (valorInvalido == true);

        return result;
    }

    public static void main(String[] args) {
        int opcao = 0;

        do {
            System.out.println(
                    "1 - Cadastrar Curso\n2 - Pesquisar Curso\n3 - Alterar Curso\n4 - Excluir Curso\n5 - Cadastrar Aluno\n6 - Pesquisar Aluno\n7 - Alterar Aluno\n8 - Excluir Aluno\n9 - Cadastar Disciplina\n10 - Pesquisar Disciplina\n11 - Alterar Disciplina\n12 - Excluir Disciplina\n13 - Sair");

            opcao = readInt();

            int matricula;
            int idCurso;
            int idDisciplina;
            String nome;
            String descricao;
            AlunoEntity aluno;
            CursoEntity curso;
            DisciplinaEntity disciplina;

            switch (opcao) {
                case 1:
                    System.out.println("Informe o ID do curso:");
                    idCurso = readInt();

                    if (idCurso > 0) {
                        System.out.println("Informe o nome do curso:");
                        nome = scanner.nextLine();

                        System.out.println("Informe a descrição do curso:");
                        descricao = scanner.nextLine();

                        if (cursoService.insert(idCurso, nome, descricao) == true) {
                            System.out.println("Curso inserido com sucesso");
                        } else {
                            System.out.println("Falha ao tentar inserir o curso");
                        }
                    } else {
                        System.out.println("ID inválido, favor informar somente números inteiros positivos");
                    }
                    break;
                case 2:
                    System.out.println("Informe o ID do curso:");
                    idCurso = readInt();

                    curso = cursoService.getByID(idCurso);

                    if (curso != null) {
                        System.out.println(curso);
                    } else {
                        System.out.println("Curso não encontrado");
                    }

                    break;
                case 3:
                    System.out.println("Informe o ID do curso:");
                    idCurso = readInt();

                    curso = cursoService.getByID(idCurso);

                    if (curso != null) {
                        System.out.println("Informe o novo nome do curso:");
                        nome = scanner.nextLine();

                        System.out.println("Informe a nova descrição do curso:");
                        descricao = scanner.nextLine();

                        if (cursoService.update(idCurso, nome, descricao) == true) {
                            System.out.println("Curso alterado com sucesso");
                        } else {
                            System.out.println("Falha ao tentar alterar o curso");
                        }
                    } else {
                        System.out.println("Curso não encontrado");
                    }

                    break;
                case 4:
                    System.out.println("Informe o ID do curso:");
                    idCurso = readInt();

                    curso = cursoService.getByID(idCurso);

                    if (curso != null) {
                        if (curso.getAlunosSize() == 0) {
                            if (cursoService.delete(idCurso) == true) {
                                System.out.println("Curso removido com sucesso");
                            } else {
                                System.out.println("Falha ao tentar remover o curso");
                            }
                        } else {
                            System.out.println("O curso não pode ser excluído, pois possui alunos matriculados");
                        }
                    } else {
                        System.out.println("Curso não encontrado");
                    }

                    break;
                case 5:
                    System.out.println("Informe o ID do curso do aluno:");
                    idCurso = readInt();

                    curso = cursoService.getByID(idCurso);

                    if (curso != null) {
                        System.out.println("Informe a matrícula do aluno:");
                        matricula = readInt();

                        if (matricula > 0) {
                            System.out.println("Informe o nome do aluno:");
                            nome = scanner.nextLine();

                            boolean ativo = true;

                            if (alunoService.insert(matricula, nome, ativo, curso) == true) {
                                curso.insertAluno(alunoService.getByMatricula(matricula));

                                System.out.println("Aluno inserido com sucesso");
                            } else {
                                System.out.println("Falha ao tentar inserir o aluno");
                            }
                        } else {
                            System.out.println("Matrícula inválida, favor informar somente números inteiros positivos");
                        }
                    } else {
                        System.out.println("Curso não encontrado");
                    }

                    break;
                case 6:
                    System.out.println("Informe a matrícula do aluno:");
                    matricula = readInt();

                    aluno = alunoService.getByMatricula(matricula);

                    if (aluno != null) {
                        System.out.println(aluno);
                    } else {
                        System.out.println("Aluno não encontrado");
                    }

                    break;
                case 7:
                    System.out.println("Informe a matrícula do aluno:");
                    matricula = readInt();

                    aluno = alunoService.getByMatricula(matricula);

                    if (aluno != null) {
                        System.out.println("Informe o ID do novo curso do aluno:");
                        idCurso = readInt();

                        curso = cursoService.getByID(idCurso);

                        if (curso != null) {
                            System.out.println("Informe o novo nome do aluno:");
                            nome = scanner.nextLine();

                            System.out.println("Informe se o aluno está ativo (S/N):");
                            boolean ativo = readAtivo();

                            if (alunoService.update(matricula, nome, ativo, curso) == true) {
                                System.out.println("Aluno alterado com sucesso");
                            } else {
                                System.out.println("Falha ao tentar alterar o aluno");
                            }
                        } else {
                            System.out.println("Curso não encontrado");
                        }
                    } else {
                        System.out.println("Aluno não encontrado");
                    }

                    break;
                case 8:
                    System.out.println("Informe a matrícula do aluno:");
                    matricula = readInt();

                    aluno = alunoService.getByMatricula(matricula);

                    if (aluno != null) {
                        if (alunoService.delete(matricula) == true) {
                            aluno.getCurso().deleteAluno(aluno);

                            System.out.println("Aluno removido com sucesso");
                        } else {
                            System.out.println("Falha ao tentar remover o aluno");
                        }
                    } else {
                        System.out.println("Aluno não encontrado");
                    }

                    break;

                case 9:
                    System.out.println("Informe o ID do curso:");
                    idCurso = readInt();

                    curso = cursoService.getByID(idCurso);

                    if (curso != null) {
                        System.out.println("Informe a id da Disciplina:");
                        idDisciplina = readInt();

                        if (idDisciplina > 0) {
                            System.out.println("Informe o nome da Disciplina:");
                            nome = scanner.nextLine();
                            System.out.println("Informe a descrição da Disciplina:");
                            descricao = scanner.nextLine();


                            if (disciplinaService.insert(idDisciplina, nome, descricao, curso) == true) {
                                curso.insertDisciplina(disciplinaService.getByIdDisciplina(idDisciplina));

                                System.out.println("Disciplina inserida com sucesso");
                            } else {
                                System.out.println("Falha ao tentar inserir a Disciplina");
                            }
                        } else {
                            System.out.println("ID Disciplina inválida, favor informar somente números inteiros positivos");
                        }
                    } else {
                        System.out.println("Curso não encontrado");
                    }

                    break;
                case 10:
                    System.out.println("Informe a id da Disciplina:");
                    idDisciplina = readInt();

                    disciplina = disciplinaService.getByIdDisciplina(idDisciplina);

                    if (disciplina != null) {
                        System.out.println(disciplina);
                    } else {
                        System.out.println("Disciplina não encontrada");
                    }
                    break;
                case 11:
                    System.out.println("Informe a id da Disciplina:");
                    idDisciplina = readInt();

                    disciplina = disciplinaService.getByIdDisciplina(idDisciplina);

                    if (disciplina != null) {
                        System.out.println("Informe o ID do novo curso da disciplina:");
                        idCurso = readInt();

                        curso = cursoService.getByID(idCurso);

                        if (curso != null) {
                            System.out.println("Informe o novo nome da Disciplina:");
                            nome = scanner.nextLine();
                            System.out.println("Informe a descrição da Disciplina:");
                            descricao = scanner.nextLine();

                            if (disciplinaService.update(idDisciplina, nome, descricao, curso)) {
                                System.out.println("Disciplina alterada com sucesso");
                            } else {
                                System.out.println("Falha ao tentar alterar a Disciplina");
                            }
                        } else {
                            System.out.println("Curso não encontrado");
                        }
                    } else {
                        System.out.println("Disciplina não encontrado");
                    }

                    break;
                case 12:
                    System.out.println("Informe a ID da Disciplina:");
                    idDisciplina = readInt();

                    disciplina = disciplinaService.getByIdDisciplina(idDisciplina);

                    if (disciplina != null) {
                        if (disciplinaService.delete(idDisciplina) == true) {
                            disciplina.getCurso().deleteDisciplina(disciplina);

                            System.out.println("Disciplina removida com sucesso");
                        } else {
                            System.out.println("Falha ao tentar remover a Disciplina");
                        }
                    } else {
                        System.out.println("Disciplina não encontrada");
                    }

                    break;

            }
        } while (opcao != 13);
    }

}
