package ca.uqam.mgl7460.a2011.hospitalizer.aspects;
import ca.uqam.mgl7460.a2011.hospitalizer.data.*;

public aspect Logging {
	pointcut persist(PersistanceService persistance, Persistable object):
	    call(void PersistanceService.persist(Persistable))
	    && target(persistance)
	    && args(object);
	
	after(PersistanceService persistance, Persistable object) returning: persist(persistance, object) {
	    System.out.println(persistance.getClass().getSimpleName() + " persisted object " + object.getClass().getSimpleName());
	}

}
