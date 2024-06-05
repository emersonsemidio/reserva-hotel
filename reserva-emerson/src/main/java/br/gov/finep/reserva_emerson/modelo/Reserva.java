package br.gov.finep.reserva_emerson.modelo;

import java.io.Serializable;
import java.time.LocalDate;


public class Reserva implements Serializable {
	public static final long serialVersionUID = 1L;

	Long quartoID;
	LocalDate dataReserva;
	LocalDate dataEntrada;
	LocalDate dataSaida;
	
	public Reserva() {
		
	}

	public Reserva(Long quartoID, LocalDate dataReserva, LocalDate dataEntrada, LocalDate dataSaida) {
		super();
		this.quartoID = quartoID;
		this.dataReserva = dataReserva;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}
	

	public Long getQuartoID() {
		return quartoID;
	}

	public void setQuartoID(Long quartoID) {
		this.quartoID = quartoID;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	
}


