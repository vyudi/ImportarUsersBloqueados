package be.life.main;

import be.lifes.controller.MainController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MainController main = new MainController("global.xlsx", 0);
		Thread thread = new Thread(main);
	    thread.start();

//		MainController main2 = new MainController("global2.xlsx", 0);
//		Thread thread2 = new Thread(main2);
//	    thread2.start();
//    
//	    
//	    MainController main3 = new MainController("SonyBrasil.xlsx", 0);
//		Thread thread3 = new Thread(main3);
//	    thread3.start();
//	    
//	    MainController main4 = new MainController("VictoriasSecret.xlsx", 0);
//		Thread thread4 = new Thread(main4);
//		thread4.start();
//		ArrayList<Integer> lista = new ArrayList<Integer>();
//		TesteController contro = new TesteController();
//		for(int i = 0 ; i < 1000 ; i++){
//			lista.add(contro.getUser());
//		}
//		lista = new ArrayList<Integer>(new HashSet(lista)); 
//		
//		System.out.println(lista.size());
	}
	
	
	
	
}
