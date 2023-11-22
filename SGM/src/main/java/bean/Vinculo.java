package bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vinculo")
public class Vinculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "idcurso")
	private Curso idcurso;
	
	@Column(name = "idsemestre")
	private Semestre idsemestre;

	@Column(name = "iddisciplina")
	private Disciplina iddisciplina;
}
