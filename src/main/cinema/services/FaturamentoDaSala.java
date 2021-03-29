package services;

import model.Cinema;

public class FaturamentoDaSala implements Faturamento{
	// Essa classe é responsavel por fazer operações do faturamento total da sala pelo número de cadeiras
	Cinema sala;
	public FaturamentoDaSala(Cinema sala){
		this.sala = sala;
	}

	public int calculo() {
		int faturamento = 0;
		if(sala.getF() <= 9 && sala.getC() <= 9) {
		if(sala.getF() * sala.getC() <= 60) {
			faturamento = sala.getF()*sala.getC()*10; 
		}else if(sala.getF()*sala.getC()>60) {
			if(sala.getF() % 2 == 0) {
				faturamento = ((sala.getF()/2)*sala.getC()*10) + ((sala.getF()/2)*sala.getC()*8);
			}else {
				faturamento = (((sala.getF()-1)/2)*sala.getC()*10) + (((sala.getF()+1)/2)*sala.getC()*8);
			}
		}
		}
		return faturamento;
		
	}
	
	
	
	
}


