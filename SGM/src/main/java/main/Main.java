package main;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

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
			
			int idCurso = 4;
			int idSemestre = 1;
			int idDisciplina = 1;
			
//			Curso c1 = new Curso("Linguagem de Programação");
//			cursodao.insert(c1);
//			
//			Semestre s1 = new Semestre("teste", 1);
//			semestredao.insert(s1);
//			
//			Disciplina d1 = new Disciplina("teste", "teste", "teste", 0, 0, 0, 0, 0, 0);
//			disciplinadao.insert(d1);
			
			Vinculo v1 = new Vinculo(new Curso(idCurso), new Semestre(idSemestre), new Disciplina(idDisciplina));
			vinculodao.insert(v1);
			JOptionPane.showMessageDialog(null, v1.toString());
			
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
