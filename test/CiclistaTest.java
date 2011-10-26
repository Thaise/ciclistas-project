import static org.junit.Assert.*;

import org.junit.Test;

public class CiclistaTest {

	@Test
	public void deveInterpretarDistanciaEVelocidade() throws CiclistaException{
		String valores = "20 2";
		double[] valoresInterpretados = Ciclista.interpretarValoresDeVelocidadeTempo(valores);
		assertArrayEquals(new double[] {20,2},valoresInterpretados,0);	
	}
	
	@Test
	public void deveInterpretarDistanciaEVelocidade2() throws CiclistaException {
		String valores = "40 2.5";
		double[] valoresInterpretados = Ciclista.interpretarValoresDeVelocidadeTempo(valores);
		assertArrayEquals(new double[] {40.0, 2.5},valoresInterpretados,0);	
	}
	
	@Test
	public void deveInterpretarDistanciaEVelocidade3() throws CiclistaException {
		String valores = "30 3.6";
		double[] valoresInterpretados = Ciclista.interpretarValoresDeVelocidadeTempo(valores);
		assertArrayEquals(new double[] {30.0, 3.6},valoresInterpretados,0);	
	}
	
	
	@Test
	public void deveInterpretarDistanciaEVelocidade4() throws CiclistaException {
		String valores = "105 50";
		double[] valoresInterpretados = Ciclista.interpretarValoresDeVelocidadeTempo(valores);
		assertArrayEquals(new double[] {105, 50},valoresInterpretados,0);	
	}
	
	@Test
	public void deveInterpretarDistanciaEVelocidade5() throws CiclistaException {
		String valores = "36 5";
		double[] valoresInterpretados = Ciclista.interpretarValoresDeVelocidadeTempo(valores);
		assertArrayEquals(new double[] {36, 5},valoresInterpretados,0);	
	}
	
	@Test
	public void deveInterpretarDistanciaEVelocidade6() throws CiclistaException {
		String valores = "69 8";
		double[] valoresInterpretados = Ciclista.interpretarValoresDeVelocidadeTempo(valores);
		assertArrayEquals(new double[] {69, 8},valoresInterpretados,0);
	}
	
	@Test
	public void deveCalcularMedia1() {
		double distancia = 20;
		double tempo = 2;
		double media = Ciclista.calcularVelocidadeMedia(distancia,tempo);
		assertEquals(10,media,0);	
	}
	
	@Test
	public void deveCalcularMedia2() {
		double distancia = 40;
		double tempo = 2.5;
		double media = Ciclista.calcularVelocidadeMedia(distancia,tempo);
		assertEquals(16,media,0);	
	}
	
	@Test
	public void deveCalcularMedia3() {
		double distancia = 30;
		double tempo = 3.6;
		double media = Ciclista.calcularVelocidadeMedia(distancia,tempo);
		assertEquals(8.0,media,0);	
	}
	
	@Test
	public void deveCalcularMedia4() {
		double distancia = 100;
		double tempo = 50;
		double media = Ciclista.calcularVelocidadeMedia(distancia,tempo);
		assertEquals(2,media,0);	
	}
	
	@Test
	public void deveCalcularMedia5() {
		double distancia = 36;
		double tempo = 6;
		double media = Ciclista.calcularVelocidadeMedia(distancia,tempo);
		assertEquals(6,media,0);	
	}
	
	@Test
	public void deveCalcularMedia6() {
		double distancia = 64;
		double tempo = 8;
		double media = Ciclista.calcularVelocidadeMedia(distancia,tempo);
		assertEquals(8,media,0);	
	}
	

}
