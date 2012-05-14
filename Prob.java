package probabilidades;

import java.util.Arrays;


public class Prob {
	//x33[0] = atk destroi 0 exercitos;
	//x33[1] = atk destroi 1 exercito;
	//x33[2] = atk destroi 2 exercitos;
	//x33[3] = atk destroi 3 exercitos;
	public double x11[] = new double[2];
	public double x12[] = new double[2];
	public double x13[] = new double[2];
	public double x21[] = new double[2];
	public double x22[] = new double[3];
	public double x23[] = new double[3];
	public double x31[] = new double[2];
	public double x32[] = new double[3];
	public double x33[] = new double[4];
	
	
	int DA[] = new int[3];
	int DD[] = new int[3];
	Integer da[] = new Integer[3];
	Integer dd[] = new Integer[3];

	public Prob(){
		for (int i = 0; i < da.length; i++) {
			da[i] = new Integer(0);
			dd[i] = new Integer(0);
		}
		calculax11();
		calculax12();
		calculax13();
		calculax21();
		calculax22();
		calculax23();
		calculax31();
		calculax32();
		calculax33();
	}
	
	public double probabilidade(int atk, int def, int qtd){
		if(atk==0 || def == 0)
			System.out.println("FFFFFFFFFUUUUUUUUUUUUU prob.java probabilidade atk ou def ==0");
		if(atk>3)
			atk = 3;
		if(def>3)
			def = 3;
		if(atk==3){
			if(def==3)
				return x33[qtd];
			if(def==2)
				return x32[qtd];
			return x31[qtd];
		}
		if(atk==2){
			if(def==3)
				return x23[qtd];
			if(def==2)
				return x22[qtd];
			return x21[qtd];
		}
		if(def==3)
			return x13[qtd];
		if(def==2)
			return x12[qtd];
		return x11[qtd];
	}
	
	void ordena(int atk, int def){
		for(int i=0; i!=3; i++)
			da[i] = dd[i] = 0;
		for(int i=0; i!=atk; i++)
			da[i] = DA[i];
		for(int i=0; i!=def; i++)
			dd[i] = DD[i];
		
		Arrays.sort(da, new Comparador());
		Arrays.sort(dd, new Comparador());
		if(da[0] > 6 || dd[0] > 6)
			System.out.println("FFFFUUUUUUUUU prob.java ordena");
	}

	void calculax11(){
		double VA=0, VD=0;
		for(DA[0]=1; DA[0]!=7; DA[0]++)
			for(DD[0]=1; DD[0]!=7; DD[0]++)
				if(DA[0] > DD[0])
					VA++;
				else
					VD++;
		x11[0] = VD/(VA+VD);
		x11[1] = VA/(VA+VD);
	}

	void calculax12(){
		double VA=0, VD=0;
		for(DA[0]=1; DA[0]!=7; DA[0]++)
			for(DD[0]=1; DD[0]!=7; DD[0]++)
				for(DD[1]=1; DD[1]!=7; DD[1]++){
					ordena(1,2);
					if(da[0] > dd[0])
						VA++;
					else
						VD++;
				}
		x12[0] = VD/(VA+VD);
		x12[1] = VA/(VA+VD);
	}

	void calculax13(){
		double VA=0, VD=0;
		for(DA[0]=1; DA[0]!=7; DA[0]++)
			for(DD[0]=1; DD[0]!=7; DD[0]++)
				for(DD[1]=1; DD[1]!=7; DD[1]++)
					for(DD[2]=1; DD[2]!=7; DD[2]++){
						ordena(1,3);
						if(da[0] > dd[0])
							VA++;
						else
							VD++;
					}
		x13[0] = VD/(VA+VD);
		x13[1] = VA/(VA+VD);
	}

	void calculax21(){
		double VA=0, VD=0;
		for(DA[0]=1; DA[0]!=7; DA[0]++)
			for(DD[0]=1; DD[0]!=7; DD[0]++)
				for(DA[1]=1; DA[1]!=7; DA[1]++){
						ordena(2,1);
						if(da[0] > dd[0])
							VA++;
						else
							VD++;
					}
		x21[0] = VD/(VA+VD);
		x21[1] = VA/(VA+VD);
	}

	void calculax22(){
		double VA=0, VD=0, E=0;
		for(DA[0]=1; DA[0]!=7; DA[0]++)
			for(DD[0]=1; DD[0]!=7; DD[0]++)
				for(DA[1]=1; DA[1]!=7; DA[1]++)
					for(DD[1]=1; DD[1]!=7; DD[1]++){
						ordena(2,2);
						if(da[0] > dd[0] && da[1] > dd[1])
							VA++;
						else if(da[0] > dd[0] || da[1] > dd[1])
							E++;
						else
							VD++;
					}
		x22[0] = VD/(VA+VD+E);
		x22[1] = E/(VA+VD+E);
		x22[2] = VA/(VA+VD+E);
	}

	void calculax23(){
		double VA=0, VD=0, E=0;
		for(DA[0]=1; DA[0]!=7; DA[0]++)
			for(DD[0]=1; DD[0]!=7; DD[0]++)
				for(DA[1]=1; DA[1]!=7; DA[1]++)
					for(DD[1]=1; DD[1]!=7; DD[1]++)
						for(DD[2]=1; DD[2]!=7; DD[2]++){
							ordena(2,3);
							if(da[0] > dd[0] && da[1] > dd[1])
								VA++;
							else if(da[0] > dd[0] || da[1] > dd[1])
								E++;
							else
								VD++;
						}
		x23[0] = VD/(VA+VD+E);
		x23[1] = E/(VA+VD+E);
		x23[2] = VA/(VA+VD+E);
	}

	void calculax31(){
		double VA=0, VD=0;
		for(DA[0]=1; DA[0]!=7; DA[0]++)
			for(DD[0]=1; DD[0]!=7; DD[0]++)
				for(DA[1]=1; DA[1]!=7; DA[1]++)
					for(DA[2]=1; DA[2]!=7; DA[2]++){
						ordena(3,1);
						if(da[0] > dd[0])
							VA++;
						else
							VD++;
					}
		x31[0] = VD/(VA+VD);
		x31[1] = VA/(VA+VD);
	}

	void calculax32(){ //verificar dados
		double VA=0, VD=0, E=0;
		for(DA[0]=1; DA[0]!=7; DA[0]++)
			for(DD[0]=1; DD[0]!=7; DD[0]++)
				for(DA[1]=1; DA[1]!=7; DA[1]++)
					for(DD[1]=1; DD[1]!=7; DD[1]++)
						for(DA[2]=1; DA[2]!=7; DA[2]++){
							ordena(3,2);
							if(da[0] > dd[0] && da[1] > dd[1])
								VA++;
							else if(da[0] > dd[0] || da[1] > dd[1])
								E++;
							else
								VD++;
						}
		x32[0] = VD/(VA+VD+E);
		x32[1] = E/(VA+VD+E);
		x32[2] = VA/(VA+VD+E);
	}

	void calculax33(){
		double A3=0, A2=0, A1=0, A0=0;
		int counter;
		for(DA[0]=1; DA[0]!=7; DA[0]++)
			for(DD[0]=1; DD[0]!=7; DD[0]++)
				for(DA[1]=1; DA[1]!=7; DA[1]++)
					for(DD[1]=1; DD[1]!=7; DD[1]++)
						for(DA[2]=1; DA[2]!=7; DA[2]++)
							for(DD[2]=1; DD[2]!=7; DD[2]++){
								ordena(3,3);
								counter = 0;
								for(int i=0; i!=3; i++)
									if(da[i]>dd[i])
										counter++;
								if(counter==0)
									A0++;
								else if(counter==1)
									A1++;
								else if(counter==2)
									A2++;
								else
									A3++;
							}

		x33[0] = A0/(A0+A1+A2+A3);
		x33[1] = A1/(A0+A1+A2+A3);
		x33[2] = A2/(A0+A1+A2+A3);
		x33[3] = A3/(A0+A1+A2+A3);
	}
	public void imprimeProbabilidades(){
		System.out.println("Probabilidade de ganhar no 1x1: " + x11[1]*100 + "%");
		System.out.println("Probabilidade de ganhar no 1x2: " + x12[1]*100 + "%");
		System.out.println("Probabilidade de ganhar no 1x3: " + x13[1]*100 +"%");
		System.out.println("Probabilidade de ganhar no 2x1: " + x21[1]*100 +"%");
		System.out.println("Probabilidade de PERDER no 2x2: " + x22[0]*100 +"%");
		System.out.println("Probabilidade de ganhar 1 no 2x2: " + x22[1]*100 +"%");
		System.out.println("Probabilidade de ganhar 2 no 2x2: " + x22[2]*100 +"%");
		System.out.println("Probabilidade de PERDER no 2x3: " + x23[0]*100 +"%");
		System.out.println("Probabilidade de ganhar 1 no 2x3: " + x23[1]*100 +"%");
		System.out.println("Probabilidade de ganhar 2 no 2x3: " + x23[2]*100 +"%");
		System.out.println("Probabilidade de ganhar no 3x1: " + x31[1]*100 +"%");
		System.out.println("Probabilidade de PERDER no 3x2: " + x32[0]*100 +"%");
		System.out.println("Probabilidade de ganhar 1 no 3x2: " + x32[1]*100 +"%");
		System.out.println("Probabilidade de ganhar 2 no 3x2: " + x32[2]*100 +"%");
		System.out.println("Probabilidade de PERDER no 3x3: " + x33[0]*100 +"%");
		System.out.println("Probabilidade de ganhar 1 no 3x3: " + x33[1]*100 +"%");
		System.out.println("Probabilidade de ganhar 2 no 3x3: " + x33[2]*100 +"%");
		System.out.println("Probabilidade de ganhar 3 no 3x3: " + x33[3]*100 +"%");
	}
}
