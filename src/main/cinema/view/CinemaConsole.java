package view;

import java.util.Scanner;

import cinema.controller.CinemaController;
import model.Cinema;
import services.FaturamentoDaSala;



public class CinemaConsole {

	public static void main(String[] args) {
		
		CinemaController cinemaController = new CinemaController();
		Scanner in = new Scanner(System.in);
		Cinema sala = new Cinema();
		

		int x,y,p = 0 ,z = 0, opcao =  1;
		
		
////////////////////CRIAR A SALA DE CINEMA ////////////////////////////////////////////////////////		
		System.out.print("Digite o numero de filas: " + "\n>");
		x = in.nextInt();
		
		System.out.print("Digite o numero de assentos por fila:" + "\n>");
		y = in.nextInt();
		
		if(x > 9 || y> 9) {
			System.out.print("filas e assentos por fila não podem ser maiores que 9!");
			System.exit(0);
		}
		
		System.out.println("\n" + "Cinema: ");
		sala.setF(x);
		sala.setC(y);
		
		sala.CriarAssentos();
		cinemaController.setSala(sala);
		cinemaController.imprimirCinema();
		sala.Faturamento(new FaturamentoDaSala(sala));
		
//////////////////////////////////////////////////////////////////////////////////////////////////		
	//////////////////// MENU /////////////////////	
		while(opcao != 0) {
			
			System.out.println("\n" + "1. EXIBIR ASSENTOS" +
					"\n" + "2. COMPAR INGRESSO" + 
					"\n" + "3. ESTATÍSTICA" + 
					 "\n" + "0. SAIR"+ "\n");	
		opcao = in.nextInt();
		if(opcao == 3) {
			
			
			
			System.out.println("NUMERO DE INGRESSOS VENDIDOS: " + sala.getTotaldeIngressos());
			
			System.out.print("PERCENTUAL: ");
			System.out.printf("%.2f", cinemaController.percentualDeVendas());
			System.out.print("%" + "\n");
			
			System.out.println("FATURAMENTO ATUAL: " + sala.getTotalDeVendas());
			
			
			System.out.println("FATURAMENTO TOTAL: " + sala.faturamentoDaSala());
			
				
		}
		else if(opcao == 1) {
			cinemaController.imprimirCinema();
		}
		else if(opcao == 2) {	
		System.out.print("Digite o numero da fila: " + "\n>");
		p = in.nextInt();
		
		System.out.print("Digite o numero do assento da fila:" + "\n>");
		z = in.nextInt();
		
		if(p > x || z> x) {
			System.out.print("Número do assentou ou da fila invalido!");
			System.exit(0);
		}
		
		System.out.print("Preço do ingreço:" + "\n>");
		
		
		cinemaController = new CinemaController(sala, p,z);
		System.out.println("R$" + cinemaController.valorPorAssento());
		
		cinemaController.reservarLugar();
		
		}else if(opcao == 0){
			opcao = 0;
		}
		else {
			System.out.println("Opção inválida!");
		}

		}
		in.close();

	}

}


