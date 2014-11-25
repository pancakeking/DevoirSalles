package flux;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DoSerialize {

	/**
	 * Prends en paramètre un objet et le nom d'un fichier.
	 * Ecrits l'objet dans le fichier.
	 * On peut par la suite récupérer l'objet avec la méthode unSerialize
	 * 
	 * @throws IOException
	 * @param data							un objet qu'on va écrire sur un fichier
	 * @param fichier						nom du fichier où l'objet sera écrit
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
	 * Prends en paramètre le nom d'un fichier.
	 * Recupère l'objet contenu dans le fichier.
	 * 
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @param fichier						le fichier dans lequel on va chercher l'objet
	 * @return								l'objet qu'on a récupéré dans le fichier
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