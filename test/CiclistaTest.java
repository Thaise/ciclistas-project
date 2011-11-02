import static org.junit.Assert.*;

import org.junit.Test;

public class CiclistaTest {

	@Test
	public void deveInterpretarDistanciaEVelocidade() throws CiclistaException{
		String valores = "20 2";
		double[] valoresInterpretados = Ciclista.interpretarValoresDeDistanciaTempo(valores);
		assertArrayEquals(new double[] {20,2},valoresInterpretados,0);	
	}
	
	@Test
	public void deveInterpretarDistanciaEVelocidade2() throws CiclistaException {
		String valores = "40 2.5";
		double[] valoresInterpretados = Ciclista.interpretarValoresDeDistanciaTempo(valores);
		assertArrayEquals(new double[] {40.0, 2.5},valoresInterpretados,0);	
	}
	
	@Test
	public void deveInterpretarDistanciaEVelocidade3() throws CiclistaException {
		String valores = "30 3.6";
		double[] valoresInterpretados = Ciclista.interpretarValoresDeDistanciaTempo(valores);
		assertArrayEquals(new double[] {30.0, 3.6},valoresInterpretados,0);	
	}
	
	
	@Test
	public void deveInterpretarDistanciaEVelocidade4() throws CiclistaException {
		String valores = "105 50";
		double[] valoresInterpretados = Ciclista.interpretarValoresDeDistanciaTempo(valores);
		assertArrayEquals(new double[] {105, 50},valoresInterpretados,0);	
	}
	
	@Test
	public void deveTestarConversaoMetrosParaKMeSparaH(){
		double[] media = Ciclista.converterParaPadrao("m", "s", 3000, 3600);
		assertArrayEquals(new double[] {3, 1},media,0);	
	}
	
	@Test
	public void deveTestarConversaoMetrosParaKMeMparaH(){
		double[] media = Ciclista.converterParaPadrao("m", "m", 3000, 120);
		assertArrayEquals(new double[] {3, 2},media,0);	
	}
	
	@Test
	public void deveTestarConversaoKMparaMS(){
		double[] distETempo = {3,1};
		double[] media = Ciclista.converterDistanciasETempos(distETempo,"ms");
		assertArrayEquals(new double[] {3000, 3600},media,0);	
	}
	
	@Test
	public void deveTestarConversaoKMparaKM(){
		double[] distETempo = {3,1};
		double[] media = Ciclista.converterDistanciasETempos(distETempo, "KM");
		assertArrayEquals(new double[] {3, 1},media,0);	
	}
	
	@Test
	public void deveCalcularMedia1() throws CiclistaException {
		double[] distETempo = {20,10};
		double media = Ciclista.calcularVelocidadeMedia(distETempo);
		assertEquals(2,media,0);	
	}
	
	@Test
	public void deveCalcularMedia2() throws CiclistaException {
		double[] distETempo = {40,5};
		double media = Ciclista.calcularVelocidadeMedia(distETempo);
		assertEquals(8,media,0);	
	}
	
	@Test
	public void deveCalcularMedia3() throws CiclistaException {
		double[] distETempo = {62,3};
		double media = Ciclista.calcularVelocidadeMedia(distETempo);
		assertEquals(21,media,0);	
	}
	
	@Test
	public void deveCalcularMedia4() throws CiclistaException {
		double[] distETempo = {54,9};
		double media = Ciclista.calcularVelocidadeMedia(distETempo);
		assertEquals(6,media,0);	
	}	

}