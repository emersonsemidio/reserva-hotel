package br.gov.finep.reserva_emerson.web;

import java.io.Serializable;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import br.gov.finep.reserva_emerson.modelo.Quarto;
import br.gov.finep.reserva_emerson.servico.ServicoQuarto;
import br.gov.finep.safeparams.SafeParams;


@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class DetalheQuartoVM implements Serializable {
	
    private static final long serialVersionUID = 1L;

	
	private Quarto quarto;
	
	@WireVariable
	private ServicoQuarto servicoQuarto;
	
	@Init
    // public void init(@ContextParam(ContextType.VIEW) Component view) { // Caso precise acessar a view
    public void init() {
        String parametros = Executions.getCurrent().getParameter(SafeParams.DEFAULT_DATA_PARAM);
        if (parametros != null) {
            Long id = new SafeParams(parametros).getLong("id");
            this.quarto = servicoQuarto.buscarQuarto(id);
        }
    }

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
}
