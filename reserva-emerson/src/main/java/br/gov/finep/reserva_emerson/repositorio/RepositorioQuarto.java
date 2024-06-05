package br.gov.finep.reserva_emerson.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import br.gov.finep.reserva_emerson.modelo.Quarto;

@Repository
public class RepositorioQuarto extends RepositorioBase {

    private List<Quarto> bancoDados = new ArrayList<Quarto>();

    public void criarListaHotel() {
        bancoDados = new ArrayList<Quarto>();

        Quarto q1 = new Quarto(1L, new Integer(101), new BigDecimal("150"), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis semper in metus ut pellentesque. Duis hendrerit urna quam, a tincidunt"
                + " leo blandit eget. Aliquam eu orci ultrices, egestas nunc in, placerat tortor. Nulla at est nec purus euismod condimentum. Etiam molestie consectetur urna id malesuada. Vestibulum tempor ipsum a nunc"
                + " tincidunt, sed sollicitudin nunc consequat. Quisque tristique mollis nibh sed pulvinar.", "4.7/5");

        Quarto q2 = new Quarto(2L, new Integer(102), new BigDecimal("170"), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis semper in metus ut pellentesque. Duis hendrerit urna quam, a tincidunt"
                + " leo blandit eget. Aliquam eu orci ultrices, egestas nunc in, placerat tortor. Nulla at est nec purus euismod condimentum. Etiam molestie consectetur urna id malesuada. Vestibulum tempor ipsum a nunc"
                + " tincidunt, sed sollicitudin nunc consequat. Quisque tristique mollis nibh sed pulvinar.", "4.9/5");

        Quarto q3 = new Quarto(3L, new Integer(201), new BigDecimal("110"), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis semper in metus ut pellentesque. Duis hendrerit urna quam, a tincidunt"
                + " leo blandit eget. Aliquam eu orci ultrices, egestas nunc in, placerat tortor. Nulla at est nec purus euismod condimentum. Etiam molestie consectetur urna id malesuada. Vestibulum tempor ipsum a nunc"
                + " tincidunt, sed sollicitudin nunc consequat. Quisque tristique mollis nibh sed pulvinar.", "4.6/5");

        Quarto q4 = new Quarto(4L, new Integer(202), new BigDecimal("120"), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis semper in metus ut pellentesque. Duis hendrerit urna quam, a tincidunt"
                + " leo blandit eget. Aliquam eu orci ultrices, egestas nunc in, placerat tortor. Nulla at est nec purus euismod condimentum. Etiam molestie consectetur urna id malesuada. Vestibulum tempor ipsum a nunc"
                + " tincidunt, sed sollicitudin nunc consequat. Quisque tristique mollis nibh sed pulvinar.", "4.8/5");

        Quarto q5 = new Quarto(5L, new Integer(301), new BigDecimal("100"), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis semper in metus ut pellentesque. Duis hendrerit urna quam, a tincidunt"
                + " leo blandit eget. Aliquam eu orci ultrices, egestas nunc in, placerat tortor. Nulla at est nec purus euismod condimentum. Etiam molestie consectetur urna id malesuada. Vestibulum tempor ipsum a nunc"
                + " tincidunt, sed sollicitudin nunc consequat. Quisque tristique mollis nibh sed pulvinar.", "4.5/5");

        Quarto q6 = new Quarto(6L, new Integer(302), new BigDecimal("130"), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis semper in metus ut pellentesque. Duis hendrerit urna quam, a tincidunt"
                + " leo blandit eget. Aliquam eu orci ultrices, egestas nunc in, placerat tortor. Nulla at est nec purus euismod condimentum. Etiam molestie consectetur urna id malesuada. Vestibulum tempor ipsum a nunc"
                + " tincidunt, sed sollicitudin nunc consequat. Quisque tristique mollis nibh sed pulvinar.", "5/5");

        bancoDados.add(q1);
        bancoDados.add(q2);
        bancoDados.add(q3);
        bancoDados.add(q4);
        bancoDados.add(q5);
        bancoDados.add(q6);

    }

    public List<Quarto> list() {
        if (this.bancoDados.isEmpty()) {
            this.criarListaHotel();
        }

        return this.bancoDados;

    }

    public Quarto buscarQuarto(Long id) {
        for (Quarto quarto : this.list()) {
            if (quarto.getId() == id) {
                return quarto;
            }
        }
        return null;
    }

    public Long buscarQuartoPorID(Long id) {
        for (Quarto quarto : this.list()) {
            if (quarto.getId() == id) {
                return id;
            }
        }
        return null;
    }


    /*
     * public void reservar(Long id) { for(Quarto q : this.list()) { if(q.getId() ==
     * id && q.getReservado() == false) { q.setReservado(true);
     * Messagebox.show("Quarto reservado com sucesso!"); return; } }
     * Messagebox.show("Você tentou reservar um quarto que já está reservado"); }
     * 
     * public void cancelarReserva(Long id) { for(Quarto q : this.list()) {
     * if(q.getId() == id && q.getReservado() == true) { q.setReservado(false);
     * Messagebox.show("Reserva cancelada com sucesso!"); return; } } Messagebox.
     * show("Você tentou cancelar uma reservar de um quarto que não está reservado"
     * ); }
     */

}
