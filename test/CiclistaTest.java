import static org.junit.Assert.*;

import org.junit.Test;

public class CiclistaTest {

	@Test
	public void deveInterpretarDistancia20EVelocidade2() throws CiclistaException{
		String valores = "20 2";
		double[] valoresInterpretados = Ciclista.interpretarValoresDeDistanciaTempo(valores);
		assertArrayEquals(new double[] {20,2},valoresInterpretados,0);	
	}
	
	@Test
	public void deveInterpretarDistancia40EVelocidade2() throws CiclistaException {
		String valores = "40 2";
		double[] valoresInterpretados = Ciclista.interpretarValoresDeDistanciaTempo(valores);
		assertArrayEquals(new double[] {40.0, 2},valoresInterpretados,0);	
	}
	
	@Test
	public void deveInterpretarDistancia30EVelocidade3() throws CiclistaException {
		String valores = "30 3";
		double[] valoresInterpretados = Ciclista.interpretarValoresDeDistanciaTempo(valores);
		assertArrayEquals(new double[] {30.0, 3},valoresInterpretados,0);	
	}
	
	
	@Test
	public void deveInterpretarDistancia105EVelocidade50() throws CiclistaException {
		String valores = "105 50";
		double[] valoresInterpretados = Ciclista.interpretarValoresDeDistanciaTempo(valores);
		assertArrayEquals(new double[] {105, 50},valoresInterpretados,0);	
	}
	
	@Test
	public void deveTestarConversao3000MetrosPara3KM(){
		double media = Ciclista.converterDistanciaParaPadrao(Ciclista.METROS, 3000);
		assertEquals(3 , media, 0);	
	}
	
	@Test
	public void deveTestarConversao120Minutospara2Horas(){
		double media = Ciclista.converterTempoParaPadrao(Ciclista.MINUTOS, 120);
		assertEquals(2 , media, 0);	
	}
	
	@Test
	public void deveTestarConversao3600Segundospara1Hora(){
		double media = Ciclista.converterTempoParaPadrao(Ciclista.SEGUNDOS,3600);
		assertEquals(1, media, 0);	
	}
	
	@Test
	public void deveTestarConversao3KMpara3000Metros(){
		double media = Ciclista.converterDistanciaConformeVelocidadeEscolhida(3,Ciclista.METROSPORSEGUNDO);
		assertEquals(3000, media, 0);	
	}
	
	@Test
	public void deveTestarConversao2Horaspara7200Segundos(){
		double media = Ciclista.converterTempoConformeVelocidadeEscolhida(2,Ciclista.METROSPORSEGUNDO);
		assertEquals(7200, media, 0);	
	}
	
	@Test
	public void deveCalcularVelocidadeMediaDeDistancia20ETempo10() throws CiclistaException {
		double media = Ciclista.calcularVelocidadeMedia(20, 10);
		assertEquals(2,media,0);	
	}
	
	@Test
	public void deveCalcularVelocidadeMediaDeDistancia40ETempo5() throws CiclistaException {
		double media = Ciclista.calcularVelocidadeMedia(40,5);
		assertEquals(8,media,0);	
	}
	
	@Test
	public void deveCalcularVelocidadeMediaDeDistancia10ETempo2() throws CiclistaException {
		double media = Ciclista.calcularVelocidadeMedia(10,2);
		assertEquals(5,media,0);	
	}
	
	@Test
	public void deveCalcularVelocidadeMediaDeDistancia54ETempo9() throws CiclistaException {
		double media = Ciclista.calcularVelocidadeMedia(54,9);
		assertEquals(6,media,0);	
	}	

}