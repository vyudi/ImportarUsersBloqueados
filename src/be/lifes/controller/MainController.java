package be.lifes.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import be.life.model.Profile;

public class MainController  implements Runnable {

	String 	filename;
	int 	idProfile;
	private static ArrayList<Profile> lista; 
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}

	
	
	public MainController(String filename, int idProfile) {
		super();
		this.filename = filename;
		this.idProfile = idProfile;
	}

	public void run () {
		lista = LeitorXlsx.leitor(filename);
	     printLista(idProfile);
	 }
	
	private static void printLista(int idProf){
		int total = lista.size();
		int agora = 0;
		for(Profile profile : lista){
			agora = agora +1;
			System.out.println("Next <><><><><><>");
			System.out.println(agora + " de "+total);
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			System.out.println(dateFormat.format(date));
			
			UserController uc = new UserController();
			String a = uc.profileController(profile,idProf);
			System.out.println(a);
			date = new Date();
			System.out.println(dateFormat.format(date));
				
		}
		System.out.println("acabou...");
	}
}
