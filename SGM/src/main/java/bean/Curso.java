package bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "descricao")
	private String descricao;
	
	

	public Curso(long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	public Curso(int id) {
		this.id = id;
	}
	
	public Curso() {}
	
	public String toString() {
		return ("ID: " + id + " | DESCRICAO: " + descricao);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
