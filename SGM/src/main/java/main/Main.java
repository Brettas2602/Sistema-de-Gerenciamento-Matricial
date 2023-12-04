package main;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

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
			
			int idCurso = 1;
			int idSemestre = 2;
			int idDisciplina = 4;
//			
//			Curso c1 = new Curso(0, "Linguagem 1");
//			cursodao.insert(c1);
//			
//			Semestre s1 = new Semestre(0, "2° Semestre", 2);
//			semestredao.insert(s1);
			
//			Disciplina d1 = new Disciplina(0 ,"d4", "d4", "d4", 7, 7, 7, 8, 8, 8);
//			disciplinadao.insert(d1);
//			
//			Vinculo v1 = new Vinculo(new Curso(idCurso), new Semestre(idSemestre), new Disciplina(idDisciplina));
//			vinculodao.insert(v1);
			
//			List<Disciplina> listaDisciplina = disciplinadao.findAll();
//			for (Disciplina list : listaDisciplina) {
//				System.out.println(list);
//			}
//			
//			List<Curso> listaContatos = cursodao.findAll();
//			for (Curso list : listaContatos) {
//				System.out.println(list);
//			}
			
			List<Disciplina> findBySemestre = disciplinadao.findBySemestre(1);
			System.out.println(findBySemestre);
//			
			System.out.println(disciplinadao.findTotal(2, 2));
			
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
