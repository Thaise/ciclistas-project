import java.util.Scanner;


public class Ciclista {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		while(true){
			System.out.print("Distância - digite: KM (Kilômetros) ou M (Metros): ");
			String unidadeDistancia = entrada.nextLine();
			
			System.out.print("Tempo - digite: H (Horas) ou M (Minutos) ou S (Segundos): ");
			String unidadeTempo = entrada.nextLine();
			
			System.out.print("Como você deseja receber a velocidade média? MS (Metros por Segundo) ou KH (Kilômetros por Hora): ");
			String unidadeVelocidade = entrada.nextLine();
			
			System.out.print("Dê a distância em "+unidadeDistancia+" e tempo em "+unidadeTempo+": ");
			String valores = entrada.nextLine();

			try {
				double[] valores2 = interpretarValoresDeDistanciaTempo(valores);
	
				double distancia = (double) valores2[0];
				double tempo = (double) valores2[1];
				
				double[] conversoesPadrao = converterParaPadrao(unidadeDistancia, unidadeTempo, distancia, tempo);
					
				double[] unidadesConvertidas = converterDistanciasETempos(conversoesPadrao, unidadeVelocidade);
					
				System.out.println("Valocidade Média: "+calcularVelocidadeMedia(unidadesConvertidas));
					
			} catch (CiclistaException e) {
				System.out.println("A distância e/ou o tempo não podem ser zero!");
			}
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
	
	public static double[] converterParaPadrao(String unidadeDistancia,String unidadeTempo,
			double distancia, double tempo) {
		
		double conversaoPadraoD = 0;
		double conversaoPadraoT = 0;
		
		if("M".equalsIgnoreCase(unidadeDistancia)){
			conversaoPadraoD = distancia / 1000;
		}else{
			conversaoPadraoD = distancia;	
		}
		
		if("M".equalsIgnoreCase(unidadeTempo)){
			conversaoPadraoT = tempo / 60;
		}else if("S".equalsIgnoreCase(unidadeTempo)){
			conversaoPadraoT = tempo / 3600;
		}else{
			conversaoPadraoT = tempo;
		}

		double[] coversoesPadrao = new  double [2];
		
		coversoesPadrao[0] = conversaoPadraoD;
		coversoesPadrao[1] = conversaoPadraoT;
		
		return coversoesPadrao;
	}

	public static double[] converterDistanciasETempos(double[] conversoesPadrao, String unidadeVelocidade) {
		
		double conversaoPadraoD = conversoesPadrao[0];
		double conversaoPadraoT = conversoesPadrao[1];
		
		double distanciaConvertida = 0;
		double tempoConvertido = 0;
		
		if("MS".equalsIgnoreCase(unidadeVelocidade)){
			distanciaConvertida = conversaoPadraoD * 1000;
			tempoConvertido = conversaoPadraoT * 3600;
		}else{
			distanciaConvertida = conversaoPadraoD;
			tempoConvertido = conversaoPadraoT;
		}
		
		double[] unidadesConvertidas = new  double [2];
		
		unidadesConvertidas[0] = distanciaConvertida;
		unidadesConvertidas[1] = tempoConvertido;
		
		return unidadesConvertidas;
	}

	private static void validar(double[] unidadesConvertidas)throws CiclistaException {
		
		if(unidadesConvertidas[0] == 0 || unidadesConvertidas[1] == 0){
			throw new CiclistaException("A distância e/ou o tempo não podem ser zero!");
		}
		
	}

	public static double calcularVelocidadeMedia(double[] unidadesConvertidas) throws CiclistaException {
		
		validar(unidadesConvertidas);
		
		double media = (Math.round(unidadesConvertidas[0] / unidadesConvertidas[1]));

		return media;
	}
	
	

}