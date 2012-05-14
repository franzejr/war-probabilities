package probabilidades;

public class Combate {
	Prob prob = new Prob();
	double probAtk[];
	public double sobreviveAtk[], sobreviveDef[];
	int atk, def;
	
	public Combate(int atk, int def){
		//this.atk = atk;
		//this.def = def;
		sobreviveAtk = new double[atk+1];//inicia zerada
		sobreviveDef = new double[def+1];//inicia zerada
		calculaCombate(atk,def,1);
		
		//imprime os dados
		/*
		for (int i = 1; i < sobreviveAtk.length; i++)
			System.out.println(sobreviveAtk[i]);
		for (int i = 1; i < sobreviveDef.length; i++)
			System.out.println(sobreviveDef[i]);
		double s=0;
		for (int i = 1; i < sobreviveAtk.length; i++)
			s+=sobreviveAtk[i];
		for (int i = 1; i < sobreviveDef.length; i++)
			s+=sobreviveDef[i];
		System.out.println("Soma eh " + s);
		*/
		//prob.imprimeProbabilidades();
	}
	
	public void calculaProbDoProxCombate(int atk, int def){
		probAtk = new double[Math.min(4, 1+ Math.min(atk, def))];
		for (int i = 0; i < probAtk.length; i++)
			probAtk[i] = prob.probabilidade(atk, def, i);
	}
	
	public void calculaCombate(int atk, int def, double peso){
		if(atk == 0) {
			sobreviveAtk[0] += peso;
			sobreviveDef[def] += peso;
			return;
		}
		if(def == 0) {
			sobreviveDef[0] += peso;
			sobreviveAtk[atk] += peso;
			return;
		}
		calculaProbDoProxCombate(atk, def);
		double p[] = new double[probAtk.length]; //como probAtk vai ser alterado, p é quem guarda
		for (int i = 0; i < p.length; i++) 
			p[i] = probAtk[i];
		for (int i = 0; i < p.length; i++)
			calculaCombate(atk-(p.length-1)+i,def-i,peso*p[i]);
	}
	
	public void calculaEsperanca(){ //se baseia no vetor "casos"
		
	}
}
