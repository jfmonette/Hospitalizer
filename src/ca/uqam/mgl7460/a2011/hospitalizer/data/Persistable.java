package ca.uqam.mgl7460.a2011.hospitalizer.data;

public abstract class Persistable {
	private Integer id;
	
	public final Integer getId() {
		return this.id;
	}
	
	public final void setId(Integer id) {
		this.id = id;
	}
}
