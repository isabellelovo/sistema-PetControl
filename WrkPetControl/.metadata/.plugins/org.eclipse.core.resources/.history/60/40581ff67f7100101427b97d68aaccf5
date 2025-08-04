package model;

import java.io.Serializable;
import java.util.Set;

public class Pet implements Serializable {
	//
	// CONSTANTES
	//
	
	//
	// ATRIBUTOS
	//
	private String codigo;
	private String nome;
	private String especie;
	private String raca;
	private int diaNasc;
	private String mesNasc;
	private int anoNasc;
	private float peso;

	private Tutor tutor;

	//
	// MÉTODOS
	//
	public Pet(String codigo, String nome, String especie,
			String raca, int diaNasc, String mesNasc, int anoNasc, float peso, Tutor tutor) throws ModelException {
		super();
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setEspecie(especie);
		this.setRaca(raca);
		this.setDiaNasc(diaNasc);
		this.setMesNasc(mesNasc);
		this.setAnoNasc(anoNasc);
		this.setPeso(peso);
		this.setTutor(tutor);
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		Pet.validarCodigo(codigo);
		this.codigo = codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		Pet.validarNome(nome);
		this.nome = nome;
	}

//	public static void validarTutor(Tutor tutor) throws ModelException {
//		if (tutor == null)
//			throw new ModelException("É obrigatório indicar quem é o Tutor do Pet.");
//	}
}
