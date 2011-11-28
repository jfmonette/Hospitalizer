package ca.uqam.mgl7460.a2011.hospitalizer.data;

import java.util.*;

public class ObjectsStore {
	private Map<Integer, Persistable> objects = new HashMap<Integer, Persistable>();
	
	public void save(Persistable object) {
		if(object.getId() == null)
			object.setId(object.hashCode());
		this.objects.put(object.getId(), object);
	}
	
	public Persistable get(Integer id) {
		return objects.get(id);
	}
	
	public Collection<Persistable> getAll() {
		return objects.values();
	}
	
	public Class getObjectsStoreType() {
		Object[] values = objects.values().toArray();
		return values[0].getClass();
	}

}
