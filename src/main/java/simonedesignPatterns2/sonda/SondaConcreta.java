package simonedesignPatterns2.sonda;

import java.util.ArrayList;
import java.util.List;

import simonedesignPatterns2.centroControllo.Osservatore;
import simonedesignPatterns2.exceptions.LivelloFumoInvalidoException;
import simonedesignPatterns2.exceptions.OsservatoreDuplicatoException;
import simonedesignPatterns2.exceptions.OsservatoreNonTrovatoException;

public class SondaConcreta implements Sonda {
	private String id;
	private double latitudine;
	private double longitudine;
	private int livelloFumo;
	private List<Osservatore> osservatori;

	public SondaConcreta(String id, double latitudine, double longitudine) {
		this.id = id;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.livelloFumo = 0;
		this.osservatori = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public double getLatitudine() {
		return latitudine;
	}

	public double getLongitudine() {
		return longitudine;
	}

	public int getLivelloFumo() {
		return livelloFumo;
	}

	public void setLivelloFumo(int livelloFumo) throws LivelloFumoInvalidoException {
		if (livelloFumo < 0) {
			throw new LivelloFumoInvalidoException("Il livello di fumo non può essere negativo.");
		}
		this.livelloFumo = livelloFumo;
		notificaOsservatori();
	}

	public void aggiungiOsservatore(Osservatore osservatore) throws OsservatoreDuplicatoException {
		if (osservatori.contains(osservatore)) {
			throw new OsservatoreDuplicatoException("L'osservatore è già stato aggiunto.");
		}
		osservatori.add(osservatore);
	}

	public void rimuoviOsservatore(Osservatore osservatore) throws OsservatoreNonTrovatoException {
		if (!osservatori.remove(osservatore)) {
			throw new OsservatoreNonTrovatoException("L'osservatore non è stato trovato.");
		}
	}

	public void notificaOsservatori() {
		for (Osservatore o : osservatori) {
			try {
				o.aggiorna(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
