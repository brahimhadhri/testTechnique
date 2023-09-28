package traitement;


import java.util.List;

import entites.Parametre;
import entites.Parametre.InstructionTondeuse;
import entites.Pelouse;
import entites.TondeusePosition;

public class TraitementTondeuse {
	
	private Pelouse pelouse;
	private TondeusePosition tondeusePosition;
	private List<Parametre.InstructionTondeuse> listeInstruction;
	
	
	public TraitementTondeuse(Pelouse pelouse, TondeusePosition tondeusePosition,
			List<InstructionTondeuse> listeInstruction) {
		this.pelouse = pelouse;
		this.tondeusePosition = tondeusePosition;
		this.listeInstruction = listeInstruction;
	}
	public Pelouse getPelouse() {
		return pelouse;
	}
	public void setPelouse(Pelouse pelouse) {
		this.pelouse = pelouse;
	}
	public TondeusePosition getTondeusePosition() {
		return tondeusePosition;
	}
	public void setTondeusePosition(TondeusePosition tondeusePosition) {
		this.tondeusePosition = tondeusePosition;
	}
	
	public List<Parametre.InstructionTondeuse> getListeInstruction() {
		return listeInstruction;
	}
	public void setListeInstruction(List<Parametre.InstructionTondeuse> listeInstruction) {
		this.listeInstruction = listeInstruction;
	}
	public String toString(){
		return 	tondeusePosition.getCoordonneesTondeuse().getX() 
				+ " " 
				+ tondeusePosition.getCoordonneesTondeuse().getY()
				+ " " 
				+ tondeusePosition.getOrientationTondeuse().getCodeOrientation() ;
	}
	

}
