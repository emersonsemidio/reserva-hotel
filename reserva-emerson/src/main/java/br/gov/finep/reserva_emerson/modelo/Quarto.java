package br.gov.finep.reserva_emerson.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Quarto implements Serializable {
	public static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer numeroQuarto;
	private BigDecimal valorReserva;
	private String descricao;
	private String avaliacao;
	
	
	public Quarto() {
		
	}
	
	public Quarto(Long id, Integer numeroQuarto, BigDecimal valorReserva, String descricao, String avaliacao) {
		super();
		this.id = id;
		this.numeroQuarto = numeroQuarto;
		this.valorReserva = valorReserva;
		this.descricao = descricao;
		this.avaliacao = avaliacao;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public BigDecimal getValorReserva() {
		return valorReserva;
	}


	public void setValorReserva(BigDecimal valorReserva) {
		this.valorReserva = valorReserva;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
