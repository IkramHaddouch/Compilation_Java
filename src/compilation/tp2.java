package compilation;

import java.util.ArrayList;
import java.util.Scanner;

public class tp2 {
	public String[][] exercice2(){
		System.out.println("Entrez le nombre d'etats : ");
		Scanner sc = new Scanner(System.in);
		int nbEtat = sc.nextInt();
		System.out.println("Entrez le nombre des symboles : ");
		int nbSymb = sc.nextInt();
		System.out.println("Entrez le nombre des etats finaux : ");
		int nbEtatFin = sc.nextInt();
		
		System.out.println("Entrez le nombre des etats initiaux : ");
		int nbEtatI = sc.nextInt();
		String TSI[] = new String [nbEtatI];
		
		String TS[] = new String [nbEtat];
		System.out.println("Entrez tous les etats : ");
		for(int i = 0;i<nbEtat;i++)
		{
			sc.nextLine();
			System.out.print("-");
			TS[i] = sc.nextLine();
		}
		ArrayList<String> TSF = new ArrayList<>();
		System.out.println("Entrez les symboles des etats finaux : ");
		for(int i = 0;i<nbEtatFin;i++)
		{
			sc.nextLine();
			System.out.print("-");
			TSF.add(sc.nextLine());
		}
		String Ts[] = new String [nbSymb];
		System.out.println("Entrez les symboles de langage : ");
		for(int i = 0;i<nbSymb;i++)
		{
			sc.nextLine();
			System.out.print("-");
			Ts[i] = sc.nextLine();
		}
		System.out.println("Entrez les etats initiaux : ");
		for(int i = 0;i<nbEtatI;i++)
		{
			sc.nextLine();
			System.out.print("-");
			TSI[i] = sc.nextLine();
		}
		
		String TTS[][] = new String [nbEtat+1][nbSymb+2];
		System.out.println("Entrez les transitions : ");
		for(int i=1;i<=nbEtat;i++) {
			TTS[i][0]=TS[i-1];
		}
		
		for(int i=1;i<=nbSymb;i++) {
			TTS[0][i]=Ts[i-1];
		}
		for(int j = 1; j<=nbEtat;j++)
		{
			for(int i = 1; i<=nbSymb;i++)
			{
				System.out.println("Entrez tous les transitions de l'etat "+TS[j-1]+" en consommant le symbole "+Ts[i-1]);
				System.out.println("transition ( "+ TS[j-1]+" , " + Ts[i-1]+" ) = ");
				TTS[j][i] = sc.nextLine();
			
			}
		}
		
		System.out.println("Entrez les transitions avec epsillon: ");
		for(int j = 0; j<nbEtat;j++)
		{
				System.out.println("transition Tr["+ j +"]= ");
				TTS[j][nbSymb+1] = sc.nextLine();
		}
		System.out.println("*******************************Tableau des transitions****************************************");
		for(int j = 1; j<nbEtat+1;j++)
		{
			for(int i = 1; i<nbSymb+2;i++)
			{
			System.out.println("transition  = " + TTS[j][i]);
			}
	    }
	
		
		return TTS;
	}
	
	public String trans_Etat_Symb(String e,String s,String[][] TTS) {
		
		int etat=-1;
		int index=-1;
		for(int i = 1; i<TTS.length; i++) {
			if(e.equals(TTS[i][0])) {
				etat=i;
			}
		}
		for(int i = 1; i<TTS[0].length; i++) {
			if(s.equals(TTS[0][i])) {
			    index=i;
			}
		}
		if(index==-1 || etat==-1) {
			System.out.println("l'etat ou le symbole n'existe pas");
		}
		return TTS[etat][index];
	}
	public String[][] ajout_Tansv(String[][] TTS) {
		String e,s;
		Scanner sc = new Scanner(System.in);
		System.out.println("*************Ajouter*****************");
		System.out.println("donner l'etat : \n");
		e=sc.nextLine();
		System.out.println("donner le symbole : \n");
		s=sc.nextLine();
		int etat=-1;
		int index=-1;
		for(int i = 1; i<TTS.length; i++) {
			if(e.equals(TTS[i][0])) {
				etat=i;
			}
		}
		for(int i = 1; i<TTS[0].length; i++) {
			if(s.equals(TTS[0][i])) {
			    index=i;
			}
		}
		if(index==-1 || etat==-1) {
			System.out.println("l'etat ou le symbole n'existe pas");
		}
	    
		System.out.println("donner la transition a ajoutee:\n");
	    String tr=sc.nextLine();
	    
	    if(TTS[etat][index].equals("-"))
	    	TTS[etat][index]=tr;
	    else
	        TTS[etat][index]+=","+tr;
	    System.out.println("*******************************Tableau des transitions apres l'ajout****************************************");
	    for(int j = 1; j<TTS.length;j++)
		{
			for(int i = 1; i<TTS[0].length-1;i++)
			System.out.println("transition["+j+"]["+i+"] = "  + TTS[j][i]);
			
	    }
	    
	    return TTS;
	    
	}
	
	public String[][] supp_Tans(String[][] TTS) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*************Supprision*****************");
        String e,s;
		System.out.println("donner l'etat : \n");
		e=sc.nextLine();
		System.out.println("donner le symbole : \n");
		s=sc.nextLine();
        int etat=-1;
		int index=-1;
		for(int i = 1; i<TTS.length; i++) {
			if(e.equals(TTS[i][0])) {
				etat=i;
			}
		}
		for(int i = 1; i<TTS[0].length; i++) {
			if(s.equals(TTS[0][i])) {
			    index=i;
			}
		}
		if(index==-1 || etat==-1) {
			System.out.println("l'etat ou le symbole n'existe pas");
		}
	    
		System.out.println("donner la transition a supprimer:\n");
	    String tr=sc.nextLine();
	    
	    String tab[]=TTS[etat][index].split(",");
	    for(int i=0;i<tab.length;i++) {
	       if(tab[i].equals(tr))
	    	tab[i]="";
	    }
	    TTS[etat][index]="";
	    for(int i=0;i<tab.length;i++) {
	    	    TTS[etat][index]+=tab[i];
		       if(i<tab.length-2)
		    	   TTS[etat][index]+=",";
		    }
	    System.out.println("*******************************Tableau des transitions apres la supression****************************************");
	    for(int j = 1; j<TTS.length;j++)
		{
			for(int i = 1; i<TTS[0].length-1;i++)
			System.out.println("transition["+j+"]["+i+"] = " + TTS[j][i]);
			
	    }
	    
	    return TTS;
		
	}
	
	public void Eps_Fermeture(String e,String[][] TTS) {
		int etat=0;
		for(int i = 1; i<TTS.length; i++) {
			if(e.equals(TTS[i][0])) {
				etat=i;
			}
		}
	    System.out.println("E-fermeture de l'etat est: " +TTS[etat][TTS[0].length]);
	}
	
	
	
	public static void main(String[] args) {
		tp2 A = new tp2();
		String[][] TTS=new String[5][4];
		
		TTS=A.exercice2();
		
		//System.out.println(A.trans_Etat_Symb("0", "a",TTS));
		//A.ajout_Tansv(TTS);
		//A.supp_Tans(TTS);
	    A.Eps_Fermeture("0",TTS);
	}
}
