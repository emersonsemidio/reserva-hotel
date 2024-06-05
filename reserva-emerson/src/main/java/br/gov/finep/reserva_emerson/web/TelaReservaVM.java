package br.gov.finep.reserva_emerson.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;


import br.gov.finep.reserva_emerson.modelo.Reserva;
import br.gov.finep.reserva_emerson.servico.ServicoQuarto;
import br.gov.finep.reserva_emerson.servico.ServicoReserva;
import br.gov.finep.safeparams.SafeParams;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class TelaReservaVM {

    private List<Reserva> historicoReservas = new ArrayList<Reserva>();

    private Date dataEntrada;
    private Date dataSaida;
    private Long quartoID;

    @WireVariable
    private ServicoReserva servicoReserva;

    @WireVariable
    private ServicoQuarto servicoQuarto;


    @Init
    // public void init(@ContextParam(ContextType.VIEW) Component view) { // Caso precise acessar a view
    public void init() {
        String parametros = Executions.getCurrent().getParameter(SafeParams.DEFAULT_DATA_PARAM);
        if (parametros != null) {
            quartoID = new SafeParams(parametros).getLong("id");
        }
    }

    public Long getQuartoID() {
        return quartoID;
    }

    public void setQuartoID(Long quartoID) {
        this.quartoID = quartoID;
    }


    public List<Reserva> getHistoricoReservas() {
        return historicoReservas;
    }

    public void setHistoricoReservas(List<Reserva> historicoReservas) {
        this.historicoReservas = historicoReservas;
    }


    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    @Command
    @NotifyChange("historicoReservas")
    public void adicionandoReserva() {
        servicoReserva.adicionandoReserva(servicoQuarto.buscarQuartoPorID(quartoID), dataEntrada, dataSaida);
        mostrarHistoricoReservas();
    }

    @Command
    @NotifyChange("historicoReservas")
    public void cancelarReserva() {
        servicoReserva.cancelandoReserva(servicoQuarto.buscarQuartoPorID(quartoID));
        mostrarHistoricoReservas();
    }

    @Command
    @NotifyChange("historicoReservas")
    public void mostrarHistoricoReservas() {
        this.historicoReservas.clear();
        this.historicoReservas.addAll(this.servicoReserva.mostrarHistoricoReservas(quartoID));
    }
}
