package br.gov.finep.reserva_emerson.servico;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.finep.reserva_emerson.modelo.Reserva;
import br.gov.finep.reserva_emerson.repositorio.RepositorioReserva;

public class ServicoReserva {

    @Autowired
    RepositorioReserva repositorioReserva;

    public void adicionandoReserva(Long quartoID, Date dataEntrada, Date dataSaida) {
        this.repositorioReserva.adicionandoReserva(quartoID, dataEntrada, dataSaida);
    }

    public void cancelandoReserva(Long quartoID) {
        this.repositorioReserva.cancelandoReserva(quartoID);
    }

    public List<Reserva> mostrarHistoricoReservas(Long quartoID) {
        return this.repositorioReserva.getReservasQuarto(quartoID);
    }

}
