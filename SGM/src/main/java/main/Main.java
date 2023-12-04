package main;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.swing.JOptionPane;

import bean.Curso;
import bean.Disciplina;
import bean.Semestre;
import bean.Vinculo;
import dao.CursoDAO;
import dao.DisciplinaDAO;
import dao.SemestreDAO;
import dao.VinculoDAO;

public class Main {

	public Main() {
		changeEncoding();
		CursoDAO cursodao = new CursoDAO();
		DisciplinaDAO disciplinadao = new DisciplinaDAO();
		SemestreDAO semestredao = new SemestreDAO();
		VinculoDAO vinculodao = new VinculoDAO();

		try {
			while(true) {
				int operacao = Integer.parseInt(JOptionPane.showInputDialog("Informe a operacao que voce deseja fazer:"
						+ "\n1- Cadastrar Curso"
						+ "\n2- Cadastrar Disciplina"
						+ "\n3- Cadastrar Semestre"
						+ "\n4- Vincular Disciplina/Semestre"
						+ "\n5- Consultar Cursos"
						+ "\n6- Consultar Disciplinas"
						+ "\n7- Consultar Disciplinas por Semestre"
						+ "\n8- Consultar Total de Carga Horaria por Semestre"
						+ "\n9- Consultar Total de Carga Horaria Teorica ou Pratica"
						+ "\n0- Sair"));
				
				int id = 0, cadastro = 0;
				String descricao;
				String resultCursos = "", resultDisciplinas = "", resultSemestres = "";
				for (Curso curso : cursodao.findAll()) {
					resultCursos += ("\n" + curso);
				}
				
				for (Disciplina disciplina : disciplinadao.findAll()) {
					resultDisciplinas += ("\n" + disciplina);
				}
				
				for (Semestre semestre : semestredao.findAll()) {
					resultSemestres += ("\n" + semestre);
				}


				switch (operacao) {	
				
					//Cadastrar Curso
					case 1:						
						cadastro = Integer.parseInt(JOptionPane.showInputDialog("Informe o que voce deseja fazer:"
								+ "\n1- Inserir"
								+ "\n2- Atualizar"
								+ "\n3- Excluir"
								+ "\n4- Voltar"));
		
						switch (cadastro) {
							case 1:
								descricao = JOptionPane.showInputDialog("Informe a descricao do curso");
								cursodao.insert(new Curso(0, descricao));
								break;
						
							case 2:
								id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do curso" + resultCursos));
								descricao = JOptionPane.showInputDialog("Informe a descricao do curso");
								cursodao.update(new Curso(id, descricao));
								break;
						
							case 3:
								id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do curso" + resultCursos));
								cursodao.delete(id);
								break;
						}
				
					//Cadastrar Disciplina
					case 2:
						cadastro = Integer.parseInt(JOptionPane.showInputDialog("Informe o que voce deseja fazer:"
								+ "\n1- Inserir"
								+ "\n2- Atualizar"
								+ "\n3- Excluir"
								+ "\n4- Voltar"));
						
						String codigo, nome, nucleo;
						float chats_pratica, chats_teorica, chats_distancia, chts_pratica, 
								chts_teorica, chts_distancia;
						
		
						switch (cadastro) {
							case 1:
								nome = JOptionPane.showInputDialog("Informe o nome da disciplina");
								codigo = JOptionPane.showInputDialog("Informe o codigo da disciplina");
								nucleo = JOptionPane.showInputDialog("Informe o nucleo da disciplina");
								chats_pratica = Integer.parseInt(JOptionPane.showInputDialog("Informe o CHATS Pratica"));
								chats_teorica = Integer.parseInt(JOptionPane.showInputDialog("Informe o CHATS Teorica"));
								chats_distancia = Integer.parseInt(JOptionPane.showInputDialog("Informe o CHATS Distancia"));
								chts_pratica = Integer.parseInt(JOptionPane.showInputDialog("Informe o CHTS Pratica"));
								chts_teorica = Integer.parseInt(JOptionPane.showInputDialog("Informe o CHTS Teorica"));
								chts_distancia = Integer.parseInt(JOptionPane.showInputDialog("Informe o CHTS Distancia"));
								disciplinadao.insert(new Disciplina(id, codigo, nome, nucleo, chats_pratica, chats_teorica, 
										chats_distancia, chts_pratica, chts_teorica, chts_distancia));
								break;
						
							case 2:
								id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id da disciplina" + resultDisciplinas));
								nome = JOptionPane.showInputDialog("Informe o nome da disciplina");
								codigo = JOptionPane.showInputDialog("Informe o codigo da disciplina");
								nucleo = JOptionPane.showInputDialog("Informe o nucleo da disciplina");
								chats_pratica = Integer.parseInt(JOptionPane.showInputDialog("Informe o CHATS Pratica"));
								chats_teorica = Integer.parseInt(JOptionPane.showInputDialog("Informe o CHATS Teorica"));
								chats_distancia = Integer.parseInt(JOptionPane.showInputDialog("Informe o CHATS Distancia"));
								chts_pratica = Integer.parseInt(JOptionPane.showInputDialog("Informe o CHTS Pratica"));
								chts_teorica = Integer.parseInt(JOptionPane.showInputDialog("Informe o CHTS Teorica"));
								chts_distancia = Integer.parseInt(JOptionPane.showInputDialog("Informe o CHTS Distancia"));
								disciplinadao.update(new Disciplina(id, codigo, nome, nucleo, chats_pratica, chats_teorica, 
										chats_distancia, chts_pratica, chts_teorica, chts_distancia));
								break;
						
							case 3:
								id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id da disciplina" + resultDisciplinas));
								disciplinadao.delete(id);
								break;
						}
						break;
		
					// Cadastrar Semestre
					case 3:
						cadastro = Integer.parseInt(JOptionPane.showInputDialog("Informe o que voce deseja fazer:"
								+ "\n1- Inserir"
								+ "\n2- Atualizar"
								+ "\n3- Excluir"
								+ "\n4- Voltar"));
						
						int numero = 0;
		
						switch (cadastro) {
							case 1:
								descricao = JOptionPane.showInputDialog("Informe a descricao do semestre");
								numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero do semestre"));
								semestredao.insert(new Semestre(0, descricao, numero));
								break;
						
							case 2:
								id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do semestre" + resultSemestres));
								descricao = JOptionPane.showInputDialog("Informe a descricao do semestre");
								numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero do semestre"));
								semestredao.update(new Semestre(id, descricao, numero));
								break;
						
							case 3:
								id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do semestre" + resultSemestres));
								semestredao.delete(id);
								break;
						}
						break;
		
					//Vincular
					case 4:
						cadastro = Integer.parseInt(JOptionPane.showInputDialog("Informe o que voce deseja fazer:"
								+ "\n1- Inserir"
								+ "\n2- Atualizar"
								+ "\n3- Excluir"
								+ "\n4- Voltar"));
						
						int idcurso, iddisciplina, idsemestre;
						
						switch (cadastro) {
						case 1:
							idcurso = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do curso" + resultCursos));
							iddisciplina = Integer.parseInt(JOptionPane.showInputDialog("Informe o id da disciplina" + resultDisciplinas));
							idsemestre = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do semestre" + resultSemestres));
							vinculodao.insert(new Vinculo(0, cursodao.findById(idcurso).get(0),
									semestredao.findById(idsemestre).get(0), disciplinadao.findById(iddisciplina).get(0)));
							break;
					
						case 2:
							id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do vinculo"));
							idcurso = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do curso" + resultCursos));
							iddisciplina = Integer.parseInt(JOptionPane.showInputDialog("Informe o id da disciplina" + resultDisciplinas));
							idsemestre = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do semestre" + resultSemestres));
							vinculodao.update(new Vinculo(id, cursodao.findById(idcurso).get(0),
									semestredao.findById(idsemestre).get(0), disciplinadao.findById(iddisciplina).get(0)));
							break;
					
						case 3:
							id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do vinculo"));
							vinculodao.delete(id);
							break;
						}
						break;
		
					//Consultar Cursos
					case 5:		
						JOptionPane.showMessageDialog(null, "Cursos:" + resultCursos);
						break;
		
					//Consultar Disciplinas
					case 6:
						JOptionPane.showMessageDialog(null, "Disciplinas:" + resultDisciplinas);
						break;
		
					//Consultar Disciplinas por Semestre
					case 7:
						id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do semestre" + resultSemestres));
						resultDisciplinas = "";
						for (Disciplina disciplina : disciplinadao.findBySemestre(id)) {
							resultDisciplinas += ("\n" + disciplina);
						}
						JOptionPane.showMessageDialog(null, "Disciplinas pelo semestre: " + resultDisciplinas);
						break;
		
					//Consultar Carga Horaria por Semestre
					case 8:
						id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do semestre" + resultSemestres));
						int tipoCH = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo de carga horaria:"
								+ "\n1-CHATS"
								+ "\n2-CHTS"));
						JOptionPane.showMessageDialog(null, "Total de Carga Horaria do semestre: " + disciplinadao.findTotalBySemestre(id, tipoCH));
						break;
		
					//Consultar Carga Horaria Teorica ou Pratica
					case 9:
						tipoCH = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo de carga horaria:"
								+ "\n1-CHATS"
								+ "\n2-CHTS"));
						int tipoPresencial = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo de carga horaria presencial:"
								+ "\n1-Teorica"
								+ "\n2-Pratica"));
						JOptionPane.showMessageDialog(null, "Total de Carga Horaria: " + disciplinadao.findTotal(tipoCH, tipoPresencial));
						break;
						
					default:
						return;
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Main();
	}

	public void changeEncoding() {
		try {
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new InternalError("VM does not support mandatory encoding UTF-8");
		}
	}

}
