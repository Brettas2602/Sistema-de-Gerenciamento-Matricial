package bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Semestre")
public class Semestre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "numero")
	private int numero;
	
	
	
	public Semestre(long id, String descricao, int numero) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.numero = numero;
	}

	public Semestre(int id) {
		this.id = id;
	}
	
	public Semestre() {}
	
	
	public String toString() {
		return "ID: " + id + " | DESCRICAO: " + descricao + " | NUMERO: " + numero;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	

}