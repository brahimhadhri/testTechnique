package com.example.testTechnique;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import entites.Parametre;
import parcer.ParserTondeuse;
import traitement.ExceptionTondeuse;
import traitement.FormaterLigne;
import traitement.TraitementTondeuse;

@SpringBootApplication
public class TestTechniqueApplication {

	protected static List<String> listResultats;

	public static void main(String[] args) throws ExceptionTondeuse, IOException {

		if (args.length == 1) {
			File file = new File(args[0]);
			TestTechniqueApplication instance = new TestTechniqueApplication();
			listResultats = instance.lancerTraitementsTondeuses(file);
		} else {
			throw new IllegalArgumentException();
		}


		SpringApplication.run(TestTechniqueApplication.class, args);
	}

	private List<String> lancerTraitementsTondeuses(File fichier)
			throws ExceptionTondeuse, IOException {
		if (!fichier.isFile()) {
			throw new ExceptionTondeuse(Parametre.ERREUR_FICHIER_INEXISTANT);
		} else {
			ParserTondeuse parser = new ParserTondeuse();
			Scanner scanner = new Scanner(fichier);
			try {
				traiterPremiereLigne(parser, scanner);
				return traiterLignesSuivantes(parser, scanner);
			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}
		}
	}

	/**
	 * traiter la premiere ligne du fichier
	 * @param parser
	 * @param scanner
	 * @throws ExceptionTondeuse : erreur si le fichier contients moins de 2 lignes
	 */
	protected void traiterPremiereLigne(ParserTondeuse parser, Scanner scanner)
			throws ExceptionTondeuse {
		if (scanner.hasNext()) {
			parser.setPelouse(scanner.nextLine());
		}
		if (!scanner.hasNext()) {
			throw new ExceptionTondeuse(
					Parametre.ERREUR_DONNEES_INCORRECTES);
		}
	}

	/**
	 * 
	 * @param parser
	 * @param scanner
	 * @return la position des tondeuses
	 * @throws ExceptionTondeuse
	 */
	private List<String> traiterLignesSuivantes(ParserTondeuse parser,
			Scanner scanner) throws ExceptionTondeuse {
		List<String> listePositions = new ArrayList<String>();
		while (scanner.hasNext()) {
			// lecture de la positon initiale de la tondeuse
			parser.setTondeuse(scanner.nextLine());

			if (scanner.hasNext()) {
				parser.setInstructions(scanner.nextLine());
				listePositions.add(parserEtLancerTraitement(parser));
			} else {
				throw new ExceptionTondeuse(Parametre.ERREUR_DONNEES_INCORRECTES);
			}
		}
		return listePositions;
	}

	/**
	 * Parser et executer le traitement de la tondeuse
	 * @param parser : l'objet contenant les informations de la tondeuse
	 * @throws ExceptionTondeuse
	 */
	private String parserEtLancerTraitement(ParserTondeuse parser)
			throws ExceptionTondeuse {
		if (!parser.executeParse()) {
			throw new ExceptionTondeuse(Parametre.ERREUR_DONNEES_INCORRECTES);
		} else {
			TraitementTondeuse traitement = new TraitementTondeuse();
			traitement.setPelouse(FormaterLigne
					.formaterLignePelouse(parser.getPelouse()));
			traitement.setTondeusePosition(FormaterLigne
					.formaterLigneTondeuse(parser.getTondeuse()));
			traitement.setListeInstruction(FormaterLigne
					.formaterLigneInstruction(parser.getInstructions()));
			traitement.executerInstructionsTondeuse();;
			System.out.println(traitement);
			return traitement.toString();
		}
	}

}
