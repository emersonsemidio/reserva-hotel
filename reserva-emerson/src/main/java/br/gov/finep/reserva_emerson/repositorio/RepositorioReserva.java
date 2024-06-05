package br.gov.finep.reserva_emerson.repositorio;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.zkoss.zul.Messagebox;

import br.gov.finep.reserva_emerson.modelo.Reserva;

@Repository
public class RepositorioReserva {

    List<Reserva> historicoReservas = new ArrayList<Reserva>();


    public void adicionandoReserva(Long quartoID, Date dataEntrada, Date dataSaida) {

        LocalDate dataEntradaEmLocalDate = dataEntrada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dataSaidaEmLocalDate = dataSaida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Reserva reservaAtual = new Reserva(quartoID, LocalDate.now(), dataEntradaEmLocalDate, dataSaidaEmLocalDate);
        if (podeReservar(reservaAtual)) {
            historicoReservas.add(reservaAtual);
            Messagebox.show("Reserva feita com sucesso no quarto " + quartoID);
        } else {
            Messagebox.show("Quarto " + quartoID + " já está reservado neste período");
        }
    }

    public Boolean podeReservar(Reserva reservaAtual) {

        for (int i = 0; i < this.historicoReservas.size(); i++) {
            if (historicoReservas.get(i).getQuartoID() == reservaAtual.getQuartoID()) {

                if (reservaAtual.getDataEntrada().isEqual(reservaAtual.getDataSaida())) {
                    return false;
                }

                if (reservaAtual.getDataEntrada().isAfter(reservaAtual.getDataSaida())) {
                    return false;
                }

                if (reservaAtual.getDataEntrada().isEqual(historicoReservas.get(i).getDataEntrada()) || reservaAtual.getDataEntrada().isEqual(historicoReservas.get(i).getDataSaida())) {
                    return false;
                }

                if (reservaAtual.getDataSaida().isEqual(historicoReservas.get(i).getDataEntrada()) || reservaAtual.getDataSaida().isEqual(historicoReservas.get(i).getDataSaida())) {
                    return false;
                }

                if (reservaAtual.getDataEntrada().isAfter(historicoReservas.get(i).getDataEntrada()) && reservaAtual.getDataEntrada().isBefore(historicoReservas.get(i).getDataSaida())) {
                    return false;
                }

                if (reservaAtual.getDataSaida().isAfter(historicoReservas.get(i).getDataEntrada()) && reservaAtual.getDataSaida().isBefore(historicoReservas.get(i).getDataSaida())) {
                    return false;
                }
            }
        }

        return true;
    }

    public void cancelandoReserva(Long quartoID) {
        for (int i = 0; i < historicoReservas.size(); i++) {
            if (historicoReservas.get(i).getQuartoID().equals(quartoID)) {
                historicoReservas.remove(i);
                Messagebox.show("Reserva do Quarto " + quartoID + " Cancelada com sucesso");
                return;
            }
        }
    }


    public List<Reserva> getReservasQuarto(Long quartoId) {
        List<Reserva> reservasQuarto = new ArrayList<Reserva>();
        for (Reserva reserva : this.historicoReservas) {
            if (reserva.getQuartoID().equals(quartoId)) {
                reservasQuarto.add(reserva);
            }
        }

        return reservasQuarto;
    }
}
