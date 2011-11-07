import java.util.Scanner;

public class Ciclista {
	//criação de contantes para melhor compreensão do código
	public static final String KILOMETROS = "km";
	public final static String METROS = "m";
	public static final String HORAS = "h";
	public static final String MINUTOS = "m";
	public static final String SEGUNDOS = "s";
	public static final String METROSPORSEGUNDO = "ms";
	public static final String KILOMETROSPORHORA = "kh";

	public static void main(String[] args) throws CiclistaException {
		Scanner entrada = new Scanner(System.in);
		
		while(true){
			System.out.print("Distância - Prefere qual unidade? Kilômetros(digite KM) ou Metros (digite M): ");
			String unidadeDistancia = entrada.nextLine();
			validarUnidadeDistancia(unidadeDistancia);
			System.out.print("Tempo - Prefere qual unidade? Horas(digite H), Minutos(digite M) ou Segundos(digite S): ");
			String unidadeTempo = entrada.nextLine();
			validarUnidadeTempo(unidadeTempo);
			System.out.print("Como você deseja receber a velocidade média? Metros por Segundo(digite MS) ou Kilômetros por Hora(digite KH): ");
			String unidadeVelocidade = entrada.nextLine();
			validarUnidadeVelocidade(unidadeVelocidade);			
			System.out.print("Dê a distância em "+unidadeDistancia+" e tempo em "+unidadeTempo+": ");
			String valores = entrada.nextLine();
			try {
				double[] valores2 = interpretarValoresDeDistanciaTempo(valores);
				double distancia = (double) valores2[0];
				double tempo = (double) valores2[1];	
				
				double distanciaPadrao = converterDistanciaParaPadrao(unidadeDistancia, distancia);		
				double tempoPadrao = converterTempoParaPadrao (unidadeTempo,tempo);		
				double distanciaConvertida = converterDistanciaConformeVelocidadeEscolhida(distanciaPadrao, unidadeVelocidade);		
				double tempoConvertido = converterTempoConformeVelocidadeEscolhida(tempoPadrao, unidadeVelocidade);

				System.out.println("Valocidade Média: "+calcularVelocidadeMedia(distanciaConvertida, tempoConvertido));			
			}catch (CiclistaException e) {
				System.out.println("A distância e/ou o tempo não podem ser zero!");
			}	 
		}
	}
	
	private static void validarUnidadeDistancia(String unidadeDistancia) throws CiclistaException {
		if((KILOMETROS.equalsIgnoreCase(unidadeDistancia)|| METROS.equalsIgnoreCase(unidadeDistancia)) == false){
			throw new CiclistaException("A unidade de distância inválida!");
		}
	}
	
	private static void validarUnidadeTempo(String unidadeTempo) throws CiclistaException {
		if((HORAS.equalsIgnoreCase(unidadeTempo)|| MINUTOS.equalsIgnoreCase(unidadeTempo)|| SEGUNDOS.equalsIgnoreCase(unidadeTempo)) == false){		
			throw new CiclistaException("A unidade de tempo inválida!");		
		}	
	}

	private static void validarUnidadeVelocidade(String unidadeVelocidade) throws CiclistaException {
		if((METROSPORSEGUNDO.equalsIgnoreCase(unidadeVelocidade) || KILOMETROSPORHORA.equalsIgnoreCase(unidadeVelocidade)) == false){		
			throw new CiclistaException("A unidade de velocidade inválida!");	
		}
	}

	public static double[] interpretarValoresDeDistanciaTempo(String valores){	
		String[] separaValores = valores.split(" ");
			
		if(separaValores.length < 2){
			System.out.println("A DISTÂNCIA e o TEMPO devem ser fornecidos!");
		}		
		double distancia = Double.parseDouble(separaValores[0]);
		double tempo = Double.parseDouble(separaValores[1]);
		
		double[] valoresInterpretados = new double[2];	
		valoresInterpretados[0] = distancia;
		valoresInterpretados[1] = tempo;
			
		return valoresInterpretados;
	}
	
	public static double converterDistanciaParaPadrao(String unidadeDistancia, double distancia) {	
		double conversaoPadraoD = 0;
		
		if(METROS.equalsIgnoreCase(unidadeDistancia)){
			conversaoPadraoD = distancia / 1000;
		}else{
			conversaoPadraoD = distancia;	
		}
		return conversaoPadraoD;
	}
	
	public static double converterTempoParaPadrao(String unidadeTempo, double tempo) {
		double conversaoPadraoT = 0;
		
		if(MINUTOS.equalsIgnoreCase(unidadeTempo)){
			conversaoPadraoT = tempo / 60;
		}else if(SEGUNDOS.equalsIgnoreCase(unidadeTempo)){
			conversaoPadraoT = tempo / 3600;
		}else{
			conversaoPadraoT = tempo;
		}		
		return conversaoPadraoT;
	}

	public static double converterDistanciaConformeVelocidadeEscolhida(double distanciaPadrao, String unidadeVelocidade) {
		double distanciaConvertida = 0;
		
		if(METROSPORSEGUNDO.equalsIgnoreCase(unidadeVelocidade)){
			distanciaConvertida = distanciaPadrao * 1000;
		}else{
			distanciaConvertida = distanciaPadrao;
		}
		return distanciaConvertida;
	}
	
	public static double converterTempoConformeVelocidadeEscolhida(double tempoPadrao, String unidadeVelocidade) {
		double tempoConvertido = 0;
		
		if(METROSPORSEGUNDO.equalsIgnoreCase(unidadeVelocidade)){
			tempoConvertido = tempoPadrao * 3600;
		}else{
			tempoConvertido = tempoPadrao;
		}	
		return tempoConvertido;
	}

	public static double calcularVelocidadeMedia(double distanciaConvertida, double tempoConvertido) throws CiclistaException {
		validar(distanciaConvertida, tempoConvertido);
		return  distanciaConvertida / tempoConvertido;
	}
	
	private static void validar(double distanciaConvertida, double tempoConvertido)throws CiclistaException {
		if(distanciaConvertida == 0 || tempoConvertido == 0){
			throw new CiclistaException("A distância e/ou o tempo não podem ser zero!");
		}
	}
}