package entites;


public class Parametre {

	public Parametre() {

	}



	/**
	 * 
	 * pour avoir les poisition posibile
	 * @author asus
	 *
	 */

	public static enum Orientation {
		NORTH('N', "Nord"),
		EAST('E', "est"),
		WEST('W', "ouest"),
		SOUTH('S', "sud");

		private char codeOrientation;
		private String libelleOrientation;

		private Orientation(char codeOrientation, String libelleOrientation) {
			this.codeOrientation = codeOrientation;
			this.libelleOrientation = libelleOrientation;
		}

		public char getCodeOrientation() {
			return codeOrientation;
		}
		public String getLibelleOrientation() {
			return libelleOrientation;
		}



	}
	
	public static enum InstructionTondeuse{
		DROITE('D', "Pivoter à droite"),
		GAUCHE('G', "Pivoter à gauche"),
		AVANCER('A', "Avancer");
		
		private String libelleInstruction;
		private char codeInstruction;
		private InstructionTondeuse( char codeInstruction,String libelleInstruction) {
			this.libelleInstruction = libelleInstruction;
			this.codeInstruction = codeInstruction;
		}
		
		public String getLibelleInstruction() {
			return libelleInstruction;
		}
		public void setLibelleInstruction(String libelleInstruction) {
			this.libelleInstruction = libelleInstruction;
		}
		public char getCodeInstruction() {
			return codeInstruction;
		}
		public void setCodeInstruction(char codeInstruction) {
			this.codeInstruction = codeInstruction;
		}
		

	}
		
	
	
	public static final String ERREUR_DONNEES_INCORRECTES= "données incorrectes";
	public static final String ERREUR_FICHIER_INEXISTANT= "fichier inexistant";
	public static final String ORIENTATION_INCORRECTE = "orientation incorrecte";
	public static final String INSTRUCTION_INCORRECTE = "instruction incorrecte";
	public static final String POSITION_INCORRECTE = "position incorrecte";
		
		
		
		




}
