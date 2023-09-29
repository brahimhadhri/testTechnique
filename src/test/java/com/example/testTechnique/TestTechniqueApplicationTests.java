package com.example.testTechnique;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.fest.assertions.Assertions.assertThat;

import entites.Parametre;

import java.io.IOException;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

@SpringBootTest
class TestTechniqueApplicationTests {
	
	final String CHEMIN_FICHIER = "./src/main/resources/"; 
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void main_fichier_erreur_args() throws ExceptionTondeuse, IOException {
		TestTechniqueApplication.main("1", "2");
	}
	
	@Test
	public void main_fichier_erreur_fichier_inexistant() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Parametre.ERREUR_FICHIER_INEXISTANT);
		TestTechniqueApplication.main("fichierinexistant");
	}
	
	@Test
	public void main_fichier_erreur_1_ligne() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Parametre.ERREUR_DONNEES_INCORRECTES);
		TestTechniqueApplication.main(CHEMIN_FICHIER + "fichier_ligne_1.txt");
	}
	
	@Test
	public void main_fichier_erreur_2_lignes() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Parametre.ERREUR_DONNEES_INCORRECTES);
		TestTechniqueApplication.main(CHEMIN_FICHIER + "fichier_ligne_2.txt");
	}
	
	
	@Test
	public void main_fichier_erreur_ligne_manquante() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Parametre.ERREUR_DONNEES_INCORRECTES);
		TestTechniqueApplication.main(CHEMIN_FICHIER + "fichier_ligne_manquante.txt");

	}
	
	
	@Test
	public void main_fichier_erreur_fichier_vide() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Parametre.ERREUR_DONNEES_INCORRECTES);
		TestTechniqueApplication.main(CHEMIN_FICHIER + "fichier_vide.txt");

	}
	
	@Test
	public void main_fichier_erreur_fichier_xebia_ko() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Parametre.ERREUR_DONNEES_INCORRECTES);
		TestTechniqueApplication.main(CHEMIN_FICHIER + "fichier_test2.txt");
	}
	
	@Test
	public void main_fichier_erreur_fichier_xebia() throws ExceptionTondeuse, IOException {
		TestTechniqueApplication.main(CHEMIN_FICHIER + "fichier_test1.txt");
		assertThat(TestTechniqueApplication.listResultats).isNotNull();
		assertThat(TestTechniqueApplication.listResultats).hasSize(2).contains("1 3 N").contains("5 1 E");
		
	}

}
