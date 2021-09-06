package br.com.alura.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class BunusServiceTest {

	private BonusService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void inicializar() {
		service = new BonusService();
		funcionario = new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"));
	}


	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		//Primeira maneira
		assertThrows(IllegalArgumentException.class,
				() -> service.calcularBonus(funcionario));
		BigDecimal bonus = service.calcularBonus(funcionario);
		assertEquals(new BigDecimal("0.00"), bonus);
	
	}
	
	
	@Test
	void bonusDeveriaSer10PorcentoDoSalario() {
		BigDecimal bonus = service.calcularBonus(funcionario);
		assertEquals(new BigDecimal("250.00"), bonus);
	}
}
