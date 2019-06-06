package managers;

public class Demande {

	private String id;
	private int etat;
	private String nomProcessus;
	private boolean isAccepted;
	private boolean isArchived;
	
	public Demande() {
		super();
	}

	public Demande(String id, int etat, String nomProcessus, boolean isAccepted, boolean isArchived) {
		super();
		this.id = id;
		this.etat = etat;
		this.nomProcessus = nomProcessus;
		this.isAccepted = isAccepted;
		this.isArchived = isArchived;
	}

	public String getNomProcessus() {
		return nomProcessus;
	}

	public void setNomProcessus(String nomProcessus) {
		this.nomProcessus = nomProcessus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public boolean isArchived() {
		return isArchived;
	}

	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}
	
	

}
