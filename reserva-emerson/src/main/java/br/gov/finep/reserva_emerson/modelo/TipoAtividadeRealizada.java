package br.gov.finep.reserva_emerson.modelo;

public enum TipoAtividadeRealizada {
    VISITA("Visita à Empresa"), TELEFONE("Contato Telefônico"), REUNIAO("Reunião");

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    private TipoAtividadeRealizada(String descricao) {
        this.descricao = descricao;
    }
}
