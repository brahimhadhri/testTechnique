package entites;

public class Pelouse {
	private Coordonnees posMax ;

	public Pelouse(Coordonnees posMax) {
		super();
		this.posMax = posMax;
	}

	public Coordonnees getPosMax() {
		return posMax;
	}

	public void setPosMax(Coordonnees posMax) {
		this.posMax = posMax;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((posMax == null) ? 0 : posMax.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelouse other = (Pelouse) obj;
		if (posMax == null) {
			if (other.posMax != null)
				return false;
		} else if (!posMax.equals(other.posMax))
			return false;
		return true;
	} 
	
	

}
