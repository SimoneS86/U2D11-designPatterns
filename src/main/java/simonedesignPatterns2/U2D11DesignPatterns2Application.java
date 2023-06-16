package simonedesignPatterns2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import simonedesignPatterns2.centroControllo.CentroControllo;
import simonedesignPatterns2.sonda.Sonda;
import simonedesignPatterns2.sonda.SondaConcreta;

@SpringBootApplication
public class U2D11DesignPatterns2Application {

	public static void main(String[] args) {
		SpringApplication.run(U2D11DesignPatterns2Application.class, args);

		Sonda s1 = new SondaConcreta("sonda1", 45.4642, 9.1900);
		Sonda s2 = new SondaConcreta("sonda2", 35.1641, 4.2600);
		CentroControllo c1 = new CentroControllo("http://host");

		s1.aggiungiOsservatore(c1);
		s2.aggiungiOsservatore(c1);

		s1.setLivelloFumo(4);
		s2.setLivelloFumo(7);

	}

}
