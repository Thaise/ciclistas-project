import java.util.Scanner;


public class Ciclista {

	public static void main(String[] args)throws CiclistaException{
		Scanner entrada = new Scanner(System.in);
		
		while(true){			
			System.out.println("Digite a distância percorrida em Km e o tempo gasto em horas:");
			String valores = entrada.nextLine();
			
			double[] valores2 = interpretarValoresDeVelocidadeTempo(valores);
			
			double distancia = (double) valores2[0];
			double tempo = (double) valores2[1];
			
			validando(distancia,tempo);
			
			calcularVelocidadeMedia(distancia,tempo);
			
			System.out.println(calcularVelocidadeMedia(distancia,tempo));
		}
	}
	
	public static double[] interpretarValoresDeVelocidadeTempo(String valores) throws CiclistaException {
		
		String[] separaValores = valores.split(" ");
		
		double distancia = Double.parseDouble(separaValores[0]);
		double tempo = Double.parseDouble(separaValores[1]);
		
		double[] valoresInterpretados = new double[2];	
		
		valoresInterpretados[0] = distancia;
		valoresInterpretados[1] = tempo;
			
		return valoresInterpretados;
	}

	private static void validando(double distancia,double tempo)throws CiclistaException {
		
		if(tempo != 0 && distancia != 0){
			calcularVelocidadeMedia(distancia,tempo);
		}else{
			throw new CiclistaException("A distância e o tempo devem ser maiores que zero!");
		}
		
	}

	public static double calcularVelocidadeMedia(double distancia,double tempo) {
		
		double media = (Math.round(distancia / tempo));
		
		return media;
	}
	
	

}
