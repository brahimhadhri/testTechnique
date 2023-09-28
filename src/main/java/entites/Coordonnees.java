package entites;
public class Coordonnees {

	private int x ; 
	private int y ;


	public Coordonnees(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Coordonnees other = (Coordonnees) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	} 


	/**
	 * vérifier si les coordonnées de la tondeuse après mouvement sont en dehors de celles 
	 * de la pelouse
	 * @param pCoordonnees 
	 * @return true si les coordonnées de la tondeuse sont à l'intérieur de la pelouse
	 */

	public boolean isHorsCoordonnesMax(Coordonnees pCoordonnees){
		return pCoordonnees.getX() >= 0 
				&& pCoordonnees.getY() >= 0
				&& pCoordonnees.getX() <= this.x
				&& pCoordonnees.getY() <= this.y;
	}



}
