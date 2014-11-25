package flux;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DoSerialize {

	/**
	 * Prends en param�tre un objet et le nom d'un fichier.
	 * Ecrits l'objet dans le fichier.
	 * On peut par la suite r�cup�rer l'objet avec la m�thode unSerialize
	 * 
	 * @throws IOException
	 * @param data							un objet qu'on va �crire sur un fichier
	 * @param fichier						nom du fichier o� l'objet sera �crit
	 * @see unSerialize
	 */
	public static void serialize(Serializable data, String fichier)throws IOException{
		FileOutputStream fos = new FileOutputStream(fichier);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(data);
		oos.close();
		fos.close();
	}

	/**
	 * Prends en param�tre le nom d'un fichier.
	 * Recup�re l'objet contenu dans le fichier.
	 * 
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @param fichier						le fichier dans lequel on va chercher l'objet
	 * @return								l'objet qu'on a r�cup�r� dans le fichier
	 */
	public static Object unSerialize(String fichier)throws ClassNotFoundException, IOException{
		FileInputStream fis = new FileInputStream(fichier);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object data = ois.readObject();
		ois.close();
		fis.close();

		return data;
	}
}