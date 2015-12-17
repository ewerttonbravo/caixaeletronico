package caixaeletronico;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class CaixaTest extends TestCase {

	private CaixaEletronico caixa;
	
	private int[] VALUES = new int[] { 100, 50, 20, 10 ,5 };
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		caixa = new CaixaEletronico();
	}

	@Test
	public void test_sacando_valores_das_notas() {
		for (int value : VALUES) {
			assertEquals(String.valueOf(value) + " ", caixa.saque(value));
		}
	}
	
	@Test
	public void test_sancando_120_reais() {
		assertEquals("100 20 ", caixa.saque(120));
	}
	
	@Test
	public void test_sancando_uma_nota_de_cada_valor_185_reais() {
		assertEquals("100 50 20 10 5 ", caixa.saque(185));
	}
	
	@Test
	public void test_quanto_valor_nao_se_aplica() {
		assertEquals("VALOR NAO DISPONIVEL PARA SAQUE", caixa.saque(381));
	}
	
	@Test
	public void test_sancando_55_reais() {
		assertEquals("50 5 ", caixa.saque(55));
	}
	
	@Test
	public void test_sancando_500_reais() {
		assertEquals("100 100 100 100 100 ", caixa.saque(500));
	}
}
