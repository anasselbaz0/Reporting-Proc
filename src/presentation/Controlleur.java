package presentation;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.UIManager;
import javax.swing.UIManager.*;
import managers.Demande;
import managers.DemandesManager;

public class Controlleur {

	private DemandesManager demandesManager;
	private HashMap<String, Integer> statistiquesDemandes;
	private MainView view;
	
	public Controlleur() {
		super();
		demandesManager = new DemandesManager();
		statistiquesDemandes = new HashMap<String, Integer>();
	}

	public MainView getView() {
		return view;
	}

	public void setView(MainView view) {
		this.view = view;
	}

	
	public void actualiser() {
		int nombreDemandes = this.demandesManager.getAll(null).size();
		ArrayList<String> listProcessus = new ArrayList<String>();
		for (int i = 0; i < nombreDemandes; i++) {
			Demande d = (Demande) this.demandesManager.getAll(null).get(i);
			listProcessus.add(d.getNomProcessus());
		}
		for (int i = 0; i < listProcessus.size(); i++) {
			this.statistiquesDemandes.put(listProcessus.get(i), this.demandesManager.getAll(listProcessus.get(i)).size());
		}
		System.out.println("Actualisation des donnees ...");
	}
	
	private static void enableNimbus() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    System.out.println("Nimbus Error");
		}
	}
	
	public static void main(String[] args) {
		Controlleur cont = new Controlleur();
		cont.actualiser();
		enableNimbus();
		MainView frame = new MainView(cont.statistiquesDemandes);
		cont.setView(frame);
		frame.setCont(cont);
		frame.setVisible(true);
	}

	public HashMap<String, Integer> getStatistiquesDemandes() {
		return statistiquesDemandes;
	}

	
}

