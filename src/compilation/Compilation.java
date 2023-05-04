package compilation;

import java.util.ArrayList;
import java.util.Scanner;

public class Compilation {
	
	String[][] exercice1()
	{
		System.out.println("Entrez le nombre d'etats : ");
		Scanner sc = new Scanner(System.in);
		int nbEtat = sc.nextInt();
		System.out.println("Entrez le nombre des symboles : ");
		int nbSymb = sc.nextInt();
		System.out.println("Entrez le nombre des etats finaux : ");
		int nbEtatFin = sc.nextInt();
		String TS[] = new String [nbEtat];
		System.out.println("Entrez tous les symboles des etats : ");
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
		System.out.println("Entrez l'etat initial : ");
		String EtatInt = sc.nextLine();
		String TTS[][] = new String [nbSymb][nbEtat];
		System.out.println("Entrez les transitions : ");
		for(int j = 0; j<TS.length;j++)
		{
			for(int i = 0; i<Ts.length;i++)
			{
				System.out.println("transition ( "+ TS[j]+" , " + Ts[i]+" ) = ");
				TTS[i][j] = sc.nextLine();
				// if (TTS[i][j] == -1)
				// {
				//
				// }
			}
		}
		for(int j = 0; j<TS.length;j++)
		{
			for(int i = 0; i<Ts.length;i++)
			{
			System.out.println("transition (" + TS[j]+ " , " + Ts[i] + " ) = " + TTS[i][j]);
			}
	    }

		int n;
		System.out.println("saisir la longueur du mot");
		n=sc.nextInt();
		String TM[]=new String[n];
		System.out.println("saisir les symboles du mot");
		for(int i = 0;i<n;i++)
		{
			sc.nextLine();
			System.out.print("-");
			TM[i] = sc.nextLine();
		}
		 String e=EtatInt; //A est l’état initial de l’automate 
		 int k =0;
		 String s=TM[0]; // s est un symbole du mot saisi 
		int x = 0;
		int y = 0;
		while(!TTS[x][y].equals("-") || k<n) {
			     
				 e=TTS[x][y]; //e un état de l’automate 
				 k++; 
				 s=TM[k]; 
				 for(int i=0;i<nbSymb;i++) {
			     	 for(int j=0;j<nbEtat;j++) {
					     if(TTS[i][j].equals(s))
					     {
					    	 x=i;
					    	 y=j;
					     }
				     }
				 }
		}	
		 if (TSF.contains(s)) // si e est un état final alors le mot est reconnu
		     System.out.println("le mot est reconnaisable par l'automate "); 
		 else //si non le mot est non reconnu 
			 System.out.println("le mot n'est pas reconnaisable par l'automate ");  
		 return TTS;
}
	
 public void mirmot(String[] mot) {
	 int n=mot.length;
	 for(int i=0;i<n;i++) {
		 System.out.print(mot[n-i-1]);
	 }
 }
 
 public void occu(String[] mot) {
	 int n=mot.length;
	 int c=0,d=0;
	 for(int i=0;i<n;i++) {
		 if(mot[i]=="a")
			 c++;
		 else
			 if(mot[i]=="b")
				 d++;
	 }
	 System.out.println("le nombre des symboles a existent dans le mot est : "+c);
	 System.out.println("le nombre des symboles b existent dans le mot est : "+d);
 }
 static void conj(String[] mot) {
	 int n=mot.length;
	 String pre;
	 String suff;
	 for(int i=0;i<n;i++) {
		 pre="";
		 for(int j=0;j<i;j++) {
		    pre+=mot[j];
		 }
		 suff="";
		 for(int k=i;k<n;k++) {
			suff+=mot[k]; 
		 }
		 System.out.println("le conjugue "+(i+1)+" du mot est : "+suff+pre);
	 }
 }
 static void  pref(String[] mot) {
	 int n=mot.length;
	 String pre;
	 String suff;
	 for(int i=0;i<n;i++) {
		 pre="";
		 for(int j=0;j<i;j++) {
		    pre+=mot[j];
		 }
		 suff="";
		 for(int k=i;k<n;k++) {
			suff+=mot[k]; 
		 }
		 System.out.println("le conjugue "+(i+1)+" du mot est : "+pre);
	 }
 }
 static void suff(String[] mot) {
	 int n=mot.length;
	 String pre;
	 String suff;
	 for(int i=0;i<n;i++) {
		 pre="";
		 for(int j=0;j<i;j++) {
		    pre+=mot[j];
		 }
		 suff="";
		 for(int k=i+1;k<n;k++) {
			suff+=mot[k]; 
		 }
		 System.out.println("le conjugue "+(i+1)+" du mot est : "+suff);
	 }
 }
 public void  Complet() {
	 String[][] TR=new String[5][2];
	 TR=exercice1();
	 for(int i=0;i<5;i++) {
		 for(int j=0;j<2;i++) {
			 if(TR[i][j].equals("-")) 
				 	TR[i][j]="P";	 
		 }
	 }
 }
 
 public ArrayList<String> Complement(ArrayList<String> tSF,String[] etatInt) {
	 int n=etatInt.length;
	 int m=tSF.size();
	 ArrayList<String> t=new ArrayList<>();
	 String[] tab=new String[n+m];
	 tab=etatInt;
	 for(int i=0;i<m;i++) {
		 etatInt[i]=tSF.get(i);
	 }
	 for(int i=0;i<n;i++) {
		 tSF.add(tab[i]);
	 }
	 for(int i=0; i<m ;i++) {
		 t.add(etatInt[i]);
	 }
	 t.add(tSF.get(0));
	 return t;
 }
 
 public void  Miraut(String[][] TR,String[] TE, ArrayList<String> EF, String[] EI) {
	 int n=TE.length;
	
	 String[][] tab=new String[n][3];
	 tab[0]=TE;
	 tab[1]=TR[0];
	 tab[2]=TR[1];
	 String[][] T=new String[n][2];
	 for(int k=0;k<2;k++) {
	 for(int i=0;i<n;i++) {
		 T[i][k]="";
		 int c=0;
		 for(int j=0;j<n;j++) {
			 if(tab[j][k+1]==tab[j][k])
			 {
			     T[i][k]+=tab[j][k];
			     c+=1;
			 }
			
		 }
		 if(c==0)
			 T[i][k]="-";
	  }
	}
 }
 
 public void menu() {
	
	 System.out.println("Entrez le nombre d'etats : ");
		Scanner sc = new Scanner(System.in);
		int nbEtat = sc.nextInt();
		System.out.println("Entrez le nombre des symboles : ");
		int nbSymb = sc.nextInt();
		System.out.println("Entrez le nombre des etats finaux : ");
		int nbEtatFin = sc.nextInt();
		String TS[] = new String [nbEtat];
		System.out.println("Entrez tous les symboles des etats : ");
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
		System.out.println("Entrez l'etat initial : ");
		String EtatInt = sc.nextLine();
		String TTS[][] = new String [nbSymb][nbEtat];
		System.out.println("Entrez les transitions : ");
		for(int j = 0; j<TS.length;j++)
		{
			for(int i = 0; i<Ts.length;i++)
			{
				System.out.println("transition ( "+ TS[j]+" , " + Ts[i]+" ) = ");
				TTS[i][j] = sc.nextLine();
				// if (TTS[i][j] == -1)
				// {
				//
				// }
			}
		}
		for(int j = 0; j<TS.length;j++)
		{
			for(int i = 0; i<Ts.length;i++)
			{
			System.out.println("transition (" + TS[j]+ " , " + Ts[i] + " ) = " + TTS[i][j]);
			}
	    }

		int n;
		System.out.println("saisir la longueur du mot");
		n=sc.nextInt();
		String TM[]=new String[n];
		System.out.println("saisir les symboles du mot");
		for(int i = 0;i<n;i++)
		{
			sc.nextLine();
			System.out.print("-");
			TM[i] = sc.nextLine();
		}
		
		 int k ;
		 System.out.println("si vous voullez lire le mot par l'automate tapper 1\n");
		 System.out.println("si vous voullez le meroir de mot tapper 2\n");
		 System.out.println("si vous voullez afficher les occurances de a et b tapper 3\n");
		 System.out.println("si vous voullez le conjugue de mot tapper 4\n");
		 System.out.println("si vous voullez tout les prefixes du mot tapper 5\n");
		 System.out.println("si vous voullez tout les suffixes du mot tapper 6\n");
		 System.out.println("si vous voullez AFDC tapper 7\n");
		 System.out.println("si vous voullez le complement de l'auutomate tapper 8\n");
		 System.out.println("si vous voullez transformer l'automate en un automate miroir tapper 9\n");
	     k = sc.nextInt();
	 switch (k)
	 {
		 case 1:
		 {
			 String[][]TR=exercice1();
			 break;
		 }
		 case 2:
		 {
			 mirmot(TM);
			 break;
		 }
		 case 3:
		 {
			 occu(TM);
			 break;
		 }
		 case 4:
		 {
			 conj(TM);
			 break;
		 }
		 case 5:
		 {
			 pref(TM);
			 break;
		 }
		 case 6:
		 {
			 suff(TM);
			 break;
		 }
		 case 7:
		 {
			 Complet();
		 }
		 case 8:
		 {
			 String[] EtatI=new String[1];
			 EtatI[0]=EtatInt;
			 ArrayList<String> C = Complement(TSF,EtatI);
			 break;
		 }
		 case 9:
		 {
			 String[] EtatI=new String[1];
			 EtatI[0]=EtatInt;
			 Miraut(TTS,TS,TSF, EtatI);
			 break;
		 }
	 } 
			 
 
 }
   
 
 
 
 
 

	public static void main(String[] args) {
    	 Compilation A= new Compilation();
	         // A.exercice1();
    	 String[] mot=new String[4];
    	 mot[0]="a";
    	 mot[1]="b";
    	 mot[2]="c";
    	 mot[3]="d";
	     suff(mot); 
     }
}
