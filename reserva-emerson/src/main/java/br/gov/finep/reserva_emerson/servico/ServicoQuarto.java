package br.gov.finep.reserva_emerson.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.finep.reserva_emerson.repositorio.RepositorioQuarto;
import br.gov.finep.reserva_emerson.modelo.Quarto;

@Service
public class ServicoQuarto {


    @Autowired
    RepositorioQuarto repositorioQuarto = new RepositorioQuarto();


    public List<Quarto> listarQuartos() {
        return repositorioQuarto.list();
    }

    public Long buscarQuartoPorID(Long id) {
        return this.repositorioQuarto.buscarQuartoPorID(id);
    }

    public Quarto buscarQuarto(Long id) {
        return this.repositorioQuarto.buscarQuarto(id);
    }


}
