import java.util.Scanner;


public class Ciclista {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		while(true){
			System.out.print("Digite a DISTÂNCIA percorrida em KM e o TEMPO gasto em HORAS separados por um espaço:");
			String valores = entrada.nextLine();	
			
			try {
				double[] valores2 = interpretarValoresDeVelocidadeTempo(valores);

				double distancia = (double) valores2[0];
				double tempo = (double) valores2[1];
				
				System.out.println("Valocidade Média:"+calcularVelocidadeMedia(distancia,tempo));
			
			} catch (CiclistaException e) {
				System.out.println("A distância e/ou a velocidade não podem ser zero!");
			}
		}
	}
	
	public static double[] interpretarValoresDeVelocidadeTempo(String valores){
		
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

	private static void validar(double distancia,double tempo)throws CiclistaException {

		if(tempo == 0 || distancia == 0){
			throw new CiclistaException("A distância e o tempo devem ser maiores que zero!");
		}
		
	}

	public static double calcularVelocidadeMedia(double distancia,double tempo) throws CiclistaException {
		
		validar(distancia, tempo);
		
		double media = (Math.round(distancia / tempo));
		
		return media;
	}
	
	

}
