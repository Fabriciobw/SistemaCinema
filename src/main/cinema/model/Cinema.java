package model;

import services.Faturamento;

public class Cinema {
	
	
	
	private int f,c;
	
	private String[][] arrayBi;
	
	private Faturamento ft;
	private	double totalDeVendas;
	private double totaldeIngressos;
	
	

	public Cinema() {
		
		 
	   }
	
		public Cinema(int f, int c) {
		this.f = f;
		this.c = c;
	   }
		
		
		public void Faturamento(Faturamento x) {	
			ft = x;	
		}
		
		
		public double getTotaldeIngressos() {
			return totaldeIngressos;
		}

		public void setTotaldeIngressos() {
			this.totaldeIngressos++;
		}
		

		
		public double getTotalDeVendas() {
			return totalDeVendas;
		}

		public void setTotalDeVendas(int totalDeVendas) {
			this.totalDeVendas += totalDeVendas;
		}

		public String[][] getArrayBi() {
			return arrayBi;
		}

		public void setArrayBi(int i, int k, String valor) {
			arrayBi[i][k] = valor;
		}

		public int getF() {
			return f;
		}




		public void setF(int f) {
			this.f = f;
		}

		public int getC() {
			return c;
		}

		public void setC(int c) {
			this.c = c;
		}
		

	public void CriarAssentos() {
		
		arrayBi = new String [f][c];
		for (int i = 0; i < f; i++) {
			  for (int k = 0; k < c; k++) {
				  
					  arrayBi[i][k] = "S";
				  }
			    
			  }
	}
	
	
	public int faturamentoDaSala() {
		return ft.calculo();
	}
	
		
}

