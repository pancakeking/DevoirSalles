package test;

import java.util.Scanner;

import flux.*;

public class TestFlux {
	
	// Test de Serialize
	// On peut entrer un String spécifique dans le fichier fichTestFlux et le récupérer
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String commande;

		String original;
		try{
			do{
				System.out.println("i, o, q");
				commande = sc.next();
				
				if(commande.equals("i")){
					System.out.println("Entrez la valeur du String");
					original = sc.next();
					DoSerialize.serialize(original, "fichTestFlux");
				}
				else if(commande.equals("o")){
					String retour = (String)DoSerialize.unSerialize("fichTestFlux");
					System.out.println(retour);
				}
			}while(!commande.equals("q"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		sc.close();
	}
}
