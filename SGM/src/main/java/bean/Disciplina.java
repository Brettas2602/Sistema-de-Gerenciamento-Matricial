package bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "nucleo")
	private String nucleo;

	@Column(name = "chats_pratica")
	private float chats_pratica;

	@Column(name = "chats_teorica")
	private float chats_teorica;

	@Column(name = "chats_distancia")
	private float chats_distancia;

	@Column(name = "chts_pratica")
	private float chts_pratica;

	@Column(name = "chts_teorica")
	private float chts_teorica;

	@Column(name = "chts_distancia")
	private float chts_distancia;
	
	

	public Disciplina(String codigo, String nome, String nucleo, float chats_pratica, float chats_teorica,
			float chats_distancia, float chts_pratica, float chts_teorica, float chts_distancia) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.nucleo = nucleo;
		this.chats_pratica = chats_pratica;
		this.chats_teorica = chats_teorica;
		this.chats_distancia = chats_distancia;
		this.chts_pratica = chts_pratica;
		this.chts_teorica = chts_teorica;
		this.chts_distancia = chts_distancia;
	}
	
	public Disciplina(int id) {
		this.id = id;
	}
	
	public Disciplina() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNucleo() {
		return nucleo;
	}

	public void setNucleo(String nucleo) {
		this.nucleo = nucleo;
	}

	public float getChats_pratica() {
		return chats_pratica;
	}

	public void setChats_pratica(float chats_pratica) {
		this.chats_pratica = chats_pratica;
	}

	public float getChats_teorica() {
		return chats_teorica;
	}

	public void setChats_teorica(float chats_teorica) {
		this.chats_teorica = chats_teorica;
	}

	public float getChats_distancia() {
		return chats_distancia;
	}

	public void setChats_distancia(float chats_distancia) {
		this.chats_distancia = chats_distancia;
	}

	public float getChts_pratica() {
		return chts_pratica;
	}

	public void setChts_pratica(float chts_pratica) {
		this.chts_pratica = chts_pratica;
	}

	public float getChts_teorica() {
		return chts_teorica;
	}

	public void setChts_teorica(float chts_teorica) {
		this.chts_teorica = chts_teorica;
	}

	public float getChts_distancia() {
		return chts_distancia;
	}

	public void setChts_distancia(float chts_distancia) {
		this.chts_distancia = chts_distancia;
	}
	
	
}
