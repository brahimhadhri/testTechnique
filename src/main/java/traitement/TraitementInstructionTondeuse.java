package traitement;

import entites.Coordonnees;
import entites.Parametre;
import entites.Parametre.InstructionTondeuse;
import entites.Parametre.Orientation;
import entites.TondeusePosition;

public class TraitementInstructionTondeuse {
	
	public TraitementInstructionTondeuse() {
		
	}
	
	
	/**
	 * faire avancer la tondeuse selon les paramétaires passer 
	 * @param positionTondeuse : position initiale de la tondeuse 
	 * @param coordonnesMaxPos : coordonnees de la pelouse - coin superieur droit de la pelouse
	 * @return coordonnees de la tondeuse : nouvelles coordonnees de la tondeuse
	 * @throws ExceptionTondeuse pour catcher les erreurs 
	 */
	
	public static Coordonnees avancerTondeuse(TondeusePosition positionTondeuse, Coordonnees coordonnesMax) throws ExceptionTondeuse{
		Coordonnees coordonneesSuivantes = null;
		int x, y;
		switch (positionTondeuse.getOrientationTondeuse()) {
		case NORTH:
			x = positionTondeuse.getCoordonneesTondeuse().getX();
			y = positionTondeuse.getCoordonneesTondeuse().getY() + 1;
			break;
		case EAST:
			x = positionTondeuse.getCoordonneesTondeuse().getX() + 1;
			y = positionTondeuse.getCoordonneesTondeuse().getY();
			break;
		case SOUTH:
			x = positionTondeuse.getCoordonneesTondeuse().getX();
			y = positionTondeuse.getCoordonneesTondeuse().getY() - 1;
			break;
		case WEST:
			x = positionTondeuse.getCoordonneesTondeuse().getX() - 1;
			y = positionTondeuse.getCoordonneesTondeuse().getY();
			break;
		default:
			throw new ExceptionTondeuse(Parametre.POSITION_INCORRECTE);
		}
		coordonneesSuivantes = new Coordonnees(x, y);
		// si les nouvelles coordonnées sont en dehors de la pelouse, on garde
		// la derniere position connue
		if (coordonneesSuivantes != null
				&& coordonnesMax.isHorsCoordonnesMax(coordonneesSuivantes)) {
			return coordonneesSuivantes;
		} else {
			return positionTondeuse.getCoordonneesTondeuse();
		}
	}
	
	/**
	 * faire pivoter la tondeuse à droite
	 * @param orientation : orientation initiale de la tondeuse
	 * @return nouvelle orientation 
	 * @throws ExceptionTondeuse
	 */
	
	public static Orientation pivoterDroite(Orientation orientation) throws ExceptionTondeuse{
		Orientation orientationSuivante = null ;
		switch (orientation){
			case NORTH : 
				orientationSuivante =  Orientation.EAST;
				break;
			case EAST : 
				orientationSuivante =  Orientation.SOUTH;
				break;
			case SOUTH : 
				orientationSuivante =  Orientation.WEST;
				break;
			case WEST : 
				orientationSuivante =  Orientation.NORTH;
				break;
			default : 
				throw new ExceptionTondeuse(Parametre.ORIENTATION_INCORRECTE);
		}
		return orientationSuivante;		
	}
	
	/**
	 * pivoter la tondeuse à gauche
	 * @param orientation : orientation initale de la tondeuse
	 * @return nouvelle orientation
	 * @throws ExceptionTondeuse
	 */
	public static Orientation pivoterGauche(Orientation orientation) throws ExceptionTondeuse{
		Orientation orientationSuivante = null ;
		switch (orientation){
			case NORTH : 
				orientationSuivante =  Orientation.WEST; 
				break;
			case EAST : 
				orientationSuivante =  Orientation.NORTH; 
				break;
			case SOUTH : 
				orientationSuivante =  Orientation.EAST; 
				break;
			case WEST : 
				orientationSuivante =  Orientation.SOUTH; 
				break;
			default : 
				throw new ExceptionTondeuse(Parametre.ORIENTATION_INCORRECTE);
		}
		return orientationSuivante;		
	}

	/**
	 * executer une seule instruction ( A, D ou G)
	 * @param positionTondeuse
	 * @param instruction
	 * @param coordonnesMax
	 * @throws ExceptionTondeuse
	 */
	public static void executerInstruction(TondeusePosition positionTondeuse, InstructionTondeuse instruction,Coordonnees coordonnesMax) throws ExceptionTondeuse{
		
		switch (instruction){
			case AVANCER : 
				positionTondeuse.setCoordonneesTondeuse(TraitementInstructionTondeuse.avancerTondeuse(positionTondeuse, coordonnesMax)); 
				break;
			case DROITE : 
				positionTondeuse.setOrientationTondeuse(TraitementInstructionTondeuse.pivoterDroite(positionTondeuse.getOrientationTondeuse())); 
				break;
			case GAUCHE : 
				positionTondeuse.setOrientationTondeuse(TraitementInstructionTondeuse.pivoterGauche(positionTondeuse.getOrientationTondeuse())); 
				break;
			default: throw new ExceptionTondeuse(Parametre.INSTRUCTION_INCORRECTE);
		}
	}

}
