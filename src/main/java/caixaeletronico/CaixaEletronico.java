package caixaeletronico;

public class CaixaEletronico {
	
	private static final int[] NOTAS = new int[] { 100, 50, 20, 10, 5 };
	private static final Integer FIRST = 0;
	private StringBuilder output;
	
	public String saque(Integer value) {
		output = new StringBuilder();
		return calculaMenorQuantidadeDeNotas(value, FIRST);
	}

	private String calculaMenorQuantidadeDeNotas(Integer value, Integer index) {
		if (value == NOTAS[index])
			return this.output.append(String.format("%d ", NOTAS[index])).toString();
		if (value > NOTAS[index]) {
			this.output.append(String.format("%d ", NOTAS[index]));
			return calculaMenorQuantidadeDeNotas(value - NOTAS[index], index);
		} 
		if (index < (NOTAS.length - 1))
			return calculaMenorQuantidadeDeNotas(value, ++index);
		else
			return "VALOR NAO DISPONIVEL PARA SAQUE";
	}
}
