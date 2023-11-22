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
}
