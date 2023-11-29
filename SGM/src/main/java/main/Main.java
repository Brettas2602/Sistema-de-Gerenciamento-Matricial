package main;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import bean.Curso;
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
			Curso c1 = new Curso(0, "Linguagem de Programação");
			cursodao.insert(c1);
			
			cursodao.delete(1);
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
