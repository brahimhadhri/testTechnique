package parcer;

import entites.Parametre.InstructionTondeuse;
import entites.Parametre.Orientation;

public class ParserDonnees {
	
	
	public ParserDonnees() {
		
	}
	
	
	
	 //parser la position de la tondeuse et son orientation
	 //La position et l'orientation sont fournies sous la forme de 2 chiffres et une lettre,
	 //séparés par un espace
	
	
	public static boolean parseTondeuse(String tondeuse){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Orientation.NORTH.getCodeOrientation())
			.append("|").append(Orientation.SOUTH.getCodeOrientation())
			.append("|").append(Orientation.EAST.getCodeOrientation())
			.append("|").append(Orientation.WEST.getCodeOrientation());
		return tondeuse.matches("(\\d+) (\\d+) (" + stringBuilder.toString()+")");
	}
	
	
	
	 // parser la ligne des instructions
	 // les instructions sont une suite de caractères(G, D, A) sans espaces
	 
	public static boolean parseListInstruction(String instructions){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(").append(InstructionTondeuse.AVANCER.getCodeInstruction())
		.append("|").append(InstructionTondeuse.DROITE.getCodeInstruction())
		.append("|").append(InstructionTondeuse.GAUCHE.getCodeInstruction())
		.append(")+");

		return instructions.matches(stringBuilder.toString());
	}

	
	 // parser la position de la pelouse
	 // la position de la pelouse est sous forme de 2 chiffres séparés par espace
	 
	public static boolean parsePelouse(String pelouse){
		return pelouse.matches("(\\d+) (\\d+)");
	}
	
	
	
	

}
