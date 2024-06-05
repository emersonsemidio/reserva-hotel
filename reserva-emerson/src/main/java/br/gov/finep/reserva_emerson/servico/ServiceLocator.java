package br.gov.finep.reserva_emerson.servico;

public class ServiceLocator {

    // Declare os serviços conforme o modelo abaixo
    private static ServicoQuarto servicoQuarto;
    private static ServicoReserva servicoReserva;
    
	public static ServicoQuarto getServicoQuarto() {
		return servicoQuarto;
	}

	public static void setServicoQuarto(ServicoQuarto servicoQuarto) {
		ServiceLocator.servicoQuarto = servicoQuarto;
	}

	public static ServicoReserva getServicoReserva() {
		return servicoReserva;
	}

	public static void setServicoReserva(ServicoReserva servicoReserva) {
		ServiceLocator.servicoReserva = servicoReserva;
	}
  
}
