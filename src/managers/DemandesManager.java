package managers;

import java.util.ArrayList;

import persistance.DAODemandes;

public class DemandesManager {

	private DAODemandes dao;
	
	public DemandesManager() {
		super();
		dao = new DAODemandes();
	}
	
	public ArrayList<Demande> getAll(String nomProcessus) {
		return dao.getAll(nomProcessus);
	}

}
