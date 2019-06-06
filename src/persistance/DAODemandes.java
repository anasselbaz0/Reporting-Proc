package persistance;

import java.util.ArrayList;
import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import managers.Demande;

public class DAODemandes {

	private Database db;
	private MongoCollection<Document> collection;
	
	public DAODemandes() {
		super();
		db = new Database();
		MongoDatabase mongodb = db.getConnection();
		collection = mongodb.getCollection("demandes");
	}

	public ArrayList<Demande> getAll(String nomProcessus) {
		FindIterable<Document> demandes;
		if (nomProcessus != null)
			demandes = collection.find(new BasicDBObject("processusName", nomProcessus));
		else 
			demandes = collection.find();
		ArrayList<Demande> out = new ArrayList<Demande>();
		ArrayList<Object> values;
		for (Document document : demandes) {
			values = new ArrayList<>(document.values());
			out.add( new Demande( values.get(0).toString(), (int)values.get(5), (String)values.get(2), (boolean)values.get(6), (boolean)values.get(7) ) );
		}
		return out;
	}

}
