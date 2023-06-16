package simonedesignPatterns2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import simonedesignPatterns2.centroControllo.CentroControllo;
import simonedesignPatterns2.exceptions.LivelloFumoInvalidoException;
import simonedesignPatterns2.exceptions.OsservatoreDuplicatoException;
import simonedesignPatterns2.exceptions.OsservatoreNonTrovatoException;
import simonedesignPatterns2.sonda.Sonda;
import simonedesignPatterns2.sonda.SondaConcreta;

@SpringBootApplication
public class U2D11DesignPatterns2Application {

	public static void main(String[] args) {
		SpringApplication.run(U2D11DesignPatterns2Application.class, args);

		Sonda s1 = new SondaConcreta("sonda1", 45.4642, 9.1900);
		Sonda s2 = new SondaConcreta("sonda2", 35.1641, 4.2600);
		Sonda s3 = new SondaConcreta("sonda3", 25.2671, 1.1500);
		CentroControllo c1 = new CentroControllo("http://host");

		try {
			s1.aggiungiOsservatore(c1);
		} catch (OsservatoreDuplicatoException e) {
			e.printStackTrace();
		}

		try {
			s2.aggiungiOsservatore(c1);
		} catch (OsservatoreDuplicatoException e) {
			e.printStackTrace();
		}

		// **************** PROVA OSSERVATORE-DUPLICATO-EXCEPTION*****************
		try {
			s2.aggiungiOsservatore(c1);
		} catch (OsservatoreDuplicatoException e) {
			e.printStackTrace();
		}
		// ****************PROVA OSSERVATORE-NONTROVATO-EXCEPTION*****************
		try {
			s3.rimuoviOsservatore(c1);
		} catch (OsservatoreNonTrovatoException e) {
			e.printStackTrace();
		}
		// ****************PROVA LIVELLO-FUMO-INVALIDO-EXCEPTION******************
		try {
			s1.setLivelloFumo(-4);
		} catch (LivelloFumoInvalidoException e) {
			e.printStackTrace();
		}

		try {
			s1.setLivelloFumo(4);
		} catch (LivelloFumoInvalidoException e) {
			e.printStackTrace();
		}

		try {
			s2.setLivelloFumo(7);
		} catch (LivelloFumoInvalidoException e) {
			e.printStackTrace();
		}
	}

}
