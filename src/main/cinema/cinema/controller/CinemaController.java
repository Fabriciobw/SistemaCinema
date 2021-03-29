package cinema.controller;

import model.Cinema;

public class CinemaController {
	
	private Cinema sala;
	private int fila, coluna;
	
	
	public CinemaController(Cinema sala, int fila, int coluna) {
		this.sala = sala;
		this.fila= fila;
		this.coluna = coluna;
	}

	public CinemaController() {
		
	}
	
	

	public Cinema getSala() {
		return sala;
	}

	public void setSala(Cinema sala) {
		this.sala = sala;
	}

	public int valorPorAssento() {	
		
		int valor =0;	
			if(sala.getF() * sala.getC() <= 60) {
				valor = 10; 
			}else if(sala.getF()*sala.getC()>60) {
				if(sala.getF() % 2 == 0) {
					if(fila <= sala.getF()/2) {
					 valor = 10;
					}
					else {
						valor = 8;
						
					}
				}else {
					if(fila <= (sala.getF()-1)/2) {
					valor = 10;
					}else {		
					valor = 8;
				}
			}
				}

		return valor;
	}
	
	public void imprimirCinema() {
		
		
		for (int i = 0; i < sala.getF(); i++) {
			
			if(i==0) {
			System.out.println();
			System.out.print(" ");
			
			for(int t = 0; t< sala.getC(); t++) {
				System.out.print(" " + (t+1));
				
				if(t == sala.getC()-1) {
					System.out.println();
				}
			}
			
			}
		
			System.out.print(i+1 + " ");
			  for (int k = 0; k < sala.getC(); k++) {
				
			System.out.print(sala.getArrayBi()[i][k] + " ");
			  
			}
			  System.out.println();
		}
	}
	 
	public void reservarLugar() {
	
		
		for (int i = 0; i < sala.getF(); i++) {
			  for (int k = 0; k < sala.getC(); k++) {
				  if(fila == i+1 && coluna == k+1 ) {
				
					  if(sala.getArrayBi()[i][k].equals("S")) {
						  
					 sala.setArrayBi(i, k, "X");
					 sala.setTotalDeVendas(valorPorAssento());
					 sala.setTotaldeIngressos();
					 
					  }else {
						  System.out.println("Escolha um assento disponível!");			  
					  }
			
			    
			  }
 
		}
		
	}
}
		public double percentualDeVendas() {
		
		double percentual =  sala.getTotalDeVendas()/(sala.faturamentoDaSala());
		return percentual * 100;
	}
	


}

