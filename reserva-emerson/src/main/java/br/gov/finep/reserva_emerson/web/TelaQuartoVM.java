package br.gov.finep.reserva_emerson.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import br.gov.finep.reserva_emerson.modelo.Quarto;
import br.gov.finep.reserva_emerson.servico.ServicoQuarto;

import br.gov.finep.safeparams.SafeParams;


@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)

public class TelaQuartoVM implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Quarto> quartos = new ArrayList<Quarto>();

    private Long id;
    private Quarto quarto;

    @WireVariable
    private ServicoQuarto servicoQuarto;

    @Init
    @NotifyChange("quartos")
    public void init() {
        this.quartos.addAll(this.servicoQuarto.listarQuartos());
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    @Command
    public void visualizar(@BindingParam("id") Long id) {
        Executions.getCurrent().sendRedirect(MenuVM.urlDetalheQuartoMVVM() + "?" + new SafeParams("id", id));
    }

    @Command
    public void realizarReserva(@BindingParam("id") Long id) {
        Executions.getCurrent().sendRedirect(MenuVM.urlTelaReservaMVVM() + "?" + new SafeParams("id", id));
    }

    @Command
    public void mostrarReservas(@BindingParam("id") Long id) {
        Executions.getCurrent().sendRedirect(MenuVM.urlTelaReservaMVVM() + "?" + new SafeParams("id", id));
    }

}
