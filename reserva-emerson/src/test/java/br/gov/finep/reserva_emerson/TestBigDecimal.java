package br.gov.finep.reserva_emerson;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Assert;
import org.junit.Test;

public class TestBigDecimal {
	
	
	private BigDecimal primeiroNumero = new BigDecimal("13");
	private BigDecimal segundoNumero = new BigDecimal("0.7");
	
	@Test
	public void somar() {			
		BigDecimal resultadoAdicao = primeiroNumero.add(segundoNumero);
		
		System.out.println(primeiroNumero +  " + " + segundoNumero + " = " + resultadoAdicao);
		
		Assert.assertEquals(new BigDecimal("13.7"), primeiroNumero.add(segundoNumero));
	}
	
	@Test
	public void subtrair() {	
		BigDecimal resultadoSubtracao = primeiroNumero.subtract(segundoNumero);
		
		System.out.println(primeiroNumero + " - " + segundoNumero + " = " + resultadoSubtracao);
		
		Assert.assertEquals(new BigDecimal("12.3"), primeiroNumero.subtract(segundoNumero));
	}
	

	
	@Test
	public void dividir() {	
		BigDecimal resultadoDivisao = primeiroNumero.divide(segundoNumero, 3, RoundingMode.HALF_EVEN);
		
		System.out.println(primeiroNumero + " / " + segundoNumero + " = " + resultadoDivisao);
		
		Assert.assertEquals(new BigDecimal("18.571"), primeiroNumero.divide(segundoNumero, 3, RoundingMode.HALF_EVEN));

	}
	
	@Test
	public void multiplicar() {		
		BigDecimal resultadoMultiplicacao = primeiroNumero.multiply(segundoNumero, MathContext.UNLIMITED);
		
		System.out.println(primeiroNumero + " X " + segundoNumero + " = " + resultadoMultiplicacao);
		
		Assert.assertEquals(new BigDecimal("9.1"), resultadoMultiplicacao);
	
	}
	
	@Test
	public void potenciacao() {
		BigDecimal resultadoPotenciacao = primeiroNumero.pow(2, MathContext.UNLIMITED);
		
		System.out.println("13 ^ 2" + " = " + resultadoPotenciacao);
		
		Assert.assertEquals(new BigDecimal("169"), resultadoPotenciacao);
	}	
}
