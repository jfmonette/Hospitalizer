package ca.uqam.mgl7460.a2011.hospitalizer.data;

import java.io.*;
import java.util.*;

import ca.uqam.mgl7460.a2011.hospitalizer.util.DirectoryReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PersistanceService {
	Map<Class<? extends Persistable>, ObjectsStore> objectsStores = 
			new HashMap<Class<? extends Persistable>, ObjectsStore>();
	
	public PersistanceService() {
		loadObjectsStores();
	}
	
	private void loadObjectsStores() {
		DirectoryReader reader = new DirectoryReader();
		Collection<File> files = reader.getAllFilesInDirectory("./data");
		for (File file : files) {
			loadObjectsStoreFromFile(file);
		}
	}

	private void loadObjectsStoreFromFile(File file) {
		try {
			FileInputStream stream = new FileInputStream (file);
			XStream xstream = new XStream(new DomDriver());
			ObjectsStore store = (ObjectsStore)xstream.fromXML(stream);
			objectsStores.put(store.getObjectsStoreType(), store);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void persist(Persistable object) {
		Class<? extends Persistable> objectClass = object.getClass();
		if (!objectsStores.containsKey(objectClass))
			objectsStores.put(objectClass, new ObjectsStore());
		ObjectsStore store = objectsStores.get(objectClass);
		store.save(object);
		persistToFile(store, objectClass.getSimpleName());
	}
	
	private void persistToFile(ObjectsStore store, String fileName) {
		XStream xstream = new XStream(new DomDriver());
		String xml = xstream.toXML(store);
		try {
			FileWriter fileStream = new FileWriter("./data/" + fileName + "ObjectsStore.xml");
			BufferedWriter out = new BufferedWriter(fileStream);
			out.write(xml);
			out.close();
		}
		catch (IOException ex) {
			System.out.print("Unable to persist objects store to file.");
		}
	}

	public Collection<Persistable> getObjects(Class<? extends Persistable> c) {
		ObjectsStore store = objectsStores.get(c);
		return store.getAll();
	}
	
	public Persistable getObject(Class<? extends Persistable> c, Integer id) {
		ObjectsStore store = objectsStores.get(c);
		return store.get(id);
	}
}
