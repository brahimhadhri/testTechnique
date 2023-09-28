package entites;

public class TondeusePosition {

	private Coordonnees coordonneesTondeuse;
	private Parametre.Orientation orientationTondeuse;

	public TondeusePosition(Coordonnees coordonneesTondeuse, Parametre.Orientation orientationTondeuse) {
		
		this.coordonneesTondeuse = coordonneesTondeuse;
		this.orientationTondeuse = orientationTondeuse;
	}

	public Coordonnees getCoordonneesTondeuse() {
		return coordonneesTondeuse;
	}

	public void setCoordonneesTondeuse(Coordonnees coordonneesTondeuse) {
		this.coordonneesTondeuse = coordonneesTondeuse;
	}

	public Parametre.Orientation getOrientationTondeuse() {
		return orientationTondeuse;
	}

	public void setOrientationTondeuse(Parametre.Orientation orientationTondeuse) {
		this.orientationTondeuse = orientationTondeuse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordonneesTondeuse == null) ? 0 : coordonneesTondeuse.hashCode());
		result = prime * result + ((orientationTondeuse == null) ? 0 : orientationTondeuse.hashCode());
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
		TondeusePosition other = (TondeusePosition) obj;
		if (coordonneesTondeuse == null) {
			if (other.coordonneesTondeuse != null)
				return false;
		} else if (!coordonneesTondeuse.equals(other.coordonneesTondeuse))
			return false;
		if (orientationTondeuse != other.orientationTondeuse)
			return false;
		return true;
	}

	
	




}
