package bean;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vinculo")
public class Vinculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idcurso")
	private Curso idcurso;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idsemestre")
	private Semestre idsemestre;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "iddisciplina")
	private Disciplina iddisciplina;
	
	

	public Vinculo(long id, Curso idcurso, Semestre idsemestre, Disciplina iddisciplina) {
		super();
		this.id = id;
		this.idcurso = idcurso;
		this.idsemestre = idsemestre;
		this.iddisciplina = iddisciplina;
	}
	
	public Vinculo() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Curso getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Curso idcurso) {
		this.idcurso = idcurso;
	}

	public Semestre getIdsemestre() {
		return idsemestre;
	}

	public void setIdsemestre(Semestre idsemestre) {
		this.idsemestre = idsemestre;
	}

	public Disciplina getIddisciplina() {
		return iddisciplina;
	}

	public void setIddisciplina(Disciplina iddisciplina) {
		this.iddisciplina = iddisciplina;
	}
	
	
}
